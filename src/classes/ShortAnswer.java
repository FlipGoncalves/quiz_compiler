package classes;

import java.util.ArrayList;
import java.util.List;

public class ShortAnswer extends Type {
    private String answer;
    private ArrayList<String> regex;

    public ShortAnswer() {
        super(TypeName.SHORT_ANSWER);
        this.answer = "";
        this.regex = new ArrayList<>();
    }

    public ShortAnswer(String answer, ArrayList<String> regex) {
        this();
        this.answer = answer;
        this.regex = regex;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<String> getRegex() {
        return regex;
    }

    public void setRegex(ArrayList<String> regex) {
        this.regex = regex;
    }

    @Override
    public String getRightAnswer() {
        return answer;
    }

    @Override
    public boolean validateAnswer(String input) {
        // Correct invalid regex
        if (regex.isEmpty()) {
            String[] tmp = input.split("([.,!?:;'\"-]|\\s)+");
            for (String el: tmp)
                regex.add(el);
        }

        for (String el: regex) {
            if (!input.contains(el))
                return false;
        }
        return true;
    }

    @Override
    public Type setOptions(List<String> options) { return this; }

    @Override
    public Type setKeywords(List<String> keywords) {
        setRegex(new ArrayList(keywords));
        return this;
    }

    @Override
    public ArrayList<String> getOptions() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<String> getKeywords() {
        return getRegex();
    }

    @Override
    public String toString() {
        return "- Insert a short answer -\n";
    }   
}

