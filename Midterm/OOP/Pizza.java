package Midterm.OOP;

public class Pizza {
    int toppings,diameter;
    double price;

    Pizza(int t, int d, double p){
        toppings = t;
        diameter = d;
        price = p;
    }
    
    public int getToppings(){
        return toppings;
    }

    public int getDiameter(){
        return diameter;
    }

    public double getPrice(){
        return price;
    }

    public void checkToppings(){
        if (toppings == 1)
            System.out.println("Toppings : Pepperoni");
        else
            System.out.println("Toppings : Chesse");
    }
}
