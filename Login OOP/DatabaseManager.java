import java.sql.*;


public class DatabaseManager {

    private String url = "jdbc:mysql://localhost:3306/credential";
    private String dbUser = "root";
    private String dbPassword = "";


    public boolean authenticateUser(String username, String password){
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
       
        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setString(1, username);
                pst.setString(2, password);
                
     
                try(ResultSet rs = pst.executeQuery()){
                    return rs.next();
                }



            }catch (SQLException e){
                e.printStackTrace();
                return false;
            }   

    }

    public void addUser(String username, String password){
        String insertQuery = "INSERT INTO user (username, password) VALUES (?,?)";

        try(Connection conn1 = DriverManager.getConnection(url,dbUser,dbPassword);
            PreparedStatement pst1 = conn1.prepareStatement(insertQuery)){
        
                pst1.setString(1, username);
                pst1.setString(2, password);

                int rowsAffected = pst1.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println("User successfuly added!");
                }else{
                    System.out.println("Failed to add the student.");
                }

    
        }catch (SQLException e){
        e.printStackTrace();
        
    }
    
    }
}