import java.util.Scanner;

public class Loudness {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double userinput;

        System.out.print("Enter the Loudness in Decibels (db): ");
        userinput = s.nextDouble();

        if (userinput < 51){
            System.out.print("Quiet");
        }else if (userinput <= 70){
            System.out.print("Intrusive");
        }else if (userinput <= 90){
            System.out.print("Annoying");
        }else if (userinput <= 110){
            System.out.print("Very Annoying");
        }else if (userinput > 110){
            System.out.print("Unconfortable");
        }



    }
}
