public class Loops {
    public static void main(String[] args) {
        System.out.println("For loop\n");

        for (int f=0;f < 10;f++){
            System.out.println(f);
        }
     
        System.out.println("\nWhile Loop\n");

        int w = 0;
        while (w < 10){
            System.out.println(w);
            w++;
        }

        System.out.println("\nDo While Loop\n");

        int dw = 0;
        do {
            System.out.println(dw);
            dw++;
        } while (dw < 10);   
        
        System.out.println("\nLoop Termination\n");
        
        for (int f=0; f < 10; f++){
            if (f == 4)
                break;
            else
                System.out.println(f);
        }

    } 
}
