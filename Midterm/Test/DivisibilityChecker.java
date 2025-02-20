// JOHN KEITH GARCIA

package Midterm.Test;

import java.util.Scanner;

public class DivisibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = scanner.nextInt();

       /* if (number % 3 == 0 && number % 5 ==0)
            System.out.println("Number is divisible by both 3 and 5");
        else if (number % 3 == 0)
            System.out.println("Number is divisible by 3");
        else if (number % 5 == 0)
            System.out.println("Number is divisible by 5");
        else
            System.out.println("Number is not divisible by 3 and 5"); */

        String result = (number % 3 == 0 && number % 5 == 0 )  ? "Number is divisible by both 3 and 5" 
            : (number % 3 == 0 ) ? "Number is divisible by 3" 
            : (number % 5 == 0) ? "Number is divisible by 5"
            : "Number is not divisible by 3 and 5";


        System.out.println(result);


    }
}
