import java.util.Scanner;

public class StandardToMillitaryTime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int hours, mer, minutes;
        String x,z;
    
        System.out.print("Enter Hour(s): ");
        hours = s.nextInt();
        System.out.print("Enter Minute(s): ");
        minutes = s.nextInt();
        System.out.print("Enter Meridiem (Am = 1)(Pm = 2): "); 
        mer = s.nextInt();

        if (mer == 1){
            
            if (hours <= 12){
                hours -= hours;
                hours += hours;
            
            }
            
            x = "" + hours;

            z = x + minutes;
            System.out.println(z+" hrs");

        }else {
            hours += 12;

            System.out.println(hours+""+minutes+" hrs");
        }

        
       



    }
}
