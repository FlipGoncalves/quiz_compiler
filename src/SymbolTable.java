import java.util.*;

public class SymbolTable {
    private int scope;
	private ArrayList<HashMap<String, Symbol>> symTable = new ArrayList<HashMap<String, Symbol>>();
 
	public SymbolTable(){
		scope = 0;
		symTable.add(new HashMap<String, Symbol>());
	}
	
    public void insert(Symbol symbol){
        String symbolID = symbol.id();

		if (symbolID.matches("SYSTEM_VARIABLE[0-9]+")) {
			System.err.println("Name SYSTEM_VARIABLE is reserved, failed to insert!");
			return;
		}

		symTable.get(scope).put(symbolID, symbol);	//Overwrite symbol if it already exists in the same scope
	}

	public void insertAll(HashMap<String, Symbol> symbols) {
		
		for (String symbolID: symbols.keySet()) {
			if (symbolID.matches("SYSTEM_VARIABLE[0-9]+")) {
				System.err.println("Name SYSTEM_VARIABLE is reserved, failed to insert all!");
				return;
			}
		}

		symTable.get(scope).putAll(symbols);
	}
	
    public void enterScope(){
		scope++;
		symTable.add(new HashMap<String, Symbol>());
	}

	public void exitScope(){
		if (scope>0){
			symTable.remove(scope);
			scope--;
		}
	}	
	
    // public Symbol lookUpLocal(Symbol symbol) {
    //     String symbolID = symbol.id();
	// 	return symTable.get(scope).get(symbolID);
	// }
	
    public Symbol lookUpGlobal(Symbol symbol) {
        String symbolID = symbol.id();
		for (int i = scope; i >= 0 ; i--){
			if (symTable.get(i).containsKey(symbolID))
				return symTable.get(i).get(symbolID);
		}
		return null;
	}

	// public Symbol lookUpLocal(String symbolID) {
	// 	return symTable.get(scope).get(symbolID);
	// }
	
    public Symbol lookUpGlobal(String symbolID) {
		for (int i = scope; i >= 0 ; i--){
			if (symTable.get(i).containsKey(symbolID))
				return symTable.get(i).get(symbolID);
		}
		return null;
	}

    public boolean containsSymbol(String symbolID) {
		for (int i = scope; i >= 0 ; i--){
			if (symTable.get(i).containsKey(symbolID))
				return true;
		}
        return false;
    }
}
