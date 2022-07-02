import classes.BQuest;
import classes.Difficulty;
import classes.Question;
import classes.Type;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class Extractor extends SecondaryBaseVisitor<Object> {

   // TODO Semantic analysis?

   private final BQuest bquest = new BQuest();

   @Override public Object visitProgram(SecondaryParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Object visitExpr(SecondaryParser.ExprContext ctx) { return visitChildren(ctx); }

   @Override public Object visitQuestion(SecondaryParser.QuestionContext ctx) {
      String theme;
      String head;
      Difficulty diff;
      Type type;

      theme = ctx.theme.getText();
      head = ctx.head.getText();
      diff = Difficulty.fromNum(Integer.parseInt(ctx.diff.getText()));
      String typeName = ctx.type.getText().replaceAll(" ", "");
      type = Type.fromString(typeName.substring(1, typeName.length()-1));

      List<String> pals = ctx.pal().stream()
              .map(palContext -> palContext.getText().replaceAll("^\"|\"$", ""))
              .collect(Collectors.toList());

      List<String> opts = new ArrayList<>();
      for (SecondaryParser.OptContext opt : ctx.opt())
         opts.addAll((Collection<? extends String>) visit(opt));

      if (type != null) {
         type.setOptions(opts);
         type.setKeywords(pals);
      }

      bquest.add(new Question(type, head, theme, diff));

      return visitChildren(ctx);
   }

   @Override public Object visitPal(SecondaryParser.PalContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Object visitOpt(SecondaryParser.OptContext ctx) {
      return ctx.String().stream()
              .map(terminalNode -> terminalNode.getText().replaceAll("^\"|\"$", ""))
              .collect(Collectors.toList());
   }

   public BQuest getBQuest() {
      return bquest;
   }
}
