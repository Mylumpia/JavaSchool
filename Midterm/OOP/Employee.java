package Midterm.OOP;

public class Employee {
    private int empNum;
    private String empLastName;
    private String empFirstName;
    private double empSalary;

    Employee(){
        empNum = 123456;
        empLastName = "Reyes";
        empFirstName = "Charle";
        empSalary = 20000.00;
    }

    public int getEmpNum(){
        return empNum;
    }

    public String getLastName(){
        return empLastName;
    }

    public String getFirstName(){
        return empFirstName;
    }

    public double getSalary(){
        return empSalary;
    }

    public void setEmpNum(int e){
        empNum = e;
    }

    public void setLastName(String last){
        empLastName = last;
    }
    
    public void setFirstName(String first){
        empFirstName = first;
    }

    public void setSalary(double sal){
        empSalary = sal;
    }
    
}
