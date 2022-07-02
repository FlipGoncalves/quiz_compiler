package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Group> groups;
    private ArrayList<String> userAnswers;
    private String name;

    public Quiz(String name) {
        this.name = name;
        groups = new ArrayList<>(); groups.add(new Group());    //Default group 0
        userAnswers = new ArrayList<>();
    }

    public Quiz(String name, ArrayList<ArrayList<Question>> groups) {
        this(name);
        this.setGroups(groups);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<ArrayList<Question>> groups) {
        ArrayList<Group> a = new ArrayList<Group>();
        for (ArrayList<Question> q : groups){
        	Group g = new Group(q);
        	a.add(g);
        }
        this.groups = a;
    }

    public void addQuestion(Question question) {
        // Default group 0
        groups.get(0).addQuestion(question);
    }

    public void addQuestion(int groupIdx, Question question) {
        if (groupIdx < groups.size())
            groups.get(groupIdx).addQuestion(question);
    }

    public void removeQuestion(Question question) {
        // Default group 0
        groups.get(0).removeQuestion(question);
    }

    public void removeQuestion(int groupIdx, Question question) {
        if (groupIdx < groups.size())
            groups.get(groupIdx).removeQuestion(question);
    }

    public Group getGroup(int groupIdx) {
        if (groupIdx < groups.size())
            return groups.get(groupIdx);
        return null;
    }

    public void removeGroup(int groupIdx) {
        if (groupIdx < groups.size())
            groups.remove(groupIdx);
    }
 
    public void addGroup(ArrayList<Question> group) {
        Group g = new Group(group);
        groups.add(g);
        
    }

    public void removeGroup(ArrayList<Question> group) {
        for (Group g : groups){
            if (g.getQuestions().equals(group)){
            	groups.remove(g);
    	    }
    	}
    }

    public String groupsToString() {
        String g = "";
        for (int i = 0; i < groups.size(); i++)
            g += ("Group " + i + "\n" + groups.get(i));
        g += "\n";
        
        return g;
    }

    @Override
    public String toString() {
        return "Quiz " + name + "\n" + groupsToString();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int i = 0; int j = 1;
        for (Group group: groups) {
            System.out.println("Group " + i);
            for (Question question: group.getQuestions()) {
                if (question.isValidQuestion()) {
                    System.out.println(j + " - " + question.toString());
                    String input = sc.nextLine();
                    System.out.println("Your answer: " + input);
                    userAnswers.add(input);
                }
                j++;
            }
            i++; j = 1;
        }

        System.out.println("\n--------- ANSWERS");
        i = 0; j = 2;
        for (Group group: groups) {
            System.out.println("Group " + (i-j+2) + "\n"); j = 1;
            for (Question question: group.getQuestions()) {
                if (question.validateAnswer(userAnswers.get(i)))
                    System.out.println(j + " - Correct Answer!\n");
                else
                    System.out.println(j + " - Wrong Answer!\n");
                i++; j++;
            }
        }

        sc.close();
    }
}

