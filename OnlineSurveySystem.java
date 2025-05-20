package JAVAPROJECT;
import java.util.Scanner;

public class OnlineSurveySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Questions and choices
        String[] questions = {
            "1. How satisfied are you with our service?",
            "2. How likely are you to recommend us?",
            "3. How would you rate our customer support?"
        };

        String[] options = {
            "A. Very Unsatisfied", 
            "B. Unsatisfied", 
            "C. Neutral", 
            "D. Satisfied", 
            "E. Very Satisfied"
        };

        // To store answers
        int[][] responses = new int[questions.length][5];

        System.out.print("Enter number of participants: ");
        int participants = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int p = 0; p < participants; p++) {
            System.out.println("\nParticipant " + (p + 1) + ":");

            for (int q = 0; q < questions.length; q++) {
                System.out.println(questions[q]);
                for (String option : options) {
                    System.out.println(option);
                }

                char answer;
                while (true) {
                    System.out.print("Your answer (A-E): ");
                    answer = Character.toUpperCase(scanner.next().charAt(0));
                    if (answer >= 'A' && answer <= 'E') {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please choose A, B, C, D, or E.");
                    }
                }
                responses[q][answer - 'A']++;
            }
        }

        // Display survey results
        System.out.println("\nSurvey Summary:");
        for (int q = 0; q < questions.length; q++) {
            System.out.println("\n" + questions[q]);
            for (int i = 0; i < options.length; i++) {
                System.out.println(options[i] + " - " + responses[q][i] + " response(s)");
            }
        }

        scanner.close();
    }
}