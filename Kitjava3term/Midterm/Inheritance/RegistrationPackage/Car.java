package Midterm.Inheritance.RegistrationPackage;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String make, String model, String registrationNumber, int numberOfDoors){
        super(make, model, registrationNumber);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors(){
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors){
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayVehicleInfo(){
        super.displayVehicleInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
    }

}
