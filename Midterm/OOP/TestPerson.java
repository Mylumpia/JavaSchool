package Midterm.OOP;

public class TestPerson {
    public static void main(String[] args) {
        
        //Create an ibject if the person class
        Person person1 = new Person();

        //use setters to assign values to the object's attributes
        person1.setName("Alice");
        person1.setAge(25);
        person1.setGender("Female");
        person1.setAddress("Bacolod");
        person1.setJob("Mage");

        //call method to display the object's details
        person1.displayInfo();
        System.out.println();

        //Create another object of the Person class
        Person person2 = new Person();

        //use setters to assign values to the second object's attributes
        person2.setName("Sung Jin Woo");
        person2.setAge(21);
        person2.setGender("Male");
        person2.setAddress("Silay");
        person2.setJob("Shadow Monarch");

        //call method to display the second object's details
        person2.displayInfo();
        


        
    }
    
}
