package Midterm.Inheritance.FuneralPackage;
import java.util.ArrayList;

public class Funeral {
    public static void main(String[] args) {
        ArrayList<FuneralService> services = new ArrayList<>();

        services.add(new CremationService("John Doe", "Cremation", "2025-03-25", 1500.00, "Alice Verja", true));
        services.add(new BurialService("Jane Smith", "Burial", "2025-03-26", 3000.00, "Bob Lucas", "Bacolod Public Cemetery"));
        services.add(new CremationService("Mark White", "Creamtaion", "2025-03-27", 1300.00, "Sally Monte", false));

        for(FuneralService service : services){
            if (service.getServiceType().equals("Cremation")) {
                System.out.println("This is a cremation service. Details:");
            }else if (service.getServiceType().equals("Burial")) {
                System.out.println("This is a burial service. Details: ");
            }
            service.displayServiceDetails();
            System.out.println();
        }


    }
    
}
