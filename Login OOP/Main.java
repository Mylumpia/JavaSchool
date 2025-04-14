import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        LoginManager loginManager = new LoginManager(dbManager);
        

        while (true) {
        Scanner scanner = new Scanner(System.in);  
        
        System.out.println("--- MENU ---");
        System.out.println("1. Add User Credential");
        System.out.println("2. Test Login");
        System.out.println("3. Exit");
        System.out.print("Select an option (1-3): ");
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
        
        }else{
            System.out.println("");
            System.out.println("Goodbye!");
            System.out.println("");
            break;
        }


    

        }
              


    }
    
}
