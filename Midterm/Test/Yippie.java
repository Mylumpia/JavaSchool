package Midterm.Test;

import java.util.Scanner;

public class Yippie {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        System.out.print("Enter number: ");
        int num = s.nextInt();

            for (int a = 1; a <= num; a++){
                for (int b = a+1; b <= num; b++){
                    for (int c = b+1; c <= num; c++){
                        if (a*a + b*b == c*c){
                            System.out.println(a + " " + b +" " + c);
                            break;
                            }
                    }
                }
            }
                

    }
}
