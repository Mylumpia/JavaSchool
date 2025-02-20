import java.util.Scanner;

public class HelloWorld{

    public static void main(String[] args) {
        Scanner radius = new Scanner(System.in);
        
        
        double  area, userinput;

        double pie = 3.1416;

        System.out.print("Enter the radius: ");
        userinput = radius.nextDouble();

        area = pie * (userinput * userinput);

        System.out.println("The Area is: " + area);

    }
}