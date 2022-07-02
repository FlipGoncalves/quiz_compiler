package classes;

import java.util.ArrayList;
import java.util.List;

public class Essay extends Type {
    private String answerSuggestion;

    public Essay () {
        super(TypeName.ESSAY);
        this.answerSuggestion = "";
    }

    public Essay(String answerSuggestion) {
        this();
        this.answerSuggestion = answerSuggestion;
    }

    public String getAnswerSuggestion() {
        return answerSuggestion;
    }

    public void setAnswerSuggestion(String answerSuggestion) {
        this.answerSuggestion = answerSuggestion;
    }

    @Override
    public String getRightAnswer() {
        System.out.print("Possible answer:\n\t");
        return answerSuggestion;
    }

    @Override
    public boolean validateAnswer(String input) {
        // Can't objectively validate an Essay Question
        return false;
    }

    @Override
    public Type setKeywords(List<String> keywords) { return this; }

    @Override
    public ArrayList<String> getOptions() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<String> getKeywords() {
        return new ArrayList<>();
    }

    @Override
    public Type setOptions(List<String> options) { return this; }

    @Override
    public String toString() {
        return "- Insert a relatively long answer -\n";
    }
}

