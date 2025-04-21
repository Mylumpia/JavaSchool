import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        DatabaseManager dbManager = new DatabaseManager();
        LoginManager loginManager = new LoginManager(dbManager);
        

        while (true) {
        Scanner scanner = new Scanner(System.in);  
        
        System.out.println("--- MENU ---");
        System.out.println("1. Add User Credential");
        System.out.println("2. Test Login");
        System.out.println("3. Search and Edit");
        System.out.println("4. Delete User");
        System.out.println("5. Exit");
        System.out.print("Select an option (1-5): ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1){
            System.out.println("");
            loginManager.addUserCred();
            System.out.println("");

        }else if(option == 2){
            System.out.println("");
            loginManager.startLoginProccess();
            System.out.println("");
        
        }else if (option == 5){
            System.out.println("");
            System.out.println("Goodbye!");
            System.out.println("");
            break;
        }else if (option == 3){
            System.out.println("");
            loginManager.updateUserCred();
            System.out.println("");

        }else if (option == 4){
            System.out.println("");
            loginManager.deleteUser();
            System.out.println("");
        }



        }
              


    }
    
}
