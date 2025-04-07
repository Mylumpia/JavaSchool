import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/javadatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT studentid, lname, fname, mi FROM student";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String studentId = resultSet.getString("studentid");
                String lname = resultSet.getString("lname");
                String fname = resultSet.getString("fname");
                String mi = resultSet.getString("mi");

                Student student = new Student(studentId, lname, fname, mi);//added this
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve students: " + e.getMessage());
        }
        return students;
    }

    public boolean addStudent(Student student) {
        String insertQuery = "INSERT INTO student (studentid, lname, fname, mi) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, student.getStudentId());
            preparedStatement.setString(2, student.getLname());
            preparedStatement.setString(3, student.getFname());
            preparedStatement.setString(4, student.getMi());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Failed to add the student: " + e.getMessage());
            return false;
        }
    }
}