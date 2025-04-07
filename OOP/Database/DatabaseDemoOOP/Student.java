public class Student {
    private String studentId;
    private String lname;
    private String fname;
    private String mi;

    public Student(String studentId, String lname, String fname, String mi) {
        this.studentId = studentId;
        this.lname = lname;
        this.fname = fname;
        this.mi = mi;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getLname() {
        return lname;
    }
    public String getFname() {
        return fname;
    }
    public String getMi() {
        return mi;
    }
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Last Name: " + lname + ", First Name: " + fname + ", Middle Initial: " + mi;
    }
}