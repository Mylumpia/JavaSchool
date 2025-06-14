// PatientManager.java
import java.sql.*;

public class PatientManager {
    private int currentPatientId = -1;
    private String currentPatientName = "";

    public boolean login(String email, String password) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT patient_id, first_name FROM patients WHERE email = ? AND password = ?")) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                currentPatientId = rs.getInt("patient_id");
                currentPatientName = rs.getString("first_name");
                return true;
            }
            return false;
        }
    }

    public void registerPatient(Patient patient) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO patients (first_name, last_name, email, password, age, dob, sex, contact, status, address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            
            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getLastName());
            stmt.setString(3, patient.getEmail());
            stmt.setString(4, patient.getPassword());
            stmt.setInt(5, patient.getAge());
            stmt.setDate(6, patient.getDob() != null ? Date.valueOf(patient.getDob()) : null);
            stmt.setString(7, patient.getSex());
            stmt.setString(8, patient.getContact());
            stmt.setString(9, patient.getStatus());
            stmt.setString(10, patient.getAddress());
            
            stmt.executeUpdate();
        }
    }

    public int getCurrentPatientId() {
        return currentPatientId;
    }

    public String getCurrentPatientName() {
        return currentPatientName;
    }

    public void logout() {
        currentPatientId = -1;
        currentPatientName = "";
    }
}