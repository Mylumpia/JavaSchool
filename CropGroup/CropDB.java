import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CropDB {

    private String url = "jdbc:mysql://localhost:3306/cropDb";
    private String dbUser = "root";
    private String dbPassword = "";  


    public void checkCrops(String cropType){
        String checkC = "SELECT * FROM crop WHERE cropType = ?";

        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            PreparedStatement pst = conn.prepareStatement(checkC)){

                pst.setString(1, cropType);
      
                try(ResultSet rs = pst.executeQuery()){
                    rs.next();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }   


    }


    public void displayCrops(){
        String viewQuery = "SELECT cropType, cropQuantity FROM crop";
        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            Statement statement = conn.createStatement()){

            ResultSet rs = statement.executeQuery(viewQuery);
            int i = 1;
            while (rs.next()) {
               
                String cropType = rs.getString("cropType");
                int cropQuantity = rs.getInt("cropQuantity");
                

                
                System.out.println(i + ": Crop Type: " + cropType + " | Crop Quantity: " + cropQuantity ); 
                i++;
               
            }    
                  
          }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void displayFerts(){
        String viewQuery = "SELECT fertilizerName, fertilizerPrice FROM fertilizer";
        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
            Statement statement = conn.createStatement()){

            ResultSet rs = statement.executeQuery(viewQuery);
            int i = 1;
            while (rs.next()) {
               
                String fertilizerName = rs.getString("fertilizerName");
                int fertilizerPrice = rs.getInt("fertilizerPrice");
                
                
                
                System.out.println(i + ": Fertilizer Name: " + fertilizerName + " | Fertilizer Price: " + fertilizerPrice );  
                i++;   
            } 
                  
          }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void fertsSum(String fertilizerName){
        String viewQuery = "SELECT fertilizerPrice FROM fertilizer WHERE fertilizerName = ?";
        try (Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
                PreparedStatement stmt = conn.prepareStatement(viewQuery)) {
            stmt.setString(1, fertilizerName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                   int fertilizerPrice = rs.getInt("fertilizerPrice");

                    System.out.println(fertilizerPrice);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving invoice: " + e.getMessage());

        }
    }

    public boolean editPass(int id, double cropQuantity){
        String editquery ="UPDATE users SET cropQuantity=? WHERE id=?";
        try(Connection conn=DriverManager.getConnection(url, dbUser, dbPassword);
            PreparedStatement pst=conn.prepareStatement(editquery)){
    
                pst.setInt(1, id);
                pst.setDouble(2, cropQuantity);

                int rowsAffected=pst.executeUpdate();
                return rowsAffected>0;
        
        } catch (SQLException e) {
            if(e.getErrorCode()==1062){
                System.out.println("Password cannot be changed.");
            }else{
                e.printStackTrace();
            }
          
           return false;
        }}
        
    public boolean updateQuantity(String cropType, int cropQuantity) {
     String query = "UPDATE crop SET cropQuantity = ? WHERE cropType= ?";

    try {
   
    Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
    PreparedStatement pst = conn.prepareStatement(query);

    pst.setString(1, cropType);
    pst.setInt(2, cropQuantity);

    int rowsUpdated = pst.executeUpdate();
    
    return rowsUpdated > 0;

} catch (SQLException e) {
    e.printStackTrace();
    return false;
}
}

  public boolean updateFertilizer(int id, int fertilizerPrice) {
    String query = "UPDATE crop SET fertilizerPrice=? WHERE id=?";

try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
    PreparedStatement pst = conn.prepareStatement(query)){

    pst.setInt(1, id);
    pst.setInt(2, fertilizerPrice);

    int rowsUpdated = pst.executeUpdate();
    
    return rowsUpdated > 0;

} catch (SQLException e) {
    e.printStackTrace();
    return false;
}
}





















}