package Midterm.Test;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = s.nextInt();

        int div = num % 3;
        int div2 = num % 5;

        if ((div == 0) && (div2 == 0)){
            System.out.println("Number is divisible by 3 and 5");
        } else if ((div != 0) && (div2 != 0)){
            System.out.println("Number is not divisible by 3 and 5");
        } else if ((div == 0) && (div2 != 0)){
            System.out.println("Number is divisible by 3");
        } else if ((div != 0) && (div2 == 0)){
            System.out.println("Number is divisible by 5");
        }
        
        
    }  
}
