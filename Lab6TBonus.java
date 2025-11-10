import java.util.Random;
import java.util.Scanner;

public class Lab6TBonus {
    public static void main(String args[]) {
        Random r = new Random(System.currentTimeMillis());
        Scanner sc = new Scanner(System.in);

        System.out.print("Input how many students are there: ");
        int students = sc.nextInt();

        System.out.print("Input how many quizzes one student will have: ");
        int quizzes = sc.nextInt();

        int[][] scores = new int[students][quizzes];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < quizzes; j++) {
                scores[i][j] = r.nextInt(101);
            }
        }

        System.out.println("Scores table: ");
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < quizzes; j++) {
                System.out.printf("%4d", scores[i][j]);
            }

            System.out.println();
        }

        System.out.println("Students average: ");
        for (int i = 0; i < students; i++) {
            double sum = 0;

            for (int j = 0; j < quizzes; j++) {
                sum += scores[i][j];
            }

            double avg = sum / quizzes;

            System.out.printf("Student %d average: %.2f\n", i, avg);
        }

        System.out.println("Quizzes average: ");
        for (int j = 0; j < quizzes; j++) {
            double sum = 0;

            for (int i = 0; i < students; i++) {
                sum += scores[i][j];
            }

            double avg = sum / students;

            System.out.printf("Quiz %d average: %.2f\n", j, avg);
        }

        int highest = -1;
        int bestStudent = -1;
        int bestQuiz = -1;

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < quizzes; j++) {
                if (scores[i][j] > highest || (scores[i][j] == highest && i < bestStudent) || (scores[i][j] == highest && i == bestStudent && j < bestQuiz)) {
                    highest = scores[i][j];
                    bestStudent = i;
                    bestQuiz = j;
                }
            }
        }

        System.out.printf("Highest score: %d at (studentIndex=%d, quizIndex=%d)", highest, bestStudent, bestQuiz);
    }
}
