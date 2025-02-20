package Midterm.OOP;

public class Person {
    //Instance varialble (attributes)  
    private String name;
    private int age;
    private String gender;
    private String address;
    private String job;


    //setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    //getter for 'name'
    public String getName() {
         return name;
    }

    //setter for 'age'
    public void setAge(int age){
        this.age = age;
    }

    //getter for 'age'
    public int getAge() {
        return age;
    }
    

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }



    public void setJob(String job){
        this.job = job;
    }

    public String getJob(){
        return job;
    }











    //Method to display person details
    public void displayInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Location: " + getAddress());
        System.out.println("Class: " + getJob());
    }


}
