import classes.BQuest;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.Objects;

public class SecondaryMain {
   private static BQuest bquest;

   public static void main(String[] args) {
      if (args.length == 0)
         throw new IllegalArgumentException("No bquest file was specified!");

      String fname = args[0];
      File f = new File(fname);
      try {
         // create a CharStream that reads from the specified file:
         CharStream input = CharStreams.fromStream(new FileInputStream(f));
         // create a lexer that feeds off of input CharStream:
         SecondaryLexer lexer = new SecondaryLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         SecondaryParser parser = new SecondaryParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            Extractor extractor = new Extractor();
            extractor.visit(tree);
            bquest = extractor.getBQuest();
         }
      }
      catch(FileNotFoundException e) {
         System.err.println("File not found. Here's the file's absolute path: "
                 + f.getAbsolutePath());
         System.err.println("Does it exist? " + f.exists());
         System.err.println("Is it a directory? " + f.isDirectory());
         System.err.println("Is it readable? " + f.canRead());
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

   public static BQuest extract(String fname) {
      String[] args = {fname};
      main(args);

      return bquest;
   }
}
