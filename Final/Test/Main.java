package Final.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Library lib = new Library();
    
        
        while (true) {
        System.out.println("Menu:");
        System.out.println("1. Browse Book");
        System.out.println("2. Add a Book");
        System.out.println("3. Remove a Book");
        System.out.println("4. Exito");

        System.out.print("Choose an option: ");
        int choice = s.nextInt();

        if(choice == 1){
            lib.displayBooks();

        }else if(choice == 2){

            s.nextLine();
        System.out.print("Enter Title: ");
        String title = s.nextLine();

        System.out.print("Enter Author: ");
        String author = s.nextLine();

        System.out.print("Enter Page: ");
        int page = s.nextInt();

        Book b = new Book(title, author, page);
        
        lib.addBook(b);

        System.out.println("Successfully Added!");

        }else if(choice == 3){
            s.nextLine();
        System.out.print("Enter the title of the book to remove: ");
        String title = s.nextLine();
        
        Book k = new Book(title);

        lib.removeBook(k);
        System.out.println("Removed Successfully!");

        }else if(choice == 4){
            System.out.println("Exitooooo!");
            break;
            
        }else{
            System.out.println("Invalid Choice!");

        }
    }
        


        
    }
    
}
