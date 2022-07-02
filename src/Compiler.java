import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import classes.*;
import org.stringtemplate.v4.*;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Compiler extends QuizzBaseVisitor<ST> {

   private final Map<String, VType> declaredVariables = new HashMap<>();

   @Override public ST visitProgram(QuizzParser.ProgramContext ctx) {
      ST module = templates.getInstanceOf("module");

      for (QuizzParser.StatementContext statementContext : ctx.statement()) {
         ST res = visit(statementContext);
         if (res != null)
            module.add("stat", res.render());
      }

      return module;
   }

   @Override public ST visitExpr(QuizzParser.ExprContext ctx) {
      ST res = visitChildren(ctx);

      if (ctx.methods() != null) {
         ctx.var = ctx.methods().var;
         ctx.tp = ctx.methods().tp;
      }
      else if (ctx.attribute() != null) {
         ctx.var = ctx.attribute().var;
         ctx.tp = ctx.attribute().tp;
      }
      else if (ctx.operation() != null) {
         ctx.var = ctx.operation().var;
         ctx.tp = ctx.operation().tp;
      }

      return res;
   }

   @Override public ST visitStatement(QuizzParser.StatementContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitDeclAssign(QuizzParser.DeclAssignContext ctx) {
      ST res = templates.getInstanceOf("stats");

      ST visitExpr = visit(ctx.expr());

      if (!declaredVariables.containsKey(ctx.expr().var))
          res.add("stat", visitExpr.render());

      // The declaration may include parametrized types
      ST dec = templates.getInstanceOf("pdecl");

      // In case it is specifically an integer, otherwise use Double
      if (ctx.VarType().getText().equals("Number") && ctx.expr().tp instanceof IntegerVType)
         dec.add("type", new IntegerVType());
      // In case it is a table, where we also need to get its elements' types
      else if (ctx.expr().tp instanceof TableVType) {
         dec.add("type", ctx.expr().tp);
         dec.add("ptype", ((TableVType) ctx.expr().tp).getElemType());
      }
      else
         dec.add("type", ctx.VarType().getText());
      dec.add("var", ctx.ID().getText());
      dec.add("expr", ctx.expr().var);

      res.add("stat", dec.render());

      declaredVariables.put(ctx.ID().getText(), ctx.expr().tp);

      return res;
   }

   @Override public ST visitAssign(QuizzParser.AssignContext ctx) {
      ST res = templates.getInstanceOf("stats");

      ST visitExpr = visit(ctx.expr());

      if (!declaredVariables.containsKey(ctx.expr().var))
          res.add("stat", visitExpr.render());

      ST assign = templates.getInstanceOf("assign");
      assign.add("var", ctx.ID().getText());
      assign.add("expr", ctx.expr().var);

      res.add("stat", assign.render());

      declaredVariables.put(ctx.ID().getText(), ctx.expr().tp);

      return res;
   }

   @Override public ST visitDecl(QuizzParser.DeclContext ctx) {
      ST res = templates.getInstanceOf("pdecl");

      String varName = ctx.ID().getText();
      res.add("type", ctx.VarType().getText());
      res.add("var", varName);

      declaredVariables.put(varName, VType.fromString(ctx.VarType().getText()));

      return res;
   }

   @Override public ST visitQuiz(QuizzParser.QuizContext ctx) {
      ST res = templates.getInstanceOf("with_new");
      res.add("type", "Quiz");
      //iterar pelos elems do context
      for (QuizzParser.ExprContext Expr: ctx.expr()){
      	ST chi = visit(Expr);
      	res.add("stat", chi);
      	res.add("elem", Expr.var);
      }
      
      return res;
   }

   @Override public ST visitQuestion(QuizzParser.QuestionContext ctx) {
      ST res = templates.getInstanceOf("with_new");
      res.add("type", "Question");
      //iterar pelos elems do context
      for (QuizzParser.ExprContext Expr: ctx.expr()){
      	ST chi = visit(Expr);
      	res.add("stat", chi);
      	res.add("elem", Expr.var);
      }
      
      return res;
      
   }

   @Override public ST visitTextString(QuizzParser.TextStringContext ctx) {
      ST res = templates.getInstanceOf("decl");

      res.add("type", "Text");
      res.add("expr", ctx.String().getText());

      return res;

   }

   @Override public ST visitTextExpr(QuizzParser.TextExprContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ST visitExpr = visit(ctx.expr());

      if (!declaredVariables.containsKey(ctx.expr().var))
          res.add("stat", visitExpr.render());

      res.add("type", "Text");
      res.add("expr", ctx.expr().var);

      return res;

   }

   @Override public ST visitNumberValue(QuizzParser.NumberValueContext ctx) {
      ST res = templates.getInstanceOf("decl");

      res.add("type", ctx.tp.name());
      //res.add("var", ctx.var);
      res.add("expr", visit(ctx.value()).render());

      return res;
   }

   @Override public ST visitNumberExpr(QuizzParser.NumberExprContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ST visitExpr = visit(ctx.expr());

      if (!declaredVariables.containsKey(ctx.expr().var))
          res.add("stat", visitExpr.render());

      res.add("type", ctx.tp.name());
      //dec.add("var", ctx.var);

      ST cst = templates.getInstanceOf("cast");
      cst.add("type", ctx.tp.name());
      cst.add("expr", ctx.expr().var);

      res.add("expr", cst.render());

      return res;
   }

   @Override public ST visitTable(QuizzParser.TableContext ctx) {
      ST res = templates.getInstanceOf("table");

      // Used to check if, in the list initialization, at least one of the is double.
      // This is used in case Integers are mixed with Doubles, in which case the table's elem type is Double.
      boolean hasDouble = false;
      if (ctx.expr().size() > 0) {
         for (QuizzParser.ExprContext exprContext : ctx.expr()) {
             ST visitExpr = visit(exprContext);
             if (!declaredVariables.containsKey(exprContext.var))
                res.add("stat", visitExpr.render());
             res.add("elem", exprContext.var);

             if (exprContext.tp instanceof DoubleVType)
                hasDouble = true;
         }

         if (hasDouble)
            ctx.tp.setElemType(new DoubleVType());
         else
            ctx.tp.setElemType(ctx.expr(0).tp);
      }
      else {
          ctx.tp.setElemType(VType.fromString(ctx.VarType().getText()));
      }

      res.add("type", ctx.tp.getElemType());

      return res;
   }

   @Override public ST visitBquest(QuizzParser.BquestContext ctx) {
      ST res = templates.getInstanceOf("bquestDecl");
      /*ST visitExpr = visit(ctx.expr());

      if (!declaredVariables.containsKey(ctx.expr().var))
         res.add("stat", visitExpr.render());

      BQuest bquest = SecondaryMain.extract(ctx.expr().var);*/
      String fname = ctx.fname.getText();
      BQuest bquest = SecondaryMain.extract(fname.substring(1,fname.length()-1));
      // TODO: Análise semântica?
      if (bquest == null) {
         System.err.println("Error: the specified bquest file could not be properly read!");
         System.exit(1);
      }

      for (Question question : bquest.getQuestions()) {
         ST quest = templates.getInstanceOf("question");

         String content = question.getContent();
         String theme = question.getTheme();
         Difficulty diff = Difficulty.fromNum(question.getDifficulty());
         quest.add("content", content);
         quest.add("theme", theme);
         quest.add("difficulty", "Difficulty." + diff);

         Type type = question.getType();
         ArrayList<String> keywords = type.getKeywords();
         ArrayList<String> options = type.getOptions();
         quest.add("typeName", type.getClass().getSimpleName());
         for (String keyword : keywords)
            quest.add("keyword", keyword);
         for (String option : options)
            quest.add("option", option);

         res.add("question", quest.render());
      }

      return res;
   }

   @Override public ST visitNumInt(QuizzParser.NumIntContext ctx) {
      ST res = new ST("<v>").add("v", ctx.getText());
      return res;
   }

   @Override public ST visitNumDouble(QuizzParser.NumDoubleContext ctx) {
      ST res = new ST("<v>").add("v", ctx.getText());
      return res;
   }

   @Override public ST visitMultipleChoice(QuizzParser.MultipleChoiceContext ctx) {
      ST res = templates.getInstanceOf("with_new");
      res.add("type", "MultipleChoice");
      //iterar pelos elems do context
      for (QuizzParser.ExprContext Expr: ctx.expr()){
      	ST chi = visit(Expr);
      	res.add("stat", chi);
      	res.add("elem", Expr.var);
      }
      
      return res;
   }

   @Override public ST visitMatching(QuizzParser.MatchingContext ctx) {
      ST res = templates.getInstanceOf("with_new");
      res.add("type", "Matching");
      //iterar pelos elems do context
      for (QuizzParser.ExprContext Expr: ctx.expr()){
      	ST chi = visit(Expr);
      	res.add("stat", chi);
      	res.add("elem", Expr.var);
      }
      
      return res;
   }

   @Override public ST visitShortAnswer(QuizzParser.ShortAnswerContext ctx) {
      ST res = templates.getInstanceOf("with_new");
      res.add("type", "ShortAnswer");
      //iterar pelos elems do context
      for (QuizzParser.ExprContext Expr: ctx.expr()){
      	ST chi = visit(Expr);
      	res.add("stat", chi);
      	res.add("elem", Expr.var);
      }
      
      return res;
   }

   @Override public ST visitNumericAnswer(QuizzParser.NumericAnswerContext ctx) {
      ST res = templates.getInstanceOf("with_new");
      res.add("type", "NumericAnswer");
      //iterar pelos elems do context
      if (ctx.expr() != null){
      	ST chi = visit(ctx.expr());
      	res.add("stat", chi);
      	res.add("elem", ctx.expr().var);
      }
      
      return res;
   }

   @Override public ST visitEssay(QuizzParser.EssayContext ctx) {
      ST res = templates.getInstanceOf("with_new");
      res.add("type", "Essay");
      //iterar pelos elems do context
      if (ctx.expr() != null){
      	ST chi = visit(ctx.expr());
      	res.add("stat", chi);
      	res.add("elem", ctx.expr().var);
      }
      
      return res;
   }

   @Override public ST visitAttribute(QuizzParser.AttributeContext ctx) {
      ST res = visitChildren(ctx);

      if (ctx.ID() != null) {
         ctx.var = ctx.ID().getText();
         ctx.tp = declaredVariables.get(ctx.var);
         res = new ST("<v>").add("v", ctx.ID().getText());
      }
      else {
         ctx.var = newVar();
         res.add("var", ctx.var);
      }

      // Or else the table's element type will be lost
      if (ctx.table() != null) {
         ctx.tp = ctx.table().tp;
      }
      else if (ctx.shuffle() != null) {
         ctx.tp = ctx.shuffle().tp;
      }

      return res;
   }

   @Override public ST visitShuffle(QuizzParser.ShuffleContext ctx) {
      ST res = templates.getInstanceOf("shuffle");
      ST visitExpr = visit(ctx.expr());

      // If this table is empty, don't even bother to shuffle it
      VType elemTp = ((TableVType) ctx.expr().tp).getElemType();
      ctx.tp.setElemType(elemTp);

      if (!declaredVariables.containsKey(ctx.expr().var))
          res.add("stat", visitExpr.render());

      res.add("table", ctx.expr().var);
      res.add("type", ((TableVType) ctx.expr().tp).getElemType());

      return res;
   }

   @Override public ST visitInput(QuizzParser.InputContext ctx) {
      ST res = templates.getInstanceOf("input");
      ST visitExpr = visit(ctx.expr());

      if (!declaredVariables.containsKey(ctx.expr().var))
          res.add("stat_before", visitExpr.render());

      res.add("text", ctx.expr().var);

      return res;
   }

   @Override public ST visitOutput(QuizzParser.OutputContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ST visitExpr = visit(ctx.expr());

      if (!declaredVariables.containsKey(ctx.expr().var))
          res.add("stat", visitExpr.render());

      ST out = templates.getInstanceOf("output");
      out.add("text", ctx.expr().var);

      res.add("stat", out.render());

      return res;
   }

   @Override public ST visitBreakOperation(QuizzParser.BreakOperationContext ctx) {
      return templates.getInstanceOf("stats").add("stat", "break;");
   }

   @Override public ST visitNumericIteration(QuizzParser.NumericIterationContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ST visitExpr1 = visit(ctx.expr(0));
      ST visitExpr2 = visit(ctx.expr(1));

      if (!declaredVariables.containsKey(ctx.expr(0).var))
          res.add("stat", visitExpr1.render());
      if (!declaredVariables.containsKey(ctx.expr(1).var))
          res.add("stat", visitExpr2.render());
      
      ST fit = templates.getInstanceOf("forIter");

      fit.add("begin", ctx.expr(0).var);
      fit.add("end", ctx.expr(1).var);
      fit.add("var", ctx.ID().getText());

      // The cycle's var. May have out-of-scope problems...
      declaredVariables.put(ctx.ID().getText(), new IntegerVType());

      for (QuizzParser.StatementContext statementContext : ctx.statement())
         fit.add("stat", visit(statementContext).render());

      res.add("stat", fit.render());

      return res;
   }

   @Override public ST visitTableIteration(QuizzParser.TableIterationContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ST exprVisit = visit(ctx.expr());

      // Check the table's elements' type. If it's not set, then this table should be
      // empty, and so we completely ignore the loop (like it normally would)
      VType elemTp = ((TableVType) ctx.expr().tp).getElemType();

      if (!declaredVariables.containsKey(ctx.expr().var))
         res.add("stat", exprVisit.render());

      ST fea = templates.getInstanceOf("forEach");
      fea.add("var", ctx.ID().getText());
      // TODO this verification may not be needed...?
      VType tp;
      if (ctx.expr().tp instanceof TableVType)
         tp = ((TableVType) ctx.expr().tp).getElemType();
      else
         tp = ctx.expr().tp;
      fea.add("type", tp.name());
      fea.add("set", ctx.expr().var);

      // The cycle's var. May also have out-of-scope problems...
      declaredVariables.put(ctx.ID().getText(), tp);

      for (QuizzParser.StatementContext statementContext : ctx.statement())
         fea.add("stat", visit(statementContext).render());

      res.add("stat", fea.render());

      return res;
   }

   @Override public ST visitCondition(QuizzParser.ConditionContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ST visitLog = visit(ctx.logic());

      if (!declaredVariables.containsKey(ctx.logic().var))
          res.add("stat", visitLog.render());

      ST ifs = templates.getInstanceOf("ifStat");

      ifs.add("logic", ctx.logic().var);
      for (QuizzParser.StatementContext statementContext : ctx.statement())
         ifs.add("stat", visit(statementContext).render());

      res.add("stat", ifs.render());

      return res;
   }

   @Override public ST visitItem(QuizzParser.ItemContext ctx) {
      ST res = visit(ctx.attribute());

      ctx.var = ctx.attribute().var;
      ctx.tp = ctx.attribute().tp;

      return res;
   }

   @Override public ST visitMulDivMod(QuizzParser.MulDivModContext ctx) {
      ctx.var = newVar();

      if (ctx.op.getText().equals("*") || ctx.op.getText().equals("/"))
         ctx.tp = new DoubleVType();
      else
         ctx.tp = ctx.operation(0).tp;

      return binaryExpression(ctx.tp.name(), ctx.var, ctx.op.getText(), ctx.operation(0), ctx.operation(1));
   }

   @Override public ST visitExponent(QuizzParser.ExponentContext ctx) {
      ST res = templates.getInstanceOf("power");
      ST visitOp1 = visit(ctx.operation(0));
      ST visitOp2 = visit(ctx.operation(1));

      if (!declaredVariables.containsKey(ctx.operation(0).var))
          res.add("stat", visitOp1.render());
      if (!declaredVariables.containsKey(ctx.operation(1).var))
          res.add("stat", visitOp2.render());

      ctx.var = newVar();
      ctx.tp = ctx.operation(0).tp;

      res.add("type", ctx.tp.name());
      res.add("var", ctx.var);
      res.add("e1", ctx.operation(0).var);
      res.add("e2", ctx.operation(1).var);

      return res;
   }

   @Override public ST visitParenthesisOper(QuizzParser.ParenthesisOperContext ctx) {
      ST res = visit(ctx.operation());
      ctx.var = ctx.operation().var;
      ctx.tp = ctx.operation().tp;

      return res;
   }

   @Override public ST visitSignOper(QuizzParser.SignOperContext ctx) {
      ST res = templates.getInstanceOf("decl");
      ST visitOp = visit(ctx.operation());
      if (!declaredVariables.containsKey(ctx.operation().var))
        res.add("stat", visitOp.render());

      ctx.var = newVar();
      ctx.tp = ctx.operation().tp;
      res.add("type", ctx.tp.name());
      res.add("var", ctx.var);
      res.add("expr", ctx.sign.getText() + ctx.operation().var);

      return res;
   }

   @Override public ST visitAddSubtract(QuizzParser.AddSubtractContext ctx) {
      ctx.var = newVar();
      ST res = binaryExpression(ctx.var, ctx.op.getText(), ctx.operation(0), ctx.operation(1));
      ctx.tp = ctx.operation(0).tp;

      return res;
   }

   @Override public ST visitVarComp(QuizzParser.VarCompContext ctx) {
      ctx.var = newVar();

      String oper = ctx.op.getText();

      ST res = templates.getInstanceOf("logicExpression");
      ST visitExpr1 = visit(ctx.expr(0));
      ST visitExpr2 = visit(ctx.expr(1));
      if (!declaredVariables.containsKey(ctx.expr(0).var))
         res.add("stat", visitExpr1.render());
      if (!declaredVariables.containsKey(ctx.expr(1).var))
         res.add("stat", visitExpr2.render());

      res.add("var", ctx.var);
      res.add("e1", ctx.expr(0).var);
      res.add("e2", ctx.expr(1).var);
      res.add("op", oper);

      switch (oper) {
          case "<":
              res.add("extra", " < 0");
              break;
          case ">":
              res.add("extra", " > 0");
              break;
          case "<=":
              res.add("extra", " <= 0");
              break;
          case ">=":
              res.add("extra", " >= 0");
              break;
          case "!=":
              res.add("extra", " == false");
              break;
      }

      return res;
   }

   @Override public ST visitNotCond(QuizzParser.NotCondContext ctx) {
      ST res = templates.getInstanceOf("decl");
      res.add("stat", visit(ctx.logic()).render());

      ctx.var = newVar();
      res.add("type", "Boolean");
      res.add("var", ctx.var);

      ST nco = templates.getInstanceOf("notCond");
      nco.add("logic", ctx.logic().var);

      res.add("expr", nco.render());

      return res;
   }

   @Override public ST visitCondComp(QuizzParser.CondCompContext ctx) {
      ST res = templates.getInstanceOf("boolExpression");
      res.add("stat", visit(ctx.logic(0)).render());
      res.add("stat", visit(ctx.logic(1)).render());

      ctx.var = newVar();

      res.add("var", ctx.var);
      res.add("e1", ctx.logic(0).var);
      res.add("op", ctx.op.getText());
      res.add("e2", ctx.logic(1).var);

      return res;
   }

   @Override public ST visitParenthesisCond(QuizzParser.ParenthesisCondContext ctx) {
      ST res = templates.getInstanceOf("stats");

      res.add("stat", visit(ctx.logic()).render());

      ST dec = templates.getInstanceOf("decl");
      ctx.var = newVar();
      dec.add("type", "boolean");
      dec.add("var", ctx.var);
      dec.add("expr", ctx.logic().var);

      res.add("stat", dec.render());

      return res;
   }

   @Override public ST visitSingleId(QuizzParser.SingleIdContext ctx) {
      ctx.var = ctx.ID().getText();
      ctx.tp = declaredVariables.get(ctx.var);

      return new ST("<v>").add("v", "");
   }

   @SuppressWarnings("deprecation")
   @Override public ST visitMethod(QuizzParser.MethodContext ctx) {
      
      ST method = templates.getInstanceOf("method");

      ST children = visit(ctx.methods());
      ST res = templates.getInstanceOf("stats");
      
      res.add("stat", children.render());
      
      String id;
      int first;
      ST converter;
      String type;
      Class<?> c;
      String ReturnType;
      switch (ctx.MethodTypes().getText()) {
         case ">>":
            method.add("var", ctx.methods().var);
            method.add("type", ".");
            id = ctx.expr(0).getText();
            id = id.substring(0,1).toUpperCase() + id.substring(1, id.length());
            if (ctx.methods().tp.name().equals("Table")){
                id = "";
            	res.add("stat", visit(ctx.expr(0)));            		
            	method.add("args", ctx.expr(0).var);
            }
            else{
            	id = ctx.expr(0).getText();
            	id = id.substring(0,1).toUpperCase() + id.substring(1, id.length());
            }
            id = "get" + id;
            method.add("id", id);
            if (!ctx.methods().tp.name().equals("Table")){
            //converto o nome do tp para um nome de uma classe Java
            converter = templates.getInstanceOf("converter");
            type = ctx.methods().tp.name();
            converter.add("type", type);
            type = converter.render();
            //obtenho a Classe do nome que veio do passo anterior
            try{
            	//se estiver na pasta classes
            	c = Class.forName("classes." + type);
            }
            catch (ClassNotFoundException e) {
            	try{
            	//se não estiver nessa pasta
            	 c = Class.forName(type);
            	}
            	catch (ClassNotFoundException f) {
            	 break;
            	}
            }
            // obtenho o tipo retornado pelo metodo a ser chamado
            ReturnType = "";
            for (Method m : c.getDeclaredMethods()){
            	if (m.getName().equals(id)){
            	    ReturnType = m.getReturnType().getName();
            	}
            }
            }
            else{
	        TableVType temp = (TableVType) ctx.methods().tp;
	        converter = templates.getInstanceOf("converter");
	        ReturnType = ((TableVType) ctx.methods().tp).getElemType().name();
	        converter.add("type", ReturnType);
	        ReturnType = converter.render();
	        try{
	        c = Class.forName("java.util.List");
            	}
            	catch (ClassNotFoundException e) {
            		break;
            	}
            }
            //apenas se encontrou um tipo, e este não é void, continuo
            	if (!ReturnType.equals("")){
            	if (!ReturnType.equals("void")){
            	//se o nome tiver um ., então só preciso da ultima parte do nome
            	if (ReturnType.contains(".")){
            	    int size = ReturnType.split("\\.").length;
            	    ReturnType = (ReturnType.split("\\."))[size-1];
            	    }
            	                	    //atraves de um enum, obtenho o nome da classe na nossa linguagem
            	    String rollback_type = Types.valueOf("C" + ReturnType).getValue();
            	    //encontro o VType desta classe
		    VType vt = VType.fromString(rollback_type);
		    ctx.tp = vt;
		    String elemType = "";
            	    //encontro o tipo dos elementos da tabela
                   if (rollback_type.equals("Table") && !ctx.methods().tp.name().equals("Table")){
            	        for (Field f : c.getDeclaredFields()){
            	    	    if (f.getName().equals(ctx.expr(0).getText().toLowerCase())){
            	    	        TableVType tvt = new TableVType();
            	    	        elemType = f.getGenericType().getTypeName();
            	    	        int size_2 = elemType.split("\\.").length;
            	    	        elemType = elemType.split("\\.")[size_2-1];
            	    	        elemType = elemType.substring(0, elemType.length()-1);
            	    	        elemType = Types.valueOf("C" + elemType).getValue();
                  		tvt.setElemType(VType.fromString(elemType));
                  		ctx.tp = tvt;
            	    	    }
            	        }
            	    }
            	    else if(rollback_type.equals("Table")){
            	    	ctx.tp = ((TableVType) ctx.methods().tp).getElemType();
            	    }
            	    //crio um decl e preencho
		    ST dec = templates.getInstanceOf("pdecl");
            	    dec.add("type", ReturnType);
            	    ctx.var = newVar();
            	    dec.add("var", ctx.var);
            	    if (!elemType.equals("")){
            	        dec.add("ptype", elemType);
            	    }
            	    dec.add("expr", method);
            	    //coloco o decl no stat
            	    res.add("stat", dec);
               }
           }
           //se não encontrou um return type ou se era void, adiciono o method diretamente ao stat
           else{
               res.add("stat", method);
           }
           break;
         case "<<":
            method.add("var", ctx.methods().var);
            method.add("type", ".set");
            id = ctx.expr(0).getText();
            id = id.substring(0,1).toUpperCase() + id.substring(1, id.length());
            if (ctx.methods().tp.name().equals("Table")){
                id = "";
                first = 1;
            }
            else{
            	id = ctx.expr(0).getText();
            	id = id.substring(0,1).toUpperCase() + id.substring(1, id.length());
            	first = 0;
            }
            method.add("id", id);
            method.add("final", ";");
            for (QuizzParser.ExprContext Expr: ctx.expr()){
            	if (first == 0){
            	    first = first + 1;
            	}
            	else{	
            	res.add("stat", visit(Expr));
            	method.add("args", Expr.var);
            	}
            }
            res.add("stat", method);
            break;
         case "<+":
            method.add("var", ctx.methods().var);
            method.add("type", ".add");
            id = ctx.expr(0).getText();
            id = id.substring(0,1).toUpperCase() + id.substring(1, id.length());
            if (ctx.methods().tp.name().equals("Table")){
                id = "";
                first = 1;
            }
            else{
            	id = ctx.expr(0).getText();
            	id = id.substring(0,1).toUpperCase() + id.substring(1, id.length());
            	first = 0;
            }
            method.add("id", id);
            method.add("final", ";");
            for (QuizzParser.ExprContext Expr: ctx.expr()){
            	if (first == 0){
            	    first = first + 1;
            	}
            	else{	
            	res.add("stat", visit(Expr));
            	method.add("args", Expr.var);
            	}
            }
            res.add("stat", method);
            // If adding to a table and that table is empty, give it a type
            /*if (ctx.methods().var != null) {
               TableVType tp = (TableVType) declaredVariables.get(ctx.methods().var);
               tp.setElemType(ctx.expr(0).tp);
            }*/ //codigo nao vai funcionar por causa de alterações no metodo, irei resolver
            break;
         
         case "<-":
            method.add("var", ctx.methods().var);
            method.add("type", ".remove");
            if (ctx.methods().tp.name().equals("Table")){
                id = "";
                first = 1;
            }
            else{
            	id = ctx.expr(0).getText();
            	id = id.substring(0,1).toUpperCase() + id.substring(1, id.length());
            	first = 0;
            }
            method.add("id", id);
            method.add("final", ";");
            for (QuizzParser.ExprContext Expr: ctx.expr()){
            	if (first == 0){
            	    first = first + 1;
            	}
            	else{	
            	res.add("stat", visit(Expr));
            	method.add("args", Expr.var);
            	}
            }
            res.add("stat", method);
            break;
         
         case "::":
            if (ctx.methods().tp.name().equals("Text")){
                if (ctx.ID().getText().toLowerCase().equals("tonumber")){
                    method.add("var", "Double");
                    method.add("type", ".");
                    method.add("id", "parseDouble");
                    method.add("args", ctx.methods().var);
                    ST decla = templates.getInstanceOf("decl");
                    decla.add("type", "Double");
                    ctx.var = newVar();
                    decla.add("var", ctx.var);
                    decla.add("expr", method);
                    res.add("stat", decla);
                    ctx.tp = new DoubleVType();
                    break;
                }
            }
            method.add("var", ctx.methods().var);	
            method.add("type", ".");
            id = ctx.ID().getText();
            method.add("id", id);
            for (QuizzParser.ExprContext Expr: ctx.expr()) {
               res.add("stat", visit(Expr));
               method.add("args", Expr.var);
            }
            if (!ctx.methods().tp.name().equals("Table")){
            //converto o nome do tp para um nome de uma classe Java
            converter = templates.getInstanceOf("converter");
            type = ctx.methods().tp.name();
            converter.add("type", type);
            type = converter.render();
            }
            else{
            	type = "java.util.List";
            }
            //obtenho a Classe do nome que veio do passo anterior
            try{
            	//se estiver na pasta classes
            	c = Class.forName("classes." + type);
            }
            catch (ClassNotFoundException e) {
            	try{
            	//se não estiver nessa pasta
            	 c = Class.forName(type);
            	}
            	catch (ClassNotFoundException f) {
            	 break;
            	}
            }
            // obtenho o tipo retornado pelo metodo a ser chamado
            ReturnType = "";
            for (Method m : c.getDeclaredMethods()){
            	if (m.getName().equals(id)){
            	    ReturnType = m.getReturnType().getName();
            	}
            }
            //apenas se encontrou um tipo, e este não é void, continuo
            	if (!ReturnType.equals("")){
            	if (!ReturnType.equals("void")){
            	//se o nome tiver um ., então só preciso da ultima parte do nome
            	if (ReturnType.contains(".")){
            	    int size = ReturnType.split("\\.").length;
            	    ReturnType = (ReturnType.split("\\."))[size-1];
            	    }
            	    //crio um decl e preencho
		    ST dec = templates.getInstanceOf("decl");
            	    dec.add("type", ReturnType);
            	    ctx.var = newVar();
            	    dec.add("var", ctx.var);
            	    dec.add("expr", method);
            	    //coloco o decl no stat
            	    res.add("stat", dec);
            	    //atraves de um enum, obtenho o nome da classe na nossa linguagem
            	    String rollback_type = Types.valueOf("C" + ReturnType).getValue();
            	    //encontro o VType desta classe
            	    VType vt = VType.fromString(rollback_type);
            	    ctx.tp = vt;
               }
           }
           //se não encontrou um return type ou se era void, adiciono o method diretamente ao stat
           if(ReturnType.equals("void")||ReturnType.equals("")){
               method.add("final", ";");
               res.add("stat", method.render());
           }
           break;
      }

      return res;
   }

   // TODO: será que há maneira de simplificar isto num só?
   private ST binaryExpression(String type, String var, String op, QuizzParser.ExprContext expr1, QuizzParser.ExprContext expr2) {
      ST res = templates.getInstanceOf("stats");
      ST expr1Visit = visit(expr1);
      ST expr2Visit = visit(expr2);

      // This has to be done so the declared variable text is not rendered as statements before the expression
      if (!declaredVariables.containsKey(expr1.var))
         res.add("stat", expr1Visit.render());
      if (!declaredVariables.containsKey(expr2.var))
         res.add("stat", expr2Visit.render());

      ST bop = templates.getInstanceOf("binaryExpression");

      bop.add("type", type);
      bop.add("var", var);
      bop.add("e1", expr1.var);
      bop.add("op", op);
      bop.add("e2", expr2.var);

      res.add("stat", bop.render());

      return res;
   }

   private ST binaryExpression(String var, String op, QuizzParser.OperationContext op1, QuizzParser.OperationContext op2) {
      ST res = templates.getInstanceOf("stats");
      ST op1Visit = visit(op1);
      ST op2Visit = visit(op2);

      // This has to be done so the declared variable text is not rendered as statements before the expression
      if (!declaredVariables.containsKey(op1.var))
         res.add("stat", op1Visit.render());
      if (!declaredVariables.containsKey(op2.var))
         res.add("stat", op2Visit.render());

      ST bop = templates.getInstanceOf("binaryExpression");

      bop.add("type", op1.tp.name());
      bop.add("var", var);
      bop.add("e1", op1.var);
      bop.add("op", op);
      bop.add("e2", op2.var);

      res.add("stat", bop.render());

      return res;
   }

   private ST binaryExpression(String type, String var, String op, QuizzParser.OperationContext op1, QuizzParser.OperationContext op2) {
      ST res = templates.getInstanceOf("stats");
      ST op1Visit = visit(op1);
      ST op2Visit = visit(op2);

      // This has to be done so the declared variable text is not rendered as statements before the expression
      if (!declaredVariables.containsKey(op1.var))
         res.add("stat", op1Visit.render());
      if (!declaredVariables.containsKey(op2.var))
         res.add("stat", op2Visit.render());

      ST bop = templates.getInstanceOf("binaryExpression");

      bop.add("type", type);
      bop.add("var", var);
      bop.add("e1", op1.var);
      bop.add("op", op);
      bop.add("e2", op2.var);

      res.add("stat", bop.render());

      return res;
   }

   private ST binaryExpression(String type, String var, String op, QuizzParser.LogicContext log1, QuizzParser.LogicContext log2) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(log1).render());
      res.add("stat", visit(log2).render());

      ST bop = templates.getInstanceOf("binaryExpression");

      bop.add("type", type);
      bop.add("var", var);
      bop.add("e1", log1.var);
      bop.add("op", op);
      bop.add("e2", log2.var);

      res.add("stat", bop.render());

      return res;
   }

   private String newVar() {
      return "v_" + varCount++;
   }

   private int varCount = 1;
   private final STGroup templates = new STGroupFile("templates.stg");
}
