import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class CropApp {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        CropDB cropDB = new CropDB();

        while (true) {

            System.out.println("\n--- Crop Menu ---\n");
            System.out.println("1. Check Quantity");
            System.out.println("2. Buy Crops");
            System.out.println("3. Buy Fertilizers");
            System.out.println("4. Pest Control");
            System.out.println("5. Labor payment");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                System.out.println("\n--- Check Quantity ---\n");
                cropDB.displayCrops();
                
            }

            else if(choice == 2){
                System.out.println("\n--- Buy Crops ---\n");
                
                
            }

            else if(choice == 3){
                System.out.println("\n--- Buy Fertilizers ---\n");
                
                
            }

            else if(choice == 4){
                System.out.println("\n---  Pest Control ---\n");
                
                
            }

            else if(choice == 5){
                System.out.println("\n--- Labor payment ---\n");
                
                
            }

            else if(choice == 6){
                System.out.println("\n--- Exit ---\n");
                break;
                
            }






        }


    }
}
