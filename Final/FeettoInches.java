package Final;

public class FeettoInches {
    private int feet;
    private int inches;

    public void setFeet(int feet){
        this.feet = feet;
    }

    public void displayConversion(){

        inches = 12;

        int convert = feet*inches;

        System.out.println("Equivalent in Inches = " + convert);
    }


}
