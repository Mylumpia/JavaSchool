import java.util.List;
import java.util.Scanner;


public class StudentApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DatabaseManager dbManager = new DatabaseManager();

    public static void main(String[] args) {
        displayExistingStudent();

        Student newStudent = getStudentDetails();
        if (dbManager.addStudent(newStudent)){
            System.out.println("Successfully added the student:" + newStudent);
        }else{
            System.out.println("Failed to add the student.");
        }
        scanner.close();
    }
    private static void displayExistingStudent(){
        System.out.println("Existing Students in the database.");
        List<Student>students = dbManager.getAllStudents();
        for(Student student : students){
        System.out.println(student);
    }
}
private static Student getStudentDetails(){
    System.out.println("\nAdd a new student to the database.");
    System.out.print("Enter Student ID: ");
    String studentId = scanner.nextLine();

    System.out.print("Enter Last Name: ");
    String lname = scanner.nextLine();

    System.out.print("Enter First Name: ");
    String fname = scanner.nextLine();

    System.out.print("Enter Middle Initial: ");
    String mi = scanner.nextLine();

    return new Student(studentId, lname, fname, mi);
    }
}