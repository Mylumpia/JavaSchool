import java.util.Scanner;

public class PiggyBank {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        
        double twenty = 20, ten = 10, five = 5, one = 1, cent25 = .25 ,cent10 = .10;
        double total, u1, u2, u3, u4, u5, u6;

        System.out.print("Enter # of 20 peso coin: ");
        u1 = user.nextDouble();

        System.out.print("Enter # of 10 peso coin: ");
        u2 = user.nextDouble(); 
        
        System.out.print("Enter # of 5 peso coin: ");
        u3 = user.nextDouble();

        System.out.print("Enter # of 1 peso coin: ");
        u4 = user.nextDouble();

        System.out.print("Enter # of 25 cent coin: ");
        u5 = user.nextDouble();

        System.out.print("Enter # of 10 cent coin: ");
        u6 = user.nextDouble();

        total = (u1*twenty) + (u2*ten) + (u3*five) + (u4*one) + (u5*cent25) + (u6*cent10);

        System.out.println("Total Piggy Bank Value = " + total);

    }
}
