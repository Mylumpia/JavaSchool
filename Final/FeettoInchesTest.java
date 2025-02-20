package Final;

import java.util.Scanner;

public class FeettoInchesTest {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        FeettoInches test = new FeettoInches();

        System.out.print("Enter the distance in feet: ");
        int feet = s.nextInt();

        test.setFeet(feet);
        test.displayConversion();

        s.close();

    }
    
}
