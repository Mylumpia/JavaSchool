import java.util.Scanner;

public class SumFiveIntermals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, i, sum;
        System.out.println("Enter Number > 10:: ");
        n = s.nextInt();
        i = 5;
        sum = 0;
        do {
            sum = sum + i;
            i = i + 5;
        }while (i <=n);
        System.out.println("Sum = " + sum);
        s.close();



        
    } 
}
