package Midterm.Test;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = s.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = s.nextInt();

      
        int i = 1, num3 =num1 + num2;

        do {
            int j = num1 % i;
            int k = num2 % i;
            if ((j == 0) || (k == 0)){
                if (j == k){
                    System.out.println("GCD:"+i);
                }
            } i++;
        } 
        while (i < num3);
        
        
        
      
    }   
}