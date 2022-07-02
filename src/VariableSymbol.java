// public class VariableSymbol<T> extends Symbol<T> {
//    public VariableSymbol(String name, VType type) {
//       super(name, type);
//    }
// }

public class VariableSymbol extends Symbol {
   public VariableSymbol(String name, VType type, boolean init) {
      super(name, type, init);
   }
}
