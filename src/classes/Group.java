package classes;

import java.util.ArrayList;

public class Group {
    private ArrayList<Question> questions;

    public Group() {
        this.questions = new ArrayList<>();
    }

    public Group(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        if (questions.contains(question))
            questions.remove(question);
    }

    @Override
    public String toString() {
        String q = "";
        for (int i = 0; i < questions.size(); i++) 
            q += ((i+1) +  " - " + questions.get(i) + "\n");
        return q;
    }        
}
