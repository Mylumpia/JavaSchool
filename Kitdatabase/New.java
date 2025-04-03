import java.sql.*;
import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javadatabase";
        String user = "root";
        String password = "";

        String selectQuery = "SELECT studentid, lname, fname, mi From student";
        String insertQuery = "INSERT INTO student (studentid, lname, fname, mi) VALUES (?,?,?,?)";

        Scanner scanner = new Scanner(System.in);


        while (true) {
            try{
                
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);



        System.out.println("Menu:");
        System.out.println("1. Add a new student");
        System.out.println("2. Show all records");
        System.out.println("3. Exit the program");
        System.out.print("Enter your Choice (1/2/3):");
        int choice = scanner.nextInt();

            if (choice == 2) {
                
    
    
                System.out.println("Existing Students in the database:");
                while (resultSet.next()) {
                    String studentid = resultSet.getString("studentid");
                    String lname = resultSet.getString("lname");
                    String fname = resultSet.getString("fname");
                    String mi = resultSet.getString("mi");
    
                    System.out.println("Student ID: " +studentid + " Last Name: " +lname + " First Name: " +fname+ " MI: " + mi);  
                }


            }else if (choice == 1) {
                
                System.out.println("\nAdd a new student to the database.");
                scanner.nextLine();
                System.out.println("Enter Student ID: ");
                String studentid = scanner.nextLine();
                System.out.println("Enter Last Name: ");
                String lname = scanner.nextLine();
                System.out.println("Enter First Name: ");
                String fname = scanner.nextLine();
                System.out.println("Enter Middle Initial: ");
                String mi = scanner.nextLine();
    
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, studentid);
                preparedStatement.setString(2, lname);
                preparedStatement.setString(3, fname);
                preparedStatement.setString(4, mi);
    
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println("Successfully added the student: " +studentid + ", "+lname + ", " +fname+ ", "+mi);
                }else{
                    System.out.println("Failed to add the student.");
                }
                preparedStatement.close();
                
            }else if (choice == 3){
                break;
            }

            
                resultSet.close();
                statement.close();
                connection.close();
                
            


            }catch (ClassNotFoundException e){
                System.out.println("MySQL JDBC Driver not found!");
                e.printStackTrace();
            } catch (SQLException e){
                System.out.println("Connection failed!");
                e.printStackTrace();
            }

    }
    scanner.close();

}
}