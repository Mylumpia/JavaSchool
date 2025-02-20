package Final;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        int[] grades = new int[numGrades];


        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        Student student = new Student(name, grades);
        scanner.close();
    }
    
}
