import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    char correctOption;

    // Constructor
    public Question(String questionText, String[] options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Display question and options
    public void displayQuestion() {
        System.out.println(questionText);
        char optionLabel = 'A';
        for (String option : options) {
            System.out.println(optionLabel + ". " + option);
            optionLabel++;
        }
    }

    // Check if the answer is correct
    public boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(correctOption);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();

        // Add questions to the quiz
        quiz.add(new Question(
    "Which language is primarily used for Android app development?",
    new String[]{"Swift", "Kotlin", "Python", "C#"},
    'B'
));

quiz.add(new Question(
    "What does HTTP stand for?",
    new String[]{"HyperText Transfer Protocol", "HighText Transfer Protocol", "HyperText Transmission Protocol", "Home Tool Transfer Protocol"},
    'A'
));

quiz.add(new Question(
    "Which data structure uses LIFO (Last In, First Out)?",
    new String[]{"Queue", "Stack", "Array", "LinkedList"},
    'B'
));

quiz.add(new Question(
    "What is the output of 3 + 2 * 2 in Java?",
    new String[]{"10", "7", "9", "12"},
    'B' // 2*2 = 4 + 3 = 7
));

quiz.add(new Question(
    "Who is known as the father of computers?",
    new String[]{"Alan Turing", "Charles Babbage", "Tim Berners-Lee", "Dennis Ritchie"},
    'B'
));


        int score = 0;

        // Loop through each question
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            Question q = quiz.get(i);
            q.displayQuestion();

            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = scanner.next().charAt(0);

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! The correct answer was: " + q.correctOption);
            }
        }

        // Final Score
        System.out.println("\nYour final score is: " + score + "/" + quiz.size());
        scanner.close();
    }
}
