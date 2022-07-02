import classes.*;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Output {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String v_1 = "myQuiz3";
        Quiz v_2 = new Quiz(v_1);
        Quiz quiz = v_2;
        BQuest v_3 = new BQuest()
        .add(new Question(
            new NumericAnswer().setKeywords(Arrays.asList("87.0")).setOptions(Arrays.asList("87.0")),
            "Em que port são passados os pacotes http?",
            "Programação",
            Difficulty.HARD))
        .add(new Question(
            new ShortAnswer().setKeywords(Arrays.asList("calcular","hipotenusa")).setOptions(Arrays.asList("calcular","hipotenusa")),
            "Quando utilizamos o Teorema de Pitágoras?",
            "Matemática",
            Difficulty.HARD))
        .add(new Question(
            new MultipleChoice().setKeywords(Arrays.asList("Laranja")).setOptions(Arrays.asList("Laranja")),
            "Qual destas frutas tem cor laranja?",
            "TemaTeste",
            Difficulty.EASY));
        BQuest bq = v_3;
        ArrayList<Question> v_4 = bq.getQuestions();
        ArrayList<Question> a = v_4;
        quiz.addGroup(a);
        ArrayList<Group> v_5 = quiz.getGroups();
        for (Group group : v_5) {
            ArrayList<Question> v_6 = group.getQuestions();
            for (Question q : v_6) {
                System.out.println(q);
                String v_7 = "Answer:";
                System.out.print(v_7);
                String v_8 = sc.nextLine();
                String respostaUser = v_8;
                Type v_10 = q.getType();
                String v_11 = v_10.getName();
                String v_12 = "Essay";
                Boolean v_9 = v_11.equals(v_12);
                Boolean v_13 = !(v_9);
                if (v_13) {
                    Type v_15 = q.getType();
                    String v_16 = v_15.getName();
                    String v_17 = "ShortAnswer";
                    Boolean v_14 = v_16.equals(v_17);
                    Boolean v_18 = !(v_14);
                    if (v_18) {
                        Double v_19 = Double.parseDouble(respostaUser);
                        Double resposta = v_19;
                    }
                    Type v_21 = q.getType();
                    String v_22 = v_21.getRightAnswer();
                    Boolean v_20 = respostaUser.equals(v_22);
                    if (v_20) {
                        String v_23 = "Resposta correta. Parabéns.";
                        System.out.println(v_23);
                    }
                }
            }
        }

        sc.close();
    }
}