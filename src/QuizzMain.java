import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.ST;

public class QuizzMain {
   public static void main(String[] args) {
      try {
         String className;
         if (args.length > 0) {
            className = args[0];
         }
         else {
            className = "Output";
         }

         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(System.in);
         // create a lexer that feeds off of input CharStream:
         QuizzLexer lexer = new QuizzLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         QuizzParser parser = new QuizzParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            Semantic semantic = new Semantic();
            Boolean valid = null;
            try {
               valid = semantic.visit(tree);
            } catch (Exception e) {
               System.err.println("Error in the semantic analysis!");
               e.printStackTrace(System.err);
               System.exit(1);
            }
            if (valid != null && valid) {
               Compiler compiler = new Compiler();

               ST code = compiler.visit(tree);
               code.add("name", className);

               try {
                   PrintWriter pw = new PrintWriter(className + ".java");
                   pw.print(code.render());
                   pw.close();
               }
               catch (IOException e) {
                   System.err.println("Error, can't write to file " + className + ".java.");
                   System.exit(2);
               }
            }
            // Compilation error
            else {
               System.err.println("The program failed the semantic analysis!");
               System.exit(1);
            }

         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
