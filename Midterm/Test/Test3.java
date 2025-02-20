

package Midterm.Test;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = s.nextInt();
        int sum = 0;
        for (int i=1 ;i < num; i++){
            int j =num % i;
            if (j == 0){
                int x = i+j;
                sum += x;
                
            
            }
        }System.out.println(sum);

    }
}        