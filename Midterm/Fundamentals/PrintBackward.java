public class PrintBackward {
    public static void main(String[] args) {
        
         /*for(int f = 10; f > 0 ; f--){
            if (!((f == 7) || (f == 3)))
                System.out.println(f);
            */
            
           /* int w = 1;

            while (w < 10){
                System.out.println(w);
                w++;
            }
        */
            int f = 1 , sum = 0;
            
            while (f < 10){
                System.out.println(f);
                sum += f;
                f+= 2;
            }

            System.out.println("The Sum is: " + sum);



    }
}
