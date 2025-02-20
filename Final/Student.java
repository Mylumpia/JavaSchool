package Final;

public class Student {
    private String name;
    private int[] grades;
    private double averageGrade;

    public Student(String name, int[]grades){
        this.name =name;
        this.grades = grades;
    
    
    if (grades == null||grades.length == 0){
        System.out.println("No grades available for " + name + ".Setting avarge to 0.");
        this.averageGrade = 0;
    }else{
        calculateAvarage();
    }
}

    private void calculateAvarage(){
        int total = 0;

    for (int grade : grades){
        total += grade;
    }

    double convert = total;

    averageGrade = convert/grades.length;

    if (averageGrade >= 90){
        System.out.println(name + " has an A grade.");
    }else if (averageGrade >= 80){
        System.out.println(name + " has a B grade.");
    }else if (averageGrade >= 70){
        System.out.println(name + " has a C grade.");
    }else if (averageGrade >= 60){
        System.out.println(name + " has a D grade.");
    }else {
        System.out.println(name + " has an F grade.");
    }

    System.out.printf(name + "'s avarege grade:%.2f%n", averageGrade);
    
    }



}

