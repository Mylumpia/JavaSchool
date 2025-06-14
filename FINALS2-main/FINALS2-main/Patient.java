// Patient.java
import java.time.LocalDate;

public class Patient {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private LocalDate dob;
    private String sex;
    private String contact;
    private String status;
    private String address;

    // Constructor
    public Patient(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
    public LocalDate getDob() { return dob; }
    public String getSex() { return sex; }
    public String getContact() { return contact; }
    public String getStatus() { return status; }
    public String getAddress() { return address; }

    public void setAge(int age) { this.age = age; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setSex(String sex) { this.sex = sex; }
    public void setContact(String contact) { this.contact = contact; }
    public void setStatus(String status) { this.status = status; }
    public void setAddress(String address) { this.address = address; }
}