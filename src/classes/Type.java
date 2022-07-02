package classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Type {
    private TypeName name;

    public Type(TypeName name) {
        this.name = name;
    }

    public static Type fromString(String name) {
        switch (name) {
            case "ShortAnswer":     return new ShortAnswer();
            case "MultipleChoice":  return new MultipleChoice();
            case "NumericAnswer":   return new NumericAnswer();
            case "Matching":        return new Matching();
            case "Essay":           return new Essay();
        }

        return null;
    }
    
    public String getName(){
    	return this.name.toString();
    }

    public abstract String getRightAnswer();
    public abstract boolean validateAnswer(String input);

    // Used in BQuest building
    // Options should be set first!
    public abstract Type setOptions(List<String> options);
    public abstract Type setKeywords(List<String> keywords);
    public abstract ArrayList<String> getOptions();
    public abstract ArrayList<String> getKeywords();
}

