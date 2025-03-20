package Midterm.Inheritance.RegistrationPackage;

public class Truck extends Vehicle{
    private double cargoCapacity;

    public Truck(String make, String model, String registrationNumber, double cargoCapacity){
        super(make, model, registrationNumber);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity(){
        return cargoCapacity;
    }
    
    public void setCargoCapacity(double cargoCapcity){
        this.cargoCapacity = cargoCapcity;
    }

    @Override
    public void displayVehicleInfo(){
        super.displayVehicleInfo();
        System.out.println("Cargo Capacity (tons): " + cargoCapacity);
    }

}
