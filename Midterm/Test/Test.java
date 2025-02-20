package Midterm.Test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = s.nextInt();

        if (num < 0){
            System.err.println("Number is Negative");
        } else if (num > 0){
            System.out.println("Number is Positive");
        } else if(num == 0) {
            System.out.println("Number is Zero");
        }
        
    }
}
