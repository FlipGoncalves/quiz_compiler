package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoice extends Type {
    private final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private ArrayList<String> options;
    private int answerIdx;

    public MultipleChoice() {
        super(TypeName.MULTIPLE_CHOICE);
        this.options = new ArrayList<>();
        this.answerIdx = -1;  // Undefined
    }

    // Allow input options to be String, Integer and Double
    public MultipleChoice(ArrayList<?> options, int answerIdx) {
        this();

        if (options.size() == 0) {
            System.err.println("Invalid options!");
            System.exit(1);
        }

        for (Object op: options) {
            if (!(op instanceof Integer || op instanceof Double || op instanceof String)) {
                System.err.println("Invalid options!");
                System.exit(1);
            }
            this.options.add(String.valueOf(op));
        }

        if (answerIdx < 0 || answerIdx >= options.size()) {
            System.err.println("Invalid answer!");
            System.exit(1);
        }
        this.answerIdx = answerIdx;
    }

    public ArrayList<String> getOptions() {
        return (ArrayList<String>) options;
    }

    @Override
    public ArrayList<String> getKeywords() {
        return new ArrayList<String>(Arrays.asList(options.get(getAnswerIdx())));
    }

    public int getAnswerIdx() {
        return answerIdx;
    }

    @Override
    public Type setOptions(List<String> options) {
        this.options = new ArrayList(options);
        return this;
    }

    public void setAnswerIdx(int answerIdx) {
        this.answerIdx = answerIdx;
    }

    @Override
    public String getRightAnswer() {
        if (answerIdx < 0)
            return "";
        return Character.toString(alphabet[answerIdx]);
    }

    @Override
    public boolean validateAnswer(String input) {
        if (answerIdx < 0)
            return false;
        // Accept "A" or "a", for example
        if (input.toUpperCase().charAt(0) == alphabet[answerIdx])
            return true;

        return false;
    }

    @Override
    public Type setKeywords(List<String> keywords) {
        if (keywords.size() > 0)
            setAnswerIdx(options.indexOf(keywords.get(0)));
        return this;
    }

    public String optionsToString() {
        String op = "";
        for (int i = 0; i < options.size(); i++)
            op += (alphabet[i] + " - " +  options.get(i) + "\n");
        return op;
    }

    @Override
    public String toString() {
        return "- Insert the right option (eg. A or a) -\n" + optionsToString();
    }
}

