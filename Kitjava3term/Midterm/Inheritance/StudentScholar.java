package Midterm.Inheritance;

public class StudentScholar extends Student {
    private String scholarType;
    private int discountedPercentage;

    public void setScholarType(String s){
        scholarType = s;
    }
    public void setDiscountedPercentage(int d){
        discountedPercentage = d;
    }

    public String getScholarType(){
        return scholarType;
    }
    public int getDiscountedPercentage(){
        return discountedPercentage;
    }

}
