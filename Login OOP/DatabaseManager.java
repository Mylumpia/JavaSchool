import java.sql.*;


public class DatabaseManager {

    private String url = "jdbc:mysql://localhost:3306/credential";
    private String dbUser = "root";
    private String dbPassword = "";

    
    public boolean authU(String username){
        String queryU = "SELECT * FROM user WHERE username = ?";
       
        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            PreparedStatement pst = conn.prepareStatement(queryU)){

                pst.setString(1, username);
      
                try(ResultSet rs = pst.executeQuery()){
                    return rs.next();
                }

            }catch (SQLException e){
                e.printStackTrace();
                return false;
            }   

    }




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
    

    public void updateUser(String username, String password){
        String updateQuery = "Update user Set password = ? where username = ?";

        try(Connection conn2 = DriverManager.getConnection(url,dbUser,dbPassword);
            PreparedStatement pst2 = conn2.prepareStatement(updateQuery)){

                pst2.setString(2, username);
                pst2.setString(1, password);

                int rowsAffected = pst2.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println("Password Updated Successfully!");
                }else{
                    System.out.println("Failed to add the student.");
                }

    
    }catch (SQLException e){
        e.printStackTrace();
        
    }
    
    }
    public void deleteUser(String username){
        String deleteQuery = "DELETE FROM user WHERE username = ?";


        try(Connection conn2 = DriverManager.getConnection(url,dbUser,dbPassword);
            PreparedStatement pst2 = conn2.prepareStatement(deleteQuery)){

                pst2.setString(1, username);
                
                int rowsAffected = pst2.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println("User Deleted Successfully!");
                }else{
                    System.out.println("Failed to add the student.");
                }

    
    }catch (SQLException e){
        e.printStackTrace();
        
    }

    

    
    
    }
}