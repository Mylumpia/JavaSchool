import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class CropApp {
    int[] crops = new int[Crops.seeds.length]; 
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
                cropDB.displayCrops();
            System.out.print("Enter Crop to buy (1 - 4): ");
            int cropSeed=scanner.nextInt();
            System.out.print("Enter Quantity to add: ");
            int q=scanner.nextInt();
            scanner.nextLine();

            if(cropSeed==1){
                
                int cropQuantity=100+q;
                boolean Quantity=cropDB.updateQuantity("Sugar Cane",cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }else if(cropSeed==2){
                int cropQuantity=100+q;
                boolean Quantity=cropDB.updateQuantity("Rice Grains",cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }else if (cropSeed==3){
                int cropQuantity=100+q;
                boolean Quantity=cropDB.updateQuantity("Corn",cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }else if(cropSeed==4){
                int cropQuantity=100+q;
                boolean Quantity=cropDB.updateQuantity("Eggplants",cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }
                
                
            }

            else if(choice == 3){
                System.out.println("\n--- Buy Fertilizers ---\n");

                cropDB.displayFerts();
                System.out.println("Select Fertilizer (1-2): ");
                int ferts = scanner.nextInt();
                
                if(ferts == 1){
                    cropDB.fertsSum("UREA (PRILLED)");
                    
                }
                if(ferts == 2){
                    cropDB.fertsSum("UREA (GRANULAR)");
                    
                }
                
                
            }

            else if(choice == 4){
                System.out.println("\n---  Pest Control ---\n");
                System.out.println("1. Buy BPMC+CHLORPYRIFOS / Price: 552.50 per liter");
                System.out.println("2. Buy CYPERMETHRIN / Price: 447.50 per liter");
                System.out.println("3. Buy LAMBDACYHALOTHRIN / Price: 632.50 per liter");
                System.out.print("Select an option: ");
                int pestChoice = scanner.nextInt();
                scanner.nextLine();
                if(pestChoice == 1){
                    System.out.println("You have selected BPMC+CHLORPYRIFOS");
                    System.out.println("Price: 552.50 per liter");
                }
                else if(pestChoice == 2){
                    System.out.println("You have selected CYPERMETHRIN");
                    System.out.println("Price: 447.50 per liter");
                }
                else if(pestChoice == 3){
                    System.out.println("You have selected LAMBDACYHALOTHRIN");
                    System.out.println("Price: 632.50 per liter");
                }
                else{
                    System.out.println("Invalid option selected.");
                }
                
                
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

    private static void displaycrops(){
        for (int i = 0; i < Crops.seeds.length; i++){
            
                System.out.println(Crops.seeds[i]);
            }
        }
}
