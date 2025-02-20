package Midterm.OOP;

public class TestPizza {
    public static void main(String[] args) {
        Pizza Combo1 = new Pizza(1, 13, 34.50);

        System.out.println("Toppings#: " + Combo1.getToppings());
        Combo1.checkToppings();
        System.out.println("Diameter: " + Combo1.getDiameter());
        System.out.println("Price: " + Combo1.getPrice());
    }
    
}
