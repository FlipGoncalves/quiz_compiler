package classes;

import java.util.*;
import java.lang.Math;
public class BQuest {

    private ArrayList<Question> questions = new ArrayList<>();

    public BQuest() {}

	// It can be chained because it makes code generation easier
    // (don't need to keep track of a variable name to add questions)
	public BQuest add(Question question) {
	    questions.add(question); return this;
    }
    
    public void addQuestion(Question question) {
    	   questions.add(question);
    }

    public Question getQuestion(int index) {            //getOneQuestion
        return questions.get(index);
    }

    public ArrayList<Question> getQuestions() {       //getAllQuestions
        return questions;
    }
    
    public Question getQuestion() {
    	int size = questions.size();
    	int random = (int) Math.random()*size;
    	return questions.get(random);
    }
}
