// SignUpPanel.java
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SignUpPanel extends JPanel {
    private final MainFrame mainFrame;
    private final PatientManager patientManager;

    public SignUpPanel(MainFrame mainFrame, PatientManager patientManager) {
        this.mainFrame = mainFrame;
        this.patientManager = patientManager;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));
        add(createHeader("Patient Registration"), BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(10, 2, 10, 5));
        form.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        form.setBackground(new Color(240, 248, 255));

        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30)); // width: 200px, height: 30px
        JPasswordField passwordField = new JPasswordField();
        JTextField ageField = new JTextField();
        JTextField dobField = new JTextField();
        JTextField sexField = new JTextField();
        JTextField contactField = new JTextField();
        JComboBox<String> statusCombo = new JComboBox<>(new String[]{"regular", "PWD", "senior", "staff"});
        JTextField addressField = new JTextField();

        form.add(new JLabel("First Name:")); form.add(firstNameField);
        form.add(new JLabel("Last Name:")); form.add(lastNameField);
        form.add(new JLabel("Email:")); form.add(emailField);
        form.add(new JLabel("Password:")); form.add(passwordField);
        form.add(new JLabel("Age:")); form.add(ageField);
        form.add(new JLabel("Date of Birth (YYYY-MM-DD):")); form.add(dobField);
        form.add(new JLabel("Sex:")); form.add(sexField);
        form.add(new JLabel("Contact Number:")); form.add(contactField);
        form.add(new JLabel("Status:")); form.add(statusCombo);
        form.add(new JLabel("Address:")); form.add(addressField);

        add(new JScrollPane(form), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));

        JButton registerBtn = UIUtils.createStyledButton("Register", new Color(0, 102, 204));
        registerBtn.addActionListener(e -> handleRegistration(
            firstNameField.getText(),
            lastNameField.getText(),
            emailField.getText(),
            new String(passwordField.getPassword()),
            ageField.getText(),
            dobField.getText(),
            sexField.getText(),
            contactField.getText(),
            (String) statusCombo.getSelectedItem(),
            addressField.getText()
        ));

        JButton backBtn = UIUtils.createStyledButton("Back to Login", new Color(0, 102, 204));
        backBtn.addActionListener(e -> mainFrame.showPanel("Login"));

        buttonPanel.add(backBtn);
        buttonPanel.add(registerBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void handleRegistration(String firstName, String lastName, String email, String password,
                                String ageStr, String dobStr, String sex, String contact,
                                String status, String address) {
        // Validate required fields
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            UIUtils.showError(this, "First name, last name, email and password are required!");
            return;
        }

        // Create patient object
        Patient patient = new Patient(firstName, lastName, email, password);
        
        try {
            // Set optional fields
            if (!ageStr.isEmpty()) patient.setAge(Integer.parseInt(ageStr));
            if (!dobStr.isEmpty()) {
                patient.setDob(LocalDate.parse(dobStr, DateTimeFormatter.ISO_DATE));
            }
            if (!sex.isEmpty()) patient.setSex(sex);
            if (!contact.isEmpty()) patient.setContact(contact);
            patient.setStatus(status);
            if (!address.isEmpty()) patient.setAddress(address);

            // Register patient
            patientManager.registerPatient(patient);
            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            mainFrame.showPanel("Login");
        } catch (DateTimeParseException e) {
            UIUtils.showError(this, "Please enter date in YYYY-MM-DD format!");
        } catch (NumberFormatException e) {
            UIUtils.showError(this, "Please enter a valid age!");
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                UIUtils.showError(this, "Email already registered!");
            } else {
                UIUtils.showError(this, "Registration failed: " + e.getMessage());
            }
        }
    }

    private JPanel createHeader(String title) {
        JPanel header = new JPanel();
        header.setBackground(new Color(0, 102, 204));
        header.setPreferredSize(new Dimension(100, 50));

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        header.add(label);

        return header;
    }
}