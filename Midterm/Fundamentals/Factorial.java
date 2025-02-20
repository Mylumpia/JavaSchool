import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n, factorial = 1;

        System.out.println("Enter Number: ");
        n = s.nextInt();

       for (int i = 1; i <= n; i++) {
        factorial *= i;
       }

        System.out.println("Factorial = " + factorial);
    







    }
}
