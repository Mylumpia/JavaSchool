import java.util.Scanner;

public class FindLowest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int num1, num2, num3;

        System.out.print("Enter the first number: ");
        num1 = s.nextInt();

        System.out.print("Enter the sencond number: ");
        num2 = s.nextInt();

        System.out.print("Enter the third number: ");
        num3 = s.nextInt();

        if ((num1 < num2) && (num1 < num3)){
            System.out.println("The lowest number is: " + num1);
        }else if ((num2 < num3) && (num2 < num1)){
            System.out.println("The lowest number is: " + num2);
        }else {
            System.out.println("The lowest number is: " + num3);  
        }      

    }
}
