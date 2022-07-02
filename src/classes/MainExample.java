package classes;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Scanner;

@SuppressWarnings("unchecked")
public class MainExample {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Test");
        ArrayList<Question> group1 = new ArrayList();
        ArrayList<Question> group2 = new ArrayList();
        
        ArrayList<Object> t1 = new ArrayList<>(Arrays.asList("Option1", "Option2", "Option3"));
        ArrayList<Object> t2 = new ArrayList<>(Arrays.asList("OptionA", "OptionB", "OptionC"));
        Type q_mc1 = new MultipleChoice(t1, 1);
        Type q_m_1 = new Matching(t1, t2, new ArrayList<>(Arrays.asList(1, 0, 2)));

        Question q1 = new Question(q_mc1, "Escolhe a opção correta:", "Tema 1", Difficulty.EASY);
        Question q2 = new Question(q_m_1, "Associa as opções:", "Tema2", Difficulty.MEDIUM);

        group1.add(q1);
        group2.add(q1);
        group2.add(q2);

        quiz.addQuestion(q1);   //quiz.addQuestion(0, q1);
        quiz.addGroup(group1);
        quiz.addGroup(group2);
        
        // System.out.println(quiz);
        // System.out.println("----------");

        quiz.start();

        // NOTE: Implemented in Quiz
        // Scanner sc = new Scanner(System.in);
        // int i = 0;
        // for (Group group: quiz.getGroups()) {
        //     System.out.println("Group " + i);
        //     for (Question question: group.getQuestions()) {
        //         if (question.isValidQuestion()) {
        //             System.out.println(question);
        //             String input = sc.nextLine();
        //             System.out.println("Your answer: " + input);

        //             if (question.validateAnswer(input))
        //                 System.out.println("Correct Answer!\n");
        //             else
        //                 System.out.println("Wrong Answer!\n");
        //         }
        //     }
        //     i++;
        // }

        // sc.close();
    }
}
