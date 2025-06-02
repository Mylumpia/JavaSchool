import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CropDB {

    private String url = "jdbc:mysql://localhost:3306/javadatabase";
    private String dbUser = "root";
    private String dbPassword = "";  


    public void checkCrops(String cropName){
        String checkC = "SELECT * FROM crop WHERE cropName = ?";

        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            PreparedStatement pst = conn.prepareStatement(checkC)){

                pst.setString(1, cropName);
      
                try(ResultSet rs = pst.executeQuery()){
                    rs.next();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }   


    }


    public void displayCrops(){
        String viewQuery = "SELECT cropName, cropQuantity FROM crop";
        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            Statement statement = conn.createStatement()){

            ResultSet rs = statement.executeQuery(viewQuery);
            
            while (rs.next()) {
               
                String cropName = rs.getString("cropName");
                int cropQuantity = rs.getInt("cropQuantity");
                

        
                System.out.println("CropName: " + cropName + " | CropQuantity: " + cropQuantity ); 
                
               
            }    
                  
          }catch (SQLException e){
            e.printStackTrace();
        }

    }








}