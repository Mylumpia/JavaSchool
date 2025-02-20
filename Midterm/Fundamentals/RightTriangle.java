import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        /*int num;

        System.out.println("Enter Number: ");
        num = s.nextInt();

        boolean isPrime = true;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime ? "Prime" : "Composite");
*/

        int num;
        char log = '*';
        System.out.println("Enter Height: ");
        num = s.nextInt();

        for (int f = 1; f <= num; f++){
            for (int x = 1; x <= f; x++){
            System.out.print(log); 
        }  
        System.out.println();
     }
    }

}
