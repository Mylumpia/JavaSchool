package Midterm.Inheritance;

class Animal {
    String name;


    public Animal(String name){
        this.name = name;
    }

    public void speak(){
        System.out.println(name + " makes a sound");
    }
}

class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

    public void display(){
        System.out.println(name + " is a dog");
    }
}


public class AnimalCore {
    public static void main(String[] args) {
   
        Dog dog = new Dog("Buddy");

        dog.speak();
        dog.display();
    }
}
