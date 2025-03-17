package Midterm.Inheritance;

public class SuperEmployeeTest {
    public static void main(String[] args) {
        SubContractual carpenter = new SubContractual(2025, "Garcia", "Kit");

        carpenter.setContractNumber(40101);
        carpenter.setDesignation("Carpenter");

        carpenter.displayInfo();
    }
    
}
