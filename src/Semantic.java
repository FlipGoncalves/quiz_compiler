import org.antlr.v4.runtime.tree.TerminalNode;

import classes.Type;

//import jdk.javadoc.internal.doclets.formats.html.markup.Table;

import java.util.*;

@SuppressWarnings("unchecked")
public class Semantic extends QuizzBaseVisitor<Boolean> {

   private SymbolTable symbolTable = new SymbolTable();
   private boolean acceptBreak = false;

   public SymbolTable getSymbolTable() {
      return symbolTable;
   }

   public static VType textToVType(String type) {
      type = type.trim();
      switch(type) {
            case "Text":
               return new TextVType();
            case "Number":
               return new NumberVType();
            case "Integer":
               return new IntegerVType();
            case "Double":
               return new DoubleVType();
            case "Quiz":
               return new QuizVType();
            case "Question":
               return new QuestionVType();
            case "BQuest":
               return new BQuestVType();
            case "Table":
               return new TableVType();
            case "Type":
               return new TypeVType();
            case "Essay":
               return new EssayVType();
            case "Matching":
               return new MatchingVType();
            case "MultipleChoice":
               return new MultipleChoiceVType();
            case "NumericAnswer":
               return new NumericAnswerVType();
            case "ShortAnswer":
               return new ShortAnswerVType();
            default:
               return new NoneVType();
      }
   }

   private Map<String, Symbol> tempVars = new HashMap<>();

   private String currentVar = "SYSTEM_VARIABLE0";
   private int varCount = 0;

   private String newVar() {
      return "SYSTEM_VARIABLE" + ++varCount;
   }

   private String currentVar() {
      // return "SYSTEM_VARIABLE" + (varCount);
      return currentVar;
   }

   // CHECK
   @Override public Boolean visitProgram(QuizzParser.ProgramContext ctx) {
      boolean res = true;
      for (QuizzParser.StatementContext statementContext : ctx.statement()) {
         if (!visit(statementContext)) {
            res = false;
            break;
         }
      }

      Logger.printInfo("Semantic Analysis complete. " + Logger.errorCount + " errors found.\n");
      return res;
   }

   // CHECK
   @Override public Boolean visitExpr(QuizzParser.ExprContext ctx) {

      boolean areChildrenValid = visitChildren(ctx);
      if (!areChildrenValid) {
         ctx.tp = new NoneVType();
         return false;  // Error already was identified in visitChildren(ctx)
      }

      if (ctx.methods() != null)
         ctx.var = ctx.methods().var;
      else if (ctx.attribute() != null)
         ctx.var = ctx.attribute().var;  
      // else if (ctx.operation() != null)
      //    ctx.var = ctx.operation().var;
      else
         ctx.var = currentVar();

      // ctx.var = currentVar();
      if (tempVars.containsKey(ctx.var))
         ctx.tp = tempVars.get(ctx.var).type();
      else if (symbolTable.containsSymbol(ctx.var))
         ctx.tp = symbolTable.lookUpGlobal(ctx.var).type();


      Logger.printInfo(ctx, "Semantic: Passed verification for expression.");
      return true;

   }

   // CHECK
   @Override public Boolean visitStatement(QuizzParser.StatementContext ctx) {
      return visitChildren(ctx);
   }

   // CHECK
   @Override public Boolean visitDecl(QuizzParser.DeclContext ctx) {

      boolean areChildrenValid = ctx.VarType() != null && ctx.ID() != null;
      
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid type or variable name.");
         Logger.printError(ctx, "Semantic: Failed verification for variable declaration.");
         Logger.registerError(); 
         return false;
      }

      String id = ctx.ID().getText();
      VType type = textToVType(ctx.VarType().getText());

      if (type instanceof NoneVType) {
         Logger.printError(ctx, "Semantic: Invalid type for variable" + id + ".");
         Logger.printError(ctx, "Semantic: Failed verification for variable declaration.");
         Logger.registerError(); 
         return false;
      }

      Symbol s = new VariableSymbol(id, type, false);
      symbolTable.insert(s);

      Logger.printInfo(ctx, "Semantic: Passed verification for variable declaration.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitDecl.");
      return true;
   }

   // CHECK
   @Override public Boolean visitAssign(QuizzParser.AssignContext ctx) {

      boolean areChildrenValid = ctx.ID() != null;

      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid type for variable.");
         Logger.printError(ctx, "Semantic: Failed verification for variable assignment.");
         Logger.registerError(); 
         return false;
      }

      String id = ctx.ID().getText();

      if (!symbolTable.containsSymbol(id)) {
         Logger.printError(ctx, "Semantic: Variable " + id + " isn't initialized!.");
         Logger.printError(ctx, "Semantic: Failed verification for variable assignment.");
         Logger.registerError();
         return false;
      }
      //Else, we can assume that lookUpGlobal won't return null
      Symbol symbol = symbolTable.lookUpGlobal(id);
      // if (s == null) {
         //    System.err.printf("Variable \"%s\" isn't initialized!", id);
         //    Logger.registerError(); return false;
         // }

      VType type = symbol.type();

      areChildrenValid = visit(ctx.expr());

      if (!areChildrenValid) return false;  // Error already was identified in visit(ctx.expr())

      if (!ctx.expr().tp.equals(type) && !type.getClass().isInstance(ctx.expr().tp)) {
         Logger.printError(ctx, "Semantic: Can't assign variable " + id + " with type " + ctx.expr().tp.name() + ".");
         Logger.printError(ctx, "Semantic: Failed verification for variable assignment.");
         Logger.registerError(); 
         return false;
      }

      Symbol s = new VariableSymbol(id, type, true);
                  
      areChildrenValid = ctx.expr().var != null && (tempVars.containsKey(ctx.expr().var) || symbolTable.containsSymbol(ctx.expr().var));
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Variable " + ctx.expr().var + " isn't initialized.");
         Logger.printError(ctx, "Semantic: Failed verification for variable assignment.");
         Logger.registerError(); 
         return false;
      }

      if (ctx.expr().tp instanceof TableVType) {
         if (tempVars.containsKey(ctx.expr().var)) {
            s.setSize(tempVars.get(ctx.expr().var).size());
            s.setElementsType(tempVars.get(ctx.expr().var).elementsType());
         }

         else if (symbolTable.containsSymbol(ctx.expr().var)) {
            s.setSize(symbolTable.lookUpGlobal(ctx.expr().var).size());
            s.setElementsType(symbolTable.lookUpGlobal(ctx.expr().var).elementsType());
         }
      }

      symbolTable.insert(s);

      Logger.printInfo(ctx, "Semantic: Passed verification for variable assignment.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitAssign");
      return true;
   }

   // CHECK
   @Override public Boolean visitDeclAssign(QuizzParser.DeclAssignContext ctx) {
      // eg. Text v1 = 1
      // eg. Question q1 = group>>1

      boolean areChildrenValid = ctx.VarType() != null && ctx.ID() != null;
      
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid type or variable.");
         Logger.printError(ctx, "Semantic: Failed verification for variable declaration and assignment.");
         Logger.registerError(); 
         return false;
      }

      String id = ctx.ID().getText();
      VType type = textToVType(ctx.VarType().getText());
      
      if (type instanceof NoneVType) {
         Logger.printError(ctx, "Semantic: Invalid type for variable " + id + ".");
         Logger.printError(ctx, "Semantic: Failed verification for variable declaration and assignment.");
         Logger.registerError(); 
         return false;
      }

      if (symbolTable.containsSymbol(id)) {
         Logger.printError(ctx, "Semantic: Variable " + id + "is already defined.");
         Logger.printError(ctx, "Semantic: Failed verification for variable declaration and assignment.");
         Logger.registerError(); 
         return false;
      }
      
      areChildrenValid = visit(ctx.expr());

      if (!areChildrenValid) return false;  // Error already was identified in visit(ctx.expr())

      if (!ctx.expr().tp.equals(type) && !type.getClass().isInstance(ctx.expr().tp)) {
         Logger.printError(ctx, "Semantic: Can't initialize variable '" + id + "' with type " + ctx.expr().tp.name() + ".");
         Logger.printError(ctx, "Semantic: Failed verification for variable declaration and assignment.");
         Logger.registerError(); 
         return false;
      }

      if (type instanceof TypeVType) {
         type = ctx.expr().tp;
      }else if (type instanceof QuestionVType) {
         VType newType = type;
         if (tempVars.containsKey(ctx.expr().var)) {
            ((QuestionVType)newType).setQuestionType(((QuestionVType)tempVars.get(ctx.expr().var).type()).getQuestionType());
            type = newType;
         }
      } 
      
      else if (type instanceof TableVType) {
         VType newType = type;

         if (tempVars.containsKey(ctx.expr().var)) {
            ((TableVType)newType).setElemType(((TableVType)tempVars.get(ctx.expr().var).type()).getElemType());
            type = newType;
         }
      }

      Symbol s = new VariableSymbol(id, type, true);
                  
      areChildrenValid = ctx.expr().var != null && (tempVars.containsKey(ctx.expr().var) || symbolTable.containsSymbol(ctx.expr().var));
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Variable '" + ctx.expr().var + "' isn't initialized.");
         Logger.printError(ctx, "Semantic: Failed verification for variable declaration and assignment.");
         Logger.registerError(); 
         return false;
      }

      if (ctx.expr().tp instanceof TableVType) {
         if (tempVars.containsKey(ctx.expr().var)) {
            s.setSize(tempVars.get(ctx.expr().var).size());
            s.setElementsType(tempVars.get(ctx.expr().var).elementsType());
         } else if (symbolTable.containsSymbol(ctx.expr().var)) {
            s.setSize(symbolTable.lookUpGlobal(ctx.expr().var).size());
            s.setElementsType(symbolTable.lookUpGlobal(ctx.expr().var).elementsType());
         }
      }

      symbolTable.insert(s);

      Logger.printInfo(ctx, "Semantic: Passed verification for variable declaration and assignment.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitDeclAssign.");
      return true;

   }

   // CHECK
   @Override public Boolean visitQuiz(QuizzParser.QuizContext ctx) {
      
      if (ctx.expr().size() != 1 && ctx.expr().size() != 2) {
         Logger.printError(ctx, "Semantic: Must insert quiz name and groups of questions (optional) to initialize quiz.");
         Logger.printError(ctx, "Semantic: Failed verification for Quiz type.");
         Logger.registerError();
         return false;
      }

      boolean areChildrenValid = visit(ctx.expr(0));  // Quiz Name
      if (!areChildrenValid) return false;  // Error already was identified in visit(ctx.expr())

      VType type = ctx.expr(0).tp;

      if (!(type instanceof TextVType)) {
         Logger.printError(ctx, "Semantic: Quiz name must be (type) Text.");
         Logger.printError(ctx, "Semantic: Failed verification for Quiz type.");
         Logger.registerError();
         return false;
      }

      if (ctx.expr().size() == 2) {
         areChildrenValid = visit(ctx.expr(1));  // Groups of questions
         if (!areChildrenValid) return false;  // Error already was identified in visit(ctx.expr())

         type = ctx.expr(1).tp;
         if (!(type instanceof TableVType)) {
            Logger.printError(ctx, "Semantic: Groups of questions must be (type) Table.");
            Logger.printError(ctx, "Semantic: Failed verification for Quiz type.");
            Logger.registerError();
            return false;
         }

         areChildrenValid = ctx.expr(1).var != null && (tempVars.containsKey(ctx.expr(1).var) || symbolTable.containsSymbol(ctx.expr(1).var));
         if (!areChildrenValid) {
            Logger.printError(ctx, "Semantic: Variable " + ctx.expr(1).var + "isn't initialized.");
            Logger.printError(ctx, "Semantic: Failed verification for Quiz type.");
            Logger.registerError(); 
            return false;
         }

         if (tempVars.containsKey(ctx.expr(1).var))
            type = tempVars.get(ctx.expr(1).var).elementsType();

         else if (symbolTable.containsSymbol(ctx.expr(1).var))
            type = symbolTable.lookUpGlobal(ctx.expr(1).var).elementsType();

         if (!(type instanceof QuestionVType)) {
            Logger.printError(ctx, "Semantic: Group elements must be (type) Questions.");
            Logger.printError(ctx, "Semantic: Failed verification for Quiz type.");
            Logger.registerError(); 
            return false;
         }
      }

      String quizID = newVar(); currentVar = quizID;
      Symbol s = new VariableSymbol(quizID, new QuizVType(), true);
      
      tempVars.put(quizID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Quiz type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitQuiz");
      return true;
   }

   // CHECK
   @Override public Boolean visitQuestion(QuizzParser.QuestionContext ctx) {

      VType[] validArgs = {new TypeVType(), new TextVType(), new TextVType(), new IntegerVType()};
      boolean areChildrenValid;
      VType questionType = null;

      if (ctx.expr().size() > 0) {

         if (ctx.expr().size() != validArgs.length) {
            Logger.printError(ctx, "Semantic: Must have 0 or " + validArgs.length + " arguments.");
            Logger.printError(ctx, "Semantic: Failed verification for Question type.");
            Logger.registerError();
            return false;
         }

         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            
            areChildrenValid = visit(ctx.expr(exprIdx));
            if (!areChildrenValid) return false;
            
            VType type = ctx.expr(exprIdx).tp;
            if (!(validArgs[exprIdx].getClass().isInstance(type))) {
               Logger.printError(ctx, "Semantic: Invalid type for argument at position " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Question type.");
               Logger.registerError();
               return false;
            }
            
            if (exprIdx == 0)
               questionType = ctx.expr(exprIdx).tp;

         }         
         // Note: Accept any number for difficulty - If it isn't valid, difficulty stays EASY (1)
      }

      QuestionVType question = new QuestionVType(questionType);
      String questionID = newVar(); 
      currentVar = questionID;
      Symbol s = new VariableSymbol(questionID, question, true);
      
      tempVars.put(questionID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Question type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitQuestion.");
      return true;
   }

   // CHECK
   @Override public Boolean visitTextString(QuizzParser.TextStringContext ctx) {

      boolean areChildrenValid = ctx.String() != null;
      
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid text value.");
         Logger.printError(ctx, "Semantic: Failed verification for Text type.");
         Logger.registerError();
         return false;
      }

      String textID = newVar(); currentVar = textID;
      Symbol s = new VariableSymbol(textID, new TextVType(), true);
      
      tempVars.put(textID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Text type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitTextString.");
      return true;
   }

   // CHECK
   @Override public Boolean visitTextExpr(QuizzParser.TextExprContext ctx) {

      boolean areChildrenValid = visit(ctx.expr());
      if (!areChildrenValid) return false;

      if (!(ctx.expr().tp instanceof TextVType)) {
         Logger.printError(ctx, "Semantic: Text() only accepts text.");
         Logger.printError(ctx, "Semantic: Failed verification for Text type.");
         Logger.registerError(); 
         return false;
      }

      String textID = newVar(); currentVar = textID;
      Symbol s = new VariableSymbol(textID, new TextVType(), true);
      
      tempVars.put(textID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Text type.");
      return true;

   }

   // CHECK
   @Override public Boolean visitNumberValue(QuizzParser.NumberValueContext ctx) {

      boolean areChildrenValid = visit(ctx.value());
      if (!areChildrenValid) return false;

      Logger.printInfo(ctx, "Semantic: Passed verification for Number type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitNumberValue.");
      return true;
   }

   // CHECK
   @Override public Boolean visitNumberExpr(QuizzParser.NumberExprContext ctx) {

      boolean areChildrenValid = visit(ctx.expr());
      if (!areChildrenValid) return false;

      if (!(ctx.expr().tp instanceof NumberVType)) {
         Logger.printError(ctx, "Semantic: Number() only accepts numbers.");
         Logger.printError(ctx, "Semantic: Failed verification for Number type.");
         Logger.registerError(); 
         return false;
      }

      Logger.printInfo(ctx, "Semantic: Passed verification for Number type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitNumberExpr.");
      return true;
   }

   // CHECK
   @Override public Boolean visitTable(QuizzParser.TableContext ctx) {

      VType type = new TableVType();
      VType newType = new TableVType();
      
      if (ctx.expr().size() > 0) {
         boolean areChildrenValid = visit(ctx.expr(0));
         if (!areChildrenValid) return false;  // Error already was identified in visit(ctx.expr())

         type = ctx.expr(0).tp;

         for (int i = 1; i < ctx.expr().size(); i++) {
            areChildrenValid = visit(ctx.expr(i));
            if (!areChildrenValid) return false;  // Error already was identified in visit(ctx.expr())

            if (!ctx.expr(i).tp.equals(type) && !type.getClass().isInstance(ctx.expr(i).tp)) {
               Logger.printError(ctx, "Semantic: Inconsistent type for table elements.");
               Logger.printError(ctx, "Semantic: Failed verification for Table type.");
               Logger.registerError();
               return false;
            }
         }

         ((TableVType)newType).setElemType(ctx.expr(0).tp);
         type = newType;
      }

      String tableID = newVar(); 
      
      currentVar = tableID;

      Symbol s = new VariableSymbol(tableID, type, true);
      
      s.setSize(ctx.expr().size()); 
      
      if (ctx.expr().size() > 0) {

         if (ctx.VarType() != null) {
            VType elementsType = VType.fromString(ctx.VarType().getText());
            if (!ctx.expr(0).tp.equals(elementsType) && !elementsType.getClass().isInstance(ctx.expr(0).tp)) {
               Logger.printError(ctx, "Semantic: Table type definition and elements types don't match.");
               Logger.printError(ctx, "Semantic: Failed verification for Table type.");
               Logger.registerError();
               return false;
            }
         }

         s.setElementsType(ctx.expr(0).tp);

      } else {

         if (ctx.VarType() == null) {
            Logger.printError(ctx, "Semantic: Type not specified for empty table.");
            Logger.printError(ctx, "Semantic: Failed verification for Table type.");
            Logger.registerError();
            return false;
         }

         VType elementsType = VType.fromString(ctx.VarType().getText());

         if (elementsType instanceof NoneVType) {
            Logger.printError(ctx, "Semantic: Invalid type for table elements.");
            Logger.printError(ctx, "Semantic: Failed verification for Table type.");
            Logger.registerError();
            return false;
         }
         
         s.setElementsType(elementsType);
      }

      tempVars.put(tableID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Table type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitTable.");
      return true;

   }

   // CHECK
   @Override public Boolean visitBquest(QuizzParser.BquestContext ctx) {
      
      if (ctx.fname == null) {
         Logger.printError(ctx, "Semantic: Invalid file name!.");
         Logger.printError(ctx, "Semantic: Failed verification for Bquest type.");
         //System.err.println(ctx.getText() + ": Semantic - Invalid file name!");
         //System.err.println(ctx.getText() + ": Semantic - Failed verification for visitBquest.");
         Logger.registerError();
         return false;
      }

      String bquestID = newVar(); 
      currentVar = bquestID;
      Symbol s = new VariableSymbol(bquestID, new BQuestVType(), true);
      
      tempVars.put(bquestID, s);
      
      Logger.printInfo(ctx, "Semantic: Passed verification for Bquest type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitTable.");
      return true;
   }

   // CHECK
   @Override public Boolean visitNumInt(QuizzParser.NumIntContext ctx) {

      boolean areChildrenValid = ctx.Int() != null;
      
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid value.");
         Logger.printError(ctx, "Semantic: Failed verification for Number(Integer) type.");
         Logger.registerError();
         return false;
      }

      String numberID = newVar(); currentVar = numberID;
      Symbol s = new VariableSymbol(numberID, new IntegerVType(), true);
      
      tempVars.put(numberID, s);
      ctx.tp = new IntegerVType();

      Logger.printInfo(ctx, "Semantic: Passed verification for Number(Integer) type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitNumInt.");
      return true;
   }

   // CHECK
   @Override public Boolean visitNumDouble(QuizzParser.NumDoubleContext ctx) {
      
      boolean areChildrenValid = ctx.Double() != null;
      
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid value.");
         Logger.printError(ctx, "Semantic: Failed verification for Number(Double) type.");
         Logger.registerError();
         return false;
      }

      String numberID = newVar(); currentVar = numberID;
      Symbol s = new VariableSymbol(numberID, new DoubleVType(), true);
      
      tempVars.put(numberID, s);
      ctx.tp = new DoubleVType();

      Logger.printInfo(ctx, "Semantic: Passed verification for Number(Double) type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitNumDouble.");
      return true;

   }

   // CHECK
   @Override public Boolean visitMultipleChoice(QuizzParser.MultipleChoiceContext ctx) {
      
      VType[] validArgs = {new TableVType(), new IntegerVType()};
      boolean areChildrenValid; VType type = null;

      if (ctx.expr().size() > 0) {

         if (ctx.expr().size() != validArgs.length) {
            Logger.printError(ctx, "Semantic: Must have 0 or " + validArgs.length + " arguments.");
            Logger.printError(ctx, "Semantic: Failed verification for MultipleChoice type.");
            Logger.registerError();
            return false;
         }
 
         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            
            areChildrenValid = visit(ctx.expr(exprIdx));
            if (!areChildrenValid) return false;
         
            type = ctx.expr(exprIdx).tp;
            if (!(type.getClass().isInstance(validArgs[exprIdx]))) {
               Logger.printError(ctx, "Semantic: Invalid type for argument at position " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for MultipleChoice type.");
               Logger.registerError();
               return false;
            }
         }         

         areChildrenValid = ctx.expr(0).var != null && (tempVars.containsKey(ctx.expr(0).var) || symbolTable.containsSymbol(ctx.expr(0).var));
         if (!areChildrenValid) {
            Logger.printError(ctx, "Semantic: Unknwon table variable.");
            Logger.printError(ctx, "Semantic: Failed verification for MultipleChoice type.");
            Logger.registerError();
            return false;
         }

         if (tempVars.containsKey(ctx.expr(0).var))
            type = tempVars.get(ctx.expr(0).var).elementsType();

         else if (symbolTable.containsSymbol(ctx.expr(0).var))
            type = symbolTable.lookUpGlobal(ctx.expr(0).var).elementsType();

         if (!(type instanceof TextVType)) {
            Logger.printError(ctx, "Semantic: Options must be from (type) Text.");
            Logger.printError(ctx, "Semantic: Failed verification for MultipleChoice type.");
            Logger.registerError(); 
            return false;
         }
      }
      // Note: No need to verify if solution makes sense

      String questionID = newVar(); currentVar = questionID;
      Symbol s = new VariableSymbol(questionID, new TypeVType(), true);
      
      tempVars.put(questionID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for MultipleChoice type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitMultipleChoice");
      return true;
   }

   // CHECK
   @Override public Boolean visitMatching(QuizzParser.MatchingContext ctx) {
      
      VType[] validArgs = {new TableVType(), new TableVType(), new TableVType()};
      boolean areChildrenValid; VType type;

      if (ctx.expr().size() > 0) {

         if (ctx.expr().size() != validArgs.length) {
            Logger.printError(ctx, "Semantic: Must have 0 or " + validArgs.length + " arguments.");
            Logger.printError(ctx, "Semantic: Failed verification for Matching type.");
            Logger.registerError();
            return false;
         }
 
         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            
            areChildrenValid = visit(ctx.expr(exprIdx));
            if (!areChildrenValid) return false;
         
            type = ctx.expr(exprIdx).tp;
            if (!(type.getClass().isInstance(validArgs[exprIdx].getClass())) && !(type.getClass().equals(validArgs[exprIdx].getClass()))) {
               Logger.printError(ctx, "Semantic: Invalid type for argument at position " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Matching type.");
               Logger.registerError();
               return false;
            }

            areChildrenValid = ctx.expr(exprIdx).var != null && (tempVars.containsKey(ctx.expr(exprIdx).var) || symbolTable.containsSymbol(ctx.expr(exprIdx).var));
            if (!areChildrenValid) {
               Logger.printError(ctx, "Semantic: Invalid type for argument at position " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Matching type.");
               Logger.registerError();
               return false;
            }

            if (tempVars.containsKey(ctx.expr(exprIdx).var))
               type = tempVars.get(ctx.expr(exprIdx).var).elementsType();

            else if (symbolTable.containsSymbol(ctx.expr(exprIdx).var))
               type = symbolTable.lookUpGlobal(ctx.expr(exprIdx).var).elementsType();

            if (exprIdx > 2) {
               if (!(type instanceof TextVType)) {
                  Logger.printError(ctx, "Semantic: Options must be (type) Text.");
                  Logger.printError(ctx, "Semantic: Failed verification for Matching type.");
                  Logger.registerError(); 
                  return false;
               }
               else {
                  if (!(type instanceof NumberVType)) {
                     Logger.printError(ctx, "Semantic: Solution must be (type) Number!");
                     Logger.printError(ctx, "Semantic: Failed verification for Matching type.");
                     Logger.registerError(); 
                     return false;
                  }
               }
            }
         }
      }
      // Note: No need to verify if numbers in solution make sense

      String questionID = newVar(); currentVar = questionID;
      Symbol s = new VariableSymbol(questionID, new TypeVType(), true);
      
      tempVars.put(questionID, s);
      
      Logger.printInfo(ctx, "Semantic: Passed verification for Matching type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitMatching.");
      return true;

   }

   // CHECK
   @Override public Boolean visitShortAnswer(QuizzParser.ShortAnswerContext ctx) {
      
      // VType[] validArgs = {new TextVType(), new TextVType()};
      VType[] validArgs = {new TextVType(), new TableVType()};
      boolean areChildrenValid; VType type = null;

      if (ctx.expr().size() > 0) {

         if (ctx.expr().size() != validArgs.length) {
            Logger.printError(ctx, "Semantic: Must have 0 or " + validArgs.length + " arguments.");
            Logger.printError(ctx, "Semantic: Failed verification for ShortAnswer type.");
            Logger.registerError();
            return false;
         }
 
         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            
            areChildrenValid = visit(ctx.expr(exprIdx));
            if (!areChildrenValid) return false;
         
            type = ctx.expr(exprIdx).tp;
            if (!(type.getClass().isInstance(validArgs[exprIdx]))) {
               Logger.printError(ctx, "Semantic: Invalid type for argument at position " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for ShortAnswer type.");
               Logger.registerError();
               return false;
            }
         } 
         
         areChildrenValid = ctx.expr(1).var != null && (tempVars.containsKey(ctx.expr(1).var) || symbolTable.containsSymbol(ctx.expr(1).var));
         if (!areChildrenValid) {
            Logger.printError(ctx, "Semantic: Table doesn't exist.");
            Logger.printError(ctx, "Semantic: Failed verification for ShortAnswer type.");
            Logger.registerError();
            return false;
         }

         if (tempVars.containsKey(ctx.expr(1).var))
            type = tempVars.get(ctx.expr(1).var).elementsType();

         else if (symbolTable.containsSymbol(ctx.expr(1).var))
            type = symbolTable.lookUpGlobal(ctx.expr(1).var).elementsType();

         if (!(type instanceof TextVType)) {
            Logger.printError(ctx, "Semantic: Solution must be (type) Text.");
            Logger.printError(ctx, "Semantic: Failed verification for ShortAnswer type.");
            Logger.registerError(); 
            return false;
         }
      }

      String questionID = newVar(); currentVar = questionID;
      Symbol s = new VariableSymbol(questionID, new TypeVType(), true);
      
      tempVars.put(questionID, s);
      
      Logger.printInfo(ctx, "Semantic: Passed verification for ShortAnswer type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitShortAnswer.");
      return true;

   }

   // CHECK
   @Override public Boolean visitNumericAnswer(QuizzParser.NumericAnswerContext ctx) {
      
      VType validArg = new IntegerVType();
      VType type = null;

      if (ctx.expr() != null) {
         
         boolean areChildrenValid = visit(ctx.expr());
         if (!areChildrenValid) return false;
      
         type = ctx.expr().tp;
         if (!(type.getClass().isInstance(validArg))) {
            Logger.printError(ctx, "Semantic: Invalid type for argument at position 0.");
            Logger.printError(ctx, "Semantic: Failed verification for NumericAnswer type.");
            Logger.registerError();
            return false;
         }

      }

      String questionID = newVar(); 
      currentVar = questionID;
      Symbol s = new VariableSymbol(questionID, new NumericAnswerVType(), true);

      tempVars.put(questionID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for NumericAnswer type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitNumericAnswer.");
      return true;

   }

   // CHECK
   @Override public Boolean visitEssay(QuizzParser.EssayContext ctx) {
      
      VType validArg = new TextVType();
      VType type = null;

      if (ctx.expr() != null) {
         
         boolean areChildrenValid = visit(ctx.expr());
         if (!areChildrenValid) return false;
      
         type = ctx.expr().tp;
         if (!(type.getClass().isInstance(validArg))) {
            Logger.printError(ctx, "Semantic: Invalid type for argument at position 0.");
            Logger.printError(ctx, "Semantic: Failed verification for Essay type.");
            Logger.registerError();
            return false;
         }
      }

      String questionID = newVar(); currentVar = questionID;
      Symbol s = new VariableSymbol(questionID, new TypeVType(), true);

      tempVars.put(questionID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Essay type.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitEssay.");
      return true;

   }

   // CHECK
   @Override public Boolean visitAttribute(QuizzParser.AttributeContext ctx) {

      Boolean areChildrenValid = visitChildren(ctx);
      if (areChildrenValid == null) return true;
      if (!areChildrenValid) {
         ctx.tp = new NoneVType(); ctx.var = null;
         return false;  // Error already was identified in visitChildren(ctx)
      }
     
      ctx.var = currentVar();
      ctx.tp = tempVars.get(ctx.var).type();

      Logger.printInfo(ctx, "Semantic: Passed verification for Attribute.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitAttribute.");
      return true;

   }

   // CHECK
   @Override public Boolean visitShuffle(QuizzParser.ShuffleContext ctx) {
      
      boolean areChildrenValid = visit(ctx.expr());
      if (!areChildrenValid) return false;
      
      if (ctx.expr().tp instanceof NoneVType) {
         Logger.printError(ctx, "Semantic: Invalid argument(s) for Shuffle - cannot be None type.");
         Logger.printError(ctx, "Semantic: Failed verification for Shuffle.");
         Logger.registerError(); 
         return false;
      }

      VType type = ctx.expr().tp;

      if (!(type instanceof QuizVType || type instanceof QuestionVType || type instanceof TableVType)) {
         Logger.printError(ctx, "Semantic: Suffle only accepts Quiz/Question/Table types.");
         Logger.printError(ctx, "Semantic: Failed verification for Shuffle.");
         Logger.registerError(); 
         return false;
      }

      String resultID = newVar(); currentVar = resultID;
      Symbol s = new VariableSymbol(resultID, type, true);
      s.setElementsType(tempVars.get(ctx.expr().var).elementsType());

      tempVars.put(resultID, s);


      Logger.printInfo(ctx, "Semantic: Passed verification for Shuffle.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitShuffle");
      return true;

   }

   // CHECK
   @Override public Boolean visitInput(QuizzParser.InputContext ctx) {
      
      boolean areChildrenValid = visit(ctx.expr());
      if (!areChildrenValid) return false;

      areChildrenValid = !(ctx.expr().tp instanceof NoneVType);
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid argument(s) for Input - cannot be None type.");
         Logger.printError(ctx, "Semantic: Failed verification for Input.");
         Logger.registerError(); 
         return false;
      }

      VType type = ctx.expr().tp;
      if (!(type instanceof TextVType)) {
         Logger.printError(ctx, "Semantic: Input only accepts (type) Text.");
         Logger.printError(ctx, "Semantic: Failed verification for Input.");
         Logger.registerError(); 
         return false;
      }

      String inputID = newVar(); currentVar = inputID;
      Symbol s = new VariableSymbol(inputID, type, true);

      tempVars.put(inputID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Input.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitInput");
      return true;

   }

   // CHECK
   @Override public Boolean visitOutput(QuizzParser.OutputContext ctx) {
      
      boolean areChildrenValid = visit(ctx.expr());
      if (!areChildrenValid) return false;

      areChildrenValid = !(ctx.expr().tp instanceof NoneVType);
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid argument(s) for Output - cannot be None type.");
         Logger.printError(ctx, "Semantic: Failed verification for Output.");
         Logger.registerError(); 
         return false;
      }
      
      VType type = ctx.expr().tp;
      if (type instanceof BQuestVType) {
         Logger.printError(ctx, "Semantic: Output doesn't accept (type) Bquest.");
         Logger.printError(ctx, "Semantic: Failed verification for Output.");
         Logger.registerError(); 
         return false;
      }

      Logger.printInfo(ctx, "Semantic: Passed verification for Output.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitOutput");
      return true;

   }

   // CHECK
   @Override public Boolean visitNumericIteration(QuizzParser.NumericIterationContext ctx) {
      
      boolean isLoopValid;

      if (ctx.ID() == null) {
         Logger.printError(ctx, "Semantic: Missing iteration variable name in 'For' loop.");
         Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
         Logger.registerError();
         return false;
      }

      Symbol symbol = null;
      if (symbolTable.containsSymbol(ctx.ID().getText()))
         symbol = symbolTable.lookUpGlobal(ctx.ID().getText());
         
      if (symbol != null) {
         if (!(symbol.type() instanceof IntegerVType)) {
            Logger.printError(ctx, "Semantic: Variable " + ctx.ID().getText() + " must be (type) Number.");
            Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
            Logger.registerError();
            return false;
         }
      } else
         symbol = new VariableSymbol(ctx.ID().getText(), new IntegerVType(), true);

      VType type = null;
      for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
         isLoopValid = visit(ctx.expr(exprIdx));
         if (!isLoopValid) return false;

         if (tempVars.containsKey(currentVar))
            type = tempVars.get(currentVar).type();

         else if (symbolTable.containsSymbol(currentVar))
            type = symbolTable.lookUpGlobal(currentVar).type();
         
         if (!(type instanceof IntegerVType)) {
            Logger.printError(ctx, "Semantic: Expression at position " + exprIdx + " must be from Integer type.");
            Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
            Logger.registerError();
            return false;
         }
      }

      if (ctx.statement().size() > 0) {

         acceptBreak = true;
         symbolTable.enterScope();

         // if (!symbolTable.containsSymbol(ctx.ID().getText()))
         //    symbolTable.insert(symbol);
         symbolTable.insert(symbol);

         for (int statIdx = 0; statIdx < ctx.statement().size(); statIdx++) {
            isLoopValid = visit(ctx.statement(statIdx));
            
            if (!isLoopValid) {
               Logger.printError(ctx, "Semantic: Statement at position " + statIdx + " is invalid.");
               Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
               Logger.registerError();
               return false;
            }
         }

         acceptBreak = false; 
         symbolTable.exitScope();
      }

      Logger.printInfo(ctx, "Semantic: Passed verification for 'For' instruction.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitNumericIteration.");
      return true;
   }

   // CHECK
   @Override public Boolean visitTableIteration(QuizzParser.TableIterationContext ctx) {
      
      boolean isLoopValid;

      if (ctx.ID() == null) {
         Logger.printError(ctx, "Semantic: Missing iteration variable name in 'For' loop.");
         Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
         Logger.registerError();
         return false;
      }

      if (!visit(ctx.expr())) {
         Logger.printError(ctx, "Semantic: Expression at position 0 is invalid.");
         Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
         Logger.registerError();
         return false;
      }

      if (!(ctx.expr().tp instanceof TableVType)) {
         Logger.printError(ctx, "Semantic: Expression at position 0 must be from Table type.");
         Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
         Logger.registerError();
         return false;
      }
      
      isLoopValid = ctx.expr().var != null && (tempVars.containsKey(ctx.expr().var) || symbolTable.containsSymbol(ctx.expr().var));
      if (!isLoopValid) {
         Logger.printError(ctx, "Semantic: Variable " + ctx.expr().var+ " isn't initialized!");
         Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
         Logger.registerError(); 
         return false;
      }

      VType elementsType = null;
      if (tempVars.containsKey(ctx.expr().var))
         elementsType = tempVars.get(ctx.expr().var).elementsType();

      else if (symbolTable.containsSymbol(ctx.expr().var))
         elementsType = symbolTable.lookUpGlobal(ctx.expr().var).elementsType();

      Symbol symbol = symbolTable.lookUpGlobal(ctx.ID().getText());

      if (symbol != null) {
         
         if (!symbol.type().equals(elementsType) && !symbol.type().getClass().isInstance(elementsType)) {
            Logger.printError(ctx, "Semantic: Variable " + ctx.ID().getText() + " must be (type) " + elementsType.name() + ".");
            Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
            Logger.registerError();
            return false;
         }
      } else
         symbol = new VariableSymbol(ctx.ID().getText(), elementsType, true);

      if (ctx.statement().size() > 0) {

         acceptBreak = true;
         symbolTable.enterScope();

         symbolTable.insert(symbol);

         for (int statIdx = 0; statIdx < ctx.statement().size(); statIdx++) {
            isLoopValid = visit(ctx.statement(statIdx)); 
            
            if (!isLoopValid) {
               Logger.printError(ctx, "Semantic: Statement at position " + statIdx +" is invalid.");
               Logger.printError(ctx, "Semantic: Failed verification for 'For' instruction.");
               Logger.registerError();
               return false;
            }
         }

         acceptBreak = false; 
         symbolTable.exitScope();
      }

      Logger.printInfo(ctx, "Semantic: Passed verification for 'For' instruction.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitTableIteration.");
      return true;

   }

   // CHECK
   @Override public Boolean visitBreakOperation(QuizzParser.BreakOperationContext ctx) {
      if (acceptBreak) 
         Logger.printInfo(ctx, "Semantic: Passed verification for Break expression.");
         //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitBreakOperation.");
      else
         Logger.printError(ctx, "Semantic: Failed verification for Break expression.");
         //System.err.println(ctx.getText() + ": Semantic - Failed verification for visitBreakOperation.");
      return acceptBreak;
   }

   // CHECK
   @Override public Boolean visitCondition(QuizzParser.ConditionContext ctx) {
   
      boolean areChildrenValid = visit(ctx.logic());
      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Logic expression is invalid..");
         Logger.printError(ctx, "Semantic: Failed verification for 'If' instruction.");
         Logger.registerError();
         return false;
      }

      if (ctx.statement().size() > 0) {
         
         symbolTable.enterScope();

         for (int statIdx = 0; statIdx < ctx.statement().size(); statIdx++) {
            areChildrenValid = visit(ctx.statement(statIdx)); 

            if (!areChildrenValid) {
               Logger.printError(ctx, "Semantic: Statement at position " + statIdx +" is invalid.");
               Logger.printError(ctx, "Semantic: Failed verification for 'If' instruction.");
               Logger.registerError();
               return false;
            }
         }

         symbolTable.exitScope();
      }

      Logger.printInfo(ctx, "Semantic: Passed verification for 'If' instruction.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitCondition.");
      return true;
   }

   // CHECK
   @Override public Boolean visitItem(QuizzParser.ItemContext ctx) {

      if (ctx.attribute() != null) {

         if (!visit(ctx.attribute())) {
            Logger.printError(ctx, "Semantic: Invalid attribute.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation.");
            Logger.registerError();
            return false;
         }

         ctx.tp = ctx.attribute().tp;
         ctx.var = ctx.attribute().var;

      }

      // else if (ctx.ID() == null) {
      //    System.err.println(ctx.getText() + ": Semantic - Invalid variable name.");
      //    System.err.println(ctx.getText() + ": Semantic - Failed verification for visitItem.");
      //    Logger.registerError();
      //    return false;
      // }
      // else {
      //    // If ctx.ID() != null
      //    if (!(tempVars.containsKey(ctx.ID().getText()) || symbolTable.containsSymbol(ctx.ID().getText()))) {
      //       System.err.printf(ctx.getText() + ": Semantic - Variable %s isn't initialized!\n", ctx.ID().getText());
      //       System.err.println(ctx.getText() + ": Semantic - Failed verification for visitItem.");
      //       Logger.registerError(); 
      //       return false;
      //    }
   
      //    Symbol symbol = null;
      //    if (tempVars.containsKey(ctx.ID().getText()))
      //       symbol = tempVars.get(ctx.ID().getText());
   
      //    else if (symbolTable.containsSymbol(ctx.ID().getText()))
      //       symbol = symbolTable.lookUpGlobal(ctx.ID().getText());

      //    ctx.tp = symbol.type();
      //    ctx.var = ctx.ID().getText();
      // }
      
      Logger.printInfo(ctx, "Semantic: Passed verification for Operation.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitItem.");
      return true;

   }

   // CHECK
   @Override public Boolean visitMulDivMod(QuizzParser.MulDivModContext ctx) {
      
      boolean isOperationValid;

      VType type = null;
      VType thisType = null;

      for (int operationIdx = 0; operationIdx < ctx.operation().size(); operationIdx++) {
         isOperationValid = visit(ctx.operation(operationIdx));
      
         if (!isOperationValid) {
            Logger.printError(ctx, "Semantic: Invalid operation.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(*/).");
            Logger.registerError();
            return false;
         }

         // if (tempVars.containsKey(currentVar))
         //    thisType = tempVars.get(currentVar).type();

         // else if (symbolTable.containsSymbol(currentVar))
         //    thisType = symbolTable.lookUpGlobal(currentVar).type();
         thisType = ctx.operation(operationIdx).tp;

         if (operationIdx == 0)
            type = thisType;

         if (!thisType.equals(type) && !thisType.getClass().isInstance(type)) {
            Logger.printError(ctx, "Semantic: Elements (within an operation) must be from the same type.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(*/).");
            Logger.registerError(); 
            return false;
         }
      }

      type = ctx.operation(0).tp;
      String resultID = newVar(); currentVar = resultID;
      Symbol s = new VariableSymbol(resultID, type, true);

      tempVars.put(resultID, s);
      ctx.tp = type;

      Logger.printInfo(ctx, "Semantic: Passed verification for Operation(*/).");
      return true;

   }

   // CHECK
   @Override public Boolean visitExponent(QuizzParser.ExponentContext ctx) {

      boolean isOperationValid;

      VType type = null;
      VType thisType = null;

      for (int operationIdx = 0; operationIdx < ctx.operation().size(); operationIdx++) {
         isOperationValid = visit(ctx.operation(operationIdx));
      
         if (!isOperationValid) {
            Logger.printError(ctx, "Semantic: Invalid operation.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(^).");
            Logger.registerError();
            return false;
         }

         // if (tempVars.containsKey(currentVar))
         //    thisType = tempVars.get(currentVar).type();

         // else if (symbolTable.containsSymbol(currentVar))
         //    thisType = symbolTable.lookUpGlobal(currentVar).type();
         thisType = ctx.operation(operationIdx).tp;

         if (operationIdx == 0)
            type = thisType;

         System.out.println(thisType.name());
         if (!thisType.equals(type) && !thisType.getClass().isInstance(type)) {
            Logger.printError(ctx, "Semantic: Elements (within an operation) must be from the same type.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(^).");
            Logger.registerError(); 
            return false;
         }
      }

      String resultID = newVar(); currentVar = resultID;
      Symbol s = new VariableSymbol(resultID, type, true);

      tempVars.put(resultID, s);
      ctx.tp = type;

      Logger.printInfo(ctx, "Semantic: Passed verification for Operation(^).");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitExponent.");
      return true;
   }

   // CHECK
   @Override public Boolean visitParenthesisOper(QuizzParser.ParenthesisOperContext ctx) {
      
      boolean isOperationValid = visit(ctx.operation());

      if (!isOperationValid) {
         Logger.printError(ctx, "Semantic: Invalid operation.");
         Logger.printError(ctx, "Semantic: Failed verification for Operation(Parenthisis).");
         Logger.registerError();
         return false;
      }

      ctx.tp = ctx.operation().tp;

      Logger.printInfo(ctx, "Semantic: IPassed verification for Operation(Parenthisis).");
      return true;
   }

   // CHECK
   @Override public Boolean visitSignOper(QuizzParser.SignOperContext ctx) { 

      boolean isOperationValid = visit(ctx.operation());

      if (!isOperationValid) {
         Logger.printError(ctx, "Semantic: Invalid operation.");
         Logger.printError(ctx, "Semantic: Failed verification for Operation(+-).");
         Logger.registerError();
         return false;
      }

      VType type = ctx.operation().tp;
      String resultID = newVar(); currentVar = resultID;
      Symbol s = new VariableSymbol(resultID, type, true);

      tempVars.put(resultID, s);
      ctx.tp = type;

      Logger.printInfo(ctx, "Semantic: Passed verification for Operation(Sign).");
      return true;

   }

   // CHECK
   @Override public Boolean visitAddSubtract(QuizzParser.AddSubtractContext ctx) {
      
      boolean isOperationValid;

      VType type = null;
      VType thisType = null;

      for (int operationIdx = 0; operationIdx < ctx.operation().size(); operationIdx++) {
         isOperationValid = visit(ctx.operation(operationIdx));

         if (!isOperationValid) {
            Logger.printError(ctx, "Semantic: Invalid operation.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(+-).");
            Logger.registerError();
            return false;
         }

            // if (tempVars.containsKey(currentVar))
            //    thisType = tempVars.get(currentVar).type();

            // else if (symbolTable.containsSymbol(currentVar))
            //    thisType = symbolTable.lookUpGlobal(currentVar).type();
            thisType = ctx.operation(operationIdx).tp;

         if (operationIdx == 0)
            type = thisType;

         if (!thisType.equals(type) && !thisType.getClass().isInstance(type)) {
            Logger.printError(ctx, "Semantic: Elements (within an operation) must be from the same type.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(+-).");
            //System.err.println(ctx.getText() + ": Semantic - Elements (within an operation) must be from the same type!");
            //System.err.println(ctx.getText() + ": Semantic - Failed verification for visitAddSubtract.");
            Logger.registerError(); 
            return false;
         }

      }

      type = ctx.operation(0).tp;
      String resultID = newVar(); currentVar = resultID;
      Symbol s = new VariableSymbol(resultID, type, true);

      tempVars.put(resultID, s);
      ctx.tp = type;

      Logger.printInfo(ctx, "Semantic: Passed verification for Operation(+-).");
      return true;

   }

   // CHECK
   @Override public Boolean visitVarComp(QuizzParser.VarCompContext ctx) {

      boolean isCompValid;

      VType type = null;
      VType thisType = null;

      for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
         isCompValid = visit(ctx.expr(exprIdx));

         if (!isCompValid) {
            Logger.printError(ctx, "Semantic: Invalid operation.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(Comparison).");
            Logger.registerError();
            return false;
         }

         if (tempVars.containsKey(currentVar))
            thisType = tempVars.get(currentVar).type();

         else if (symbolTable.containsSymbol(currentVar))
            thisType = symbolTable.lookUpGlobal(currentVar).type();

         if (exprIdx == 0)
            type = thisType;

         if (!thisType.equals(type) && !thisType.getClass().isInstance(type)) {
            Logger.printError(ctx, "Semantic: Elements must be from the same type.");
            Logger.printError(ctx, "Semantic: Failed verification for Operation(Comparison).");
            Logger.registerError(); 
            return false;
         }
      }

      // String resultID = newVar(); currentVar = resultID;
      // Symbol s = new VariableSymbol(resultID, type, true);

      // tempVars.put(resultID, s);

      Logger.printInfo(ctx, "Semantic: Passed verification for Operation(Comparison).");
      return true;
   }

   @Override public Boolean visitNotCond(QuizzParser.NotCondContext ctx) {
      
      boolean isLogicValid = visit(ctx.logic());

      if (isLogicValid)
         Logger.printInfo(ctx, "Semantic: Passed verification for Operation(Not).");
         //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitNotCond.");
      else
         Logger.printError(ctx, "Semantic: Failed verification for Operation(Not).");   
         //System.err.println(ctx.getText() + ": Semantic - Failed verification for visitNotCond.");
      return isLogicValid;
   }

   @Override public Boolean visitCondComp(QuizzParser.CondCompContext ctx) {
      
      boolean isCompValid = true;

      for (int logicIdx = 0; logicIdx < ctx.logic().size(); logicIdx++)
         isCompValid &= visit(ctx.logic(logicIdx));
      
      if (isCompValid) 
         Logger.printInfo(ctx, "Semantic: Passed verification for Operation(Logic).");
         //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitCondComp.");
      else
         Logger.printError(ctx, "Semantic: Failed verification for Operation(Logic).");
         //System.err.println(ctx.getText() + ": Semantic - Failed verification for visitCondComp.");
      return isCompValid;

   }

   // CHECK
   @Override public Boolean visitParenthesisCond(QuizzParser.ParenthesisCondContext ctx) {
      return visit(ctx.logic());
   }

   // CHECK
   @Override public Boolean visitMethod(QuizzParser.MethodContext ctx) {

      boolean areChildrenValid = visit(ctx.methods());
      if (!areChildrenValid) return false;  // Error already was identified in visit(ctx.methods())

      areChildrenValid = ctx.MethodTypes() != null;
      if (!areChildrenValid) return false;  // Error already was identified in visitChildren(ctx)

      String methodType = ctx.MethodTypes().getText();
      VType type = null;
      
      if (!methodType.equals("::")) {

         if (ctx.name != null) {
            Logger.printError(ctx, "Semantic: Invalid Method.");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError(); 
            return false;
         }
         
         if (tempVars.containsKey(ctx.methods().var))
            type = tempVars.get(ctx.methods().var).type();
         else if (symbolTable.containsSymbol(ctx.methods().var))
            type = symbolTable.lookUpGlobal(ctx.methods().var).type();
         
         if (type == null || type instanceof NoneVType) {
            Logger.printError(ctx, "Semantic: Invalid variable(s) for this method.");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError();
            return false;
         }

         if (ctx.expr().size() == 0) {
            Logger.printWarning(ctx, "Semantic: The method requires arguments!");
            //System.out.println("WARNING: This method requires arguments! (No effect)");
         }

      } else {

         if (ctx.name == null) {
            Logger.printError(ctx, "Semantic: Invalid method.");
            //System.err.println("Invalid method!");
            Logger.registerError(); 
            return false;
         }

         /*
         if (ctx.expr().size() > 0) {
            System.err.println("This method doesn't accept arguments!");
            Logger.registerError(); 
            return false;
         }
         */

         Method[] methodsArray = ctx.methods().tp.getMethods();

         if (methodsArray == null) {
            Logger.printError(ctx, "Semantic: This type " + ctx.methods().tp.name() + " doesn't accept any methods.");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError();
            return false;
         }

         List<Class<?>> currentMethodAttributes = new ArrayList<>();
         StringBuilder paramsTypes = new StringBuilder("(");

         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            
            if (!visit(ctx.expr(exprIdx))) {
               Logger.printError(ctx, "Semantic: Invalid expression at index " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError(); 
               return false;
            }

            VType parameterType = ctx.expr(exprIdx).tp;

            if (parameterType == null || parameterType instanceof NoneVType) {
               Symbol parameterSymbol = symbolTable.lookUpGlobal(ctx.expr(exprIdx).getText());
               if (parameterSymbol != null)
                  parameterType = parameterSymbol.type();
            }

            paramsTypes.append(parameterType.name());
            if (exprIdx < ctx.expr().size()-1)
               paramsTypes.append(",");
            currentMethodAttributes.add(parameterType.getClass());

         }

         paramsTypes.append(")");

         String methodName = ctx.name.getText();
         List<Method> methods = Arrays.asList(methodsArray);
         Method currentMethod = new Method(methodName, currentMethodAttributes.toArray(new Class[0]));

         if (!methods.contains(currentMethod)) {
            Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't support argument(s) from type " + paramsTypes.toString() + ".");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError(); 
            return false;
         }else{

            Method method = methods.get(methods.indexOf(currentMethod));
               
            if (method.getReturnType() != null) {
               type = method.getReturnType();
            }

            String symbolID = newVar(); //currentVar = symbolID;
            Symbol s = new VariableSymbol(symbolID, type, true);

            /*
            if (type instanceof TableVType) {
               if (ctx.expr(0).getText().equalsIgnoreCase("groups"))
                  s.setElementsType(new GroupVType());
               else if (ctx.expr(0).getText().equalsIgnoreCase("options"))
                  s.setElementsType(new TextVType());
               else if (ctx.expr(0).getText().equalsIgnoreCase("questions"))
                  s.setElementsType(new QuestionVType());
            }*/
            
            tempVars.put(symbolID, s);

            ctx.var = symbolID;
            if (!(ctx.tp instanceof TableVType)) {
               ctx.tp = type;
            }
         }

      }

      if (methodType.equals(">>")) {

         if (ctx.methods().tp == null)
            ctx.methods().tp = new TypeVType();

         Getter[] methodGettersArray = ctx.methods().tp.getGetters();

         if (ctx.expr().size() != 1) {
            Logger.printError(ctx, "Semantic: Getters don't accept more than 1 argument.");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError(); 
            return false;
         }

         if (!visit(ctx.expr(0))) {
            Logger.printError(ctx, "Semantic: Invalid expression at index 0.");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError(); 
            return false;
         }

         if (ctx.methods().tp instanceof TableVType) {
            
            if (!(ctx.expr(0).tp instanceof IntegerVType)) {
               Logger.printError(ctx, "Semantic: The argument of a Table getter must be an Integer.");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError(); 
               return false;
            } 

         }else{

            if (methodGettersArray == null) {
               Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't accept getters.");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError();
               return false;
            }

            String parameterName = ctx.expr(0).getText().replaceAll("\"", "");
            List<Getter> methodGetters = Arrays.asList(methodGettersArray);
            Getter currentGetter = new Getter(parameterName);
   
            if (!methodGetters.contains(currentGetter)) {
               Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't support argument(s) from type " + ctx.expr(0).tp + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError(); 
               return false;
            }else{
               
               Getter methodGetter = methodGetters.get(methodGetters.indexOf(currentGetter));
               
               if (methodGetter.getReturnType() != null) {
                  type = methodGetter.getReturnType();
               }

               String symbolID = newVar(); 
               currentVar = symbolID;
               Symbol s = new VariableSymbol(symbolID, type, true);

               if (type instanceof TableVType) {
                  if (ctx.expr(0).getText().equalsIgnoreCase("groups"))
                     s.setElementsType(new GroupVType());
                  else if (ctx.expr(0).getText().equalsIgnoreCase("options"))
                     s.setElementsType(new TextVType());
                  else if (ctx.expr(0).getText().equalsIgnoreCase("questions"))
                     s.setElementsType(new QuestionVType());
               }
               
               if (type instanceof TypeVType) {
                  if (symbolTable.containsSymbol(ctx.methods().getText())) {
                     Symbol symb = symbolTable.lookUpGlobal(ctx.methods().getText());
                     type = ((QuestionVType)symb.type()).getQuestionType();
                  }
               }
               
               tempVars.put(symbolID, s);

               ctx.var = symbolID;
               if (!(ctx.tp instanceof TableVType)) {
                  ctx.tp = type;
               }

            }

         }  

      }

      if (methodType.equals("<<")) {

         Setter[] methodSettersArray = ctx.methods().tp.getSetters();

         if (ctx.expr().size() != 2) {
            Logger.printError(ctx, "Semantic: Setters don't accept more than 2 arguments.");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError(); 
            return false;
         }

         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            if (!visit(ctx.expr(exprIdx))) {
               Logger.printError(ctx, "Semantic: Invalid expression at index " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError(); 
               return false;
            }
         }

         if (ctx.methods().tp instanceof TableVType) {

            if (symbolTable.containsSymbol(ctx.methods().var)) {
               Symbol storedSymbol = symbolTable.lookUpGlobal(ctx.methods().var);
               ((TableVType)ctx.methods().tp).setElemType(storedSymbol.elementsType);
            }

            if (!(ctx.expr(0).tp instanceof IntegerVType)) {
               Logger.printError(ctx, "Semantic: The argument of a Table setter must be an Integer.");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError(); 
               return false;
            }
            
            if (!(ctx.expr(1).tp.getClass().isInstance(((TableVType)ctx.methods().tp).getElemType()))) {
               Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't support argument(s) from type " + ctx.expr(1).tp + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError(); 
               return false;
            }

         }else{

            if (methodSettersArray == null) {
               Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't accept setters.");
               Logger.printError(ctx, "Semantic: Failed verification for Method.");
               Logger.registerError();
               return false;
            } 

            String parameterName = ctx.expr(0).getText().replaceAll("\"", "");
            VType parameterType = ctx.expr(1).tp;

            if (parameterType instanceof NoneVType) {
               Symbol parameterSymbol = symbolTable.lookUpGlobal(ctx.expr(1).getText());
               if (parameterSymbol != null)
                  parameterType = parameterSymbol.type();
            }

            List<Setter> methodSetters = Arrays.asList(methodSettersArray);
            Setter currentSetter = new Setter(parameterName, parameterType.getClass());

            if (!methodSetters.contains(currentSetter)) {
               Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " support argument(s) from type (" + ctx.expr(0).tp + ", " + ctx.expr(1).tp + ").");
               Logger.registerError(); 
               return false;
            }

         }    

      }

      if (methodType.equals("<+")) {

         VType methodTp = ctx.methods().tp;

         if (methodTp instanceof TableVType) {
            if (symbolTable.containsSymbol(ctx.methods().var)) {
               Symbol storedSymbol = symbolTable.lookUpGlobal(ctx.methods().var);
               ((TableVType)methodTp).setElemType(storedSymbol.elementsType);
            }
         }

         OtherMethod[] methodAddersArray = methodTp.getAdders();

         if (methodAddersArray == null) {
            Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't accept adders.");
            Logger.printError(ctx, "Semantic: Failed verification for Method.");
            Logger.registerError();
            return false;
         }

         String methodProperty = null;
         List<OtherMethod> methodAdders = Arrays.asList(methodAddersArray);
         List<Class<?>> currentMethodAttributes = new ArrayList<>();
         StringBuilder paramsTypes = new StringBuilder("(");

         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            
            if (!visit(ctx.expr(exprIdx))){
               Logger.printError(ctx, "Semantic: Invalid expression at index " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Method(<+).");
               Logger.registerError(); 
               return false;
            }

            if (exprIdx == 0) {
               methodProperty = ctx.expr(exprIdx).getText();
               continue;
            }

            VType parameterType = ctx.expr(exprIdx).tp;

            if (parameterType == null || parameterType instanceof NoneVType) {
               Symbol parameterSymbol = symbolTable.lookUpGlobal(ctx.expr(exprIdx).getText());
               if (parameterSymbol != null)
                  parameterType = parameterSymbol.type();
            }

            paramsTypes.append(parameterType.name());
            if (exprIdx < ctx.expr().size()-1)
               paramsTypes.append(",");
            currentMethodAttributes.add(parameterType.getClass());

         }

         paramsTypes.append(")");
         
         OtherMethod currentMethod = new OtherMethod(methodProperty, currentMethodAttributes.toArray(new Class[0]));
         
         if (!methodAdders.contains(currentMethod)) {
            Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't support argument(s) from type " + paramsTypes.toString() + ".");
            Logger.printError(ctx, "Semantic: Failed verification for Method(<+).");
            Logger.registerError(); 
            return false;
         }

      }

      if (methodType.equals("<-")) {

         VType methodTp = ctx.methods().tp;

         if (methodTp instanceof TableVType) {
            if (symbolTable.containsSymbol(ctx.methods().var)) {
               Symbol storedSymbol = symbolTable.lookUpGlobal(ctx.methods().var);
               ((TableVType)methodTp).setElemType(storedSymbol.elementsType);
            }
         }

         OtherMethod[] methodRemoversArray = methodTp.getRemovers();

         if (methodRemoversArray == null) {
            Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " doesn't accept removers.");
            Logger.printError(ctx, "Semantic: Failed verification for Method(<-).");
            Logger.registerError();
            return false;
         }

         String methodProperty = null;
         List<OtherMethod> methodRemovers = Arrays.asList(methodRemoversArray);
         List<Class<?>> currentMethodAttributes = new ArrayList<>();
         StringBuilder paramsTypes = new StringBuilder("(");

         for (int exprIdx = 0; exprIdx < ctx.expr().size(); exprIdx++) {
            
            if (!visit(ctx.expr(exprIdx))){
               Logger.printError(ctx, "Semantic: Invalid expression at index " + exprIdx + ".");
               Logger.printError(ctx, "Semantic: Failed verification for Method(<-).");
               Logger.registerError(); 
               return false;
            }

            if (exprIdx == 0) {
               methodProperty = ctx.expr(exprIdx).getText();
               continue;
            }

            VType parameterType = ctx.expr(exprIdx).tp;

            if (parameterType == null || parameterType instanceof NoneVType) {
               Symbol parameterSymbol = symbolTable.lookUpGlobal(ctx.expr(exprIdx).getText());
               if (parameterSymbol != null)
                  parameterType = parameterSymbol.type();
            }

            paramsTypes.append(parameterType.name());
            if (exprIdx < ctx.expr().size()-1)
               paramsTypes.append(",");
            currentMethodAttributes.add(parameterType.getClass());

         }

         paramsTypes.append(")");
         
         OtherMethod currentMethod = new OtherMethod(methodProperty, currentMethodAttributes.toArray(new Class[0]));
         
         if (!methodRemovers.contains(currentMethod)) {
            Logger.printError(ctx, "Semantic: The type " + ctx.methods().tp + " don't support argument(s) from type " + paramsTypes.toString() + ".");
            Logger.printError(ctx, "Semantic: Failed verification for Method(<-).");
            Logger.registerError(); 
            return false;
         }

      }

      Logger.printInfo(ctx, "Semantic: Passed verification for Method.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitMethod");
      return true;

   }

   // CHECK
   @Override public Boolean visitSingleId(QuizzParser.SingleIdContext ctx) {
      
      boolean areChildrenValid = ctx.ID() != null;

      List<String> propertiesList = Arrays.asList("name", "groups", "questions", "question", 
      "content", "type", "theme", "difficulty", "rightAnswer", "options", "group");

      if (!areChildrenValid) {
         Logger.printError(ctx, "Semantic: Invalid variable!");
         Logger.printError(ctx, "Semantic: Failed verification for Method.");
         Logger.registerError(); 
         return false;
      }

      String id = ctx.ID().getText();
         
      if (!symbolTable.containsSymbol(id) && !propertiesList.contains(id)) {
         Logger.printError(ctx, "Semantic: Variable " + id +" isn't defined.");
         Logger.printError(ctx, "Semantic: Failed verification for Method.");
         Logger.registerError();
         return false;  
      }

      if (symbolTable.containsSymbol(id)) {
         ctx.tp = symbolTable.lookUpGlobal(id).type();   
      }else{
         ctx.tp = new TextVType();
         Symbol s = new VariableSymbol(id, new TextVType(), true);
         tempVars.put(id, s);
      }

      ctx.var = id; 
      currentVar = ctx.var;

      Logger.printInfo(ctx, "Semantic: Passed verification for Method.");
      //System.out.println(ctx.getText() + ": Semantic - Passed verification for visitSingleID.");
      return true;

   }

}
