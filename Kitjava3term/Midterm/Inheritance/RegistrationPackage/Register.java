package Midterm.Inheritance.RegistrationPackage;

public class Register {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", "ABC123", 4);
        car1.displayVehicleInfo();

        System.out.println();

        Truck truck1 = new Truck("Ford", "F-150", "ZXXC456", 2.5);
        truck1.displayVehicleInfo();
    }
    
}
