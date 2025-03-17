package Midterm.Inheritance;

public class StudentTest {
    public static void main(String[] args) {
        StudentScholar Maria = new StudentScholar();
        
        
        Maria.setSPN("CS1234567");
        Maria.setCourse("BSCS");
        Maria.setAge(17);
        Maria.setScholarType("SM");
        Maria.setDiscountedPercentage(75);

        System.out.println("SPN # : " + Maria.getSPN());
        System.out.println("Course: " + Maria.getCourse());
        System.out.println("Age : " + Maria.getAge());
        System.out.println("Type : " + Maria.getScholarType());
        System.out.println("Discount % :" + Maria.getDiscountedPercentage());

    }
    
}
