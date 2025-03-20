package Midterm.Inheritance.FuneralPackage;

public class BurialService extends FuneralService{
    private String cemeteryName;

    public BurialService(String clientName,String serviceType ,String dateOfService,double cost,String funeralDirector, String cemeteryName){
        super(clientName, serviceType, dateOfService, cost, funeralDirector);
        this.cemeteryName = cemeteryName;
    }

    public String getCemeteryName(){
        return cemeteryName;
    }

    public void setCemeteryName(String cemeteryName){
        this.cemeteryName = cemeteryName;
    }

    @Override
    public void displayServiceDetails(){
        super.displayServiceDetails();
        System.out.println("Cemetery Name: " + cemeteryName);
    }
    
}
