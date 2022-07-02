package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Matching extends Type {
    private final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private List<String> leftOptions;
    private List<String> rightOptions;
    private List<Integer> answerPairs;

    public Matching() {
        super(TypeName.MATCHING);
        this.leftOptions = new ArrayList<>();
        this.rightOptions = new ArrayList<>();
        this.answerPairs = new ArrayList<>();
    }

    // Allow input options to be String, Integer and Double
    public Matching(ArrayList<?> leftOptions, ArrayList<?> rightOptions, ArrayList<Integer> answerPairs) {
        this();
        
        for (Object op: leftOptions) {
            if (!(op instanceof Integer || op instanceof Double || op instanceof String)) {
                System.err.println("Invalid options!");
                System.exit(1);
            }
            this.leftOptions.add(String.valueOf(op));
        }
        
        for (Object op: rightOptions) {
            if (!(op instanceof Integer || op instanceof Double || op instanceof String)) {
                System.err.println("Invalid options!");
                System.exit(1);
            }
            this.rightOptions.add(String.valueOf(op));
        }

        if (answerPairs.size() > leftOptions.size()) {
            System.err.println("Invalid answer!");
            System.exit(1);
        }

        for (int match: answerPairs) {
            if (match < 0 || match >= rightOptions.size()) {
                System.err.println("Invalid answer!");
                System.exit(1);
            }
        }
        this.answerPairs = answerPairs;
    }
    
    public ArrayList<String> getLeftOptions() {
        return new ArrayList(leftOptions);
    }

    public void setLeftOptions(List<String> leftOptions) {
        this.leftOptions = leftOptions;
    }

    public ArrayList<String> getRightOptions() {
        return new ArrayList(rightOptions);
    }

    public void setRightOptions(List<String> rightOptions) {
        this.rightOptions = rightOptions;
    }

    public ArrayList<Integer> getAnswerPairs() {
        return new ArrayList(answerPairs);
    }

    public void setAnswerPairs(List<Integer> answerPairs) {
        this.answerPairs = answerPairs;
    }

    public String getRightAnswer() {
        String answer = "";
        for (int i = 0; i < answerPairs.size(); i++) {
            answer += ((i+1) + " - " + alphabet[answerPairs.get(i)] + ";");
        }
        return answer;
    }

    @Override
    public boolean validateAnswer(String input) {
        String[] inputPairs = input.strip().split(";");
        if (inputPairs.length != answerPairs.size())
            return false;

        String leftOp; char rightOp;
        for (int i = 0; i < inputPairs.length; i++) {
            leftOp = inputPairs[i].split("-")[0].strip();
            rightOp = inputPairs[i].split("-")[1].strip().charAt(0);
            if (rightOp != alphabet[answerPairs.get(Integer.parseInt(leftOp)-1)])
                return false;
        }
        return true;
    }

    @Override
    public Type setKeywords(List<String> keywords) {
        answerPairs = keywords.stream().map(Integer::parseInt).collect(Collectors.toList());
        return this;
    }

    @Override
    public ArrayList<String> getOptions() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(getLeftOptions());
        temp.addAll(getRightOptions());
        return temp;
    }

    @Override
    public ArrayList<String> getKeywords() {
        return (ArrayList<String>) getAnswerPairs().stream().map(String::valueOf).collect(Collectors.toList());
    }

    @Override
    public Type setOptions(List<String> options) {
        int size = options.size();

        // ERROR
        if (size % 2 != 0)
            return this;

        setLeftOptions(options.subList(0, size/2));
        setRightOptions(options.subList(size/2, size));

        return this;
    }

    public String optionsToString() {
        String op = "";
        for (int i = 0; i < leftOptions.size(); i++)
            op += ((i+1) + " - " +  leftOptions.get(i) + "\n");

        op += "\n";
        for (int i = 0; i < rightOptions.size(); i++)
            op += (alphabet[i] + " - " +  rightOptions.get(i) + "\n");
        return op;
    }

    @Override
    public String toString() {
        return "- Match the left options with the right options (eg. 1-B) -\n" +  optionsToString();
    }
}
