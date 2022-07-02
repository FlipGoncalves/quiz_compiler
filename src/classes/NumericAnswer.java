package classes;

import java.util.ArrayList;
import java.util.List;

public class NumericAnswer extends Type{
    private Double answer;

    public NumericAnswer() {
        super(TypeName.NUMERIC_ANSWER);
        this.answer = null;
    }

    public NumericAnswer(double answer) {
        this();
        this.answer = answer;
    }

    public NumericAnswer(int answer) {
        this(Double.valueOf(answer));
    }

    public Double getAnswer() {
        return answer;
    }

    public void setAnswer(Double answer) {
        this.answer = answer;
    }

    @Override
    public String getRightAnswer() {
        return String.format("%.2f", answer);
    }

    @Override
    public boolean validateAnswer(String input) {
        String rightAnswer = getRightAnswer();

        // If the right answer is an integer
        if (rightAnswer.endsWith("00")) {
            if (input.strip().equals(rightAnswer.split(".")[0]))
                return true;
        }
        
        // If the right answer is a double
        if (input.strip().equals(getRightAnswer()))
            return true;
        return false;
    }

    @Override
    public Type setKeywords(List<String> keywords) {
        if (keywords.size() > 0)
            setAnswer(Double.valueOf(keywords.get(0)));
        return this;
    }

    @Override
    public ArrayList<String> getOptions() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<String> getKeywords() {
        ArrayList<String> a = new ArrayList();
        a.add(String.valueOf(this.getAnswer()));
        return a;
    }

    @Override
    public Type setOptions(List<String> options) { return this; }

    @Override
    public String toString() {
        return "- Insert a number (For decimal numbers use '.' and keep 2 decimal places) -\n";
    }
}

