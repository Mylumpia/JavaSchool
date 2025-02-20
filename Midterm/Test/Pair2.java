package Midterm.Test;

import java.util.Scanner;

public class Pair2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = s.nextInt();

        int i = 0;
        for (int x = 1; x <= number; x++){
            i = x + i ;        

            System.out.print( i ); 
            if (x != number){
                System.out.print(", ");
            }
            
        }
    } 
}