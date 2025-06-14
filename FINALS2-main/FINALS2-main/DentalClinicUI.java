import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.toedter.calendar.JCalendar;

public class DentalClinicUI extends JFrame {
    private CardLayout mainLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(mainLayout);
    private int currentPatientId = -1;

    // New fields for selected treatments and appointment date
    private List<String> selectedTreatments = new ArrayList<>();
    private Date selectedAppointmentDate = null;

    private JTextArea billingInfo;

    public static class DatabaseConnector {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/dental_clinic";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

        public static void initializeDatabase() {
            try (Connection conn = getConnection()) {
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS patients (" +
                    "patient_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(50) NOT NULL," +
                    "last_name VARCHAR(50) NOT NULL," +
                    "email VARCHAR(100) UNIQUE NOT NULL," +
                    "password VARCHAR(255) NOT NULL," +
                    "age INT," +
                    "dob DATE," +
                    "sex VARCHAR(10)," +
                    "contact VARCHAR(20)," +
                    "status VARCHAR(20)," +
                    "address TEXT)");

                stmt.execute("CREATE TABLE IF NOT EXISTS treatments (" +
                    "treatment_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "category VARCHAR(50) NOT NULL," +
                    "price DECIMAL(10,2) NOT NULL)");

                stmt.execute("CREATE TABLE IF NOT EXISTS appointments (" +
                    "appointment_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "patient_id INT NOT NULL," +
                    "treatment_id INT NOT NULL," +
                    "appointment_date DATE NOT NULL," +
                    "is_paid BOOLEAN DEFAULT FALSE," +
                    "FOREIGN KEY (patient_id) REFERENCES patients(patient_id)," +
                    "FOREIGN KEY (treatment_id) REFERENCES treatments(treatment_id))");

                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM treatments");
                if (rs.next() && rs.getInt(1) == 0) {
                    stmt.execute("INSERT INTO treatments (name, category, price) VALUES " +
                        "('Dental Consultation', 'Preventive', 50.00)," +
                        "('Teeth Cleaning', 'Preventive', 80.00)," +
                        "('Dental Fillings', 'Restorative', 120.00)");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database initialization failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public DentalClinicUI() {
        DatabaseConnector.initializeDatabase();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Dental Clinic Management");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel container = new JPanel(new BorderLayout());
        container.add(createLogoPanel(), BorderLayout.NORTH);

        mainPanel.add(createLoginScreen(), "Login");
        mainPanel.add(createSignUpScreen(), "SignUp");
        mainPanel.add(createDashboardScreen(), "Dashboard");
        mainPanel.add(createTreatmentPanel(), "Treatments");
        mainPanel.add(createBillingPanel(), "Billing");
        mainPanel.add(createAppointmentCalendarPanel(), "Calendar");

        container.add(mainPanel, BorderLayout.CENTER);
        add(container);
        setVisible(true);
        mainLayout.show(mainPanel, "Login");
    }

    private JPanel createLogoPanel() {
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(0, 102, 204));
        logoPanel.setPreferredSize(new Dimension(800, 80));

        JLabel logoLabel = new JLabel("Dental Clinic Management", SwingConstants.CENTER);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        logoPanel.add(logoLabel);
        return logoPanel;
    }

    private JPanel createLoginScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));
        panel.add(createHeader("Patient Login"), BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(40, 100, 20, 100));
        form.setBackground(new Color(240, 248, 255));

        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        form.add(new JLabel("Email:"));
        form.add(emailField);
        form.add(new JLabel("Password:"));
        form.add(passwordField);

        JButton loginBtn = new JButton("Login");
        styleButton(loginBtn);
        form.add(new JLabel());
        form.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (email.isEmpty() || password.isEmpty()) {
                showError("Please enter both email and password");
                return;
            }

            try (Connection conn = DatabaseConnector.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                    "SELECT patient_id FROM patients WHERE email = ? AND password = ?")) {

                stmt.setString(1, email);
                stmt.setString(2, password);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    currentPatientId = rs.getInt("patient_id");
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    mainLayout.show(mainPanel, "Dashboard");
                } else {
                    showError("Invalid email or password");
                }
            } catch (SQLException ex) {
                showError("Database error: " + ex.getMessage());
            }
        });

        panel.add(form, BorderLayout.CENTER);

        JPanel footer = new JPanel();
        footer.setBackground(new Color(240, 248, 255));
        JButton signUpBtn = new JButton("Sign Up");
        styleButton(signUpBtn, new Color(34, 139, 34));
        signUpBtn.addActionListener(e -> mainLayout.show(mainPanel, "SignUp"));
        footer.add(signUpBtn);
        panel.add(footer, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSignUpScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));
        panel.add(createHeader("Patient Registration"), BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(10, 2, 10, 5));
        form.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        form.setBackground(new Color(240, 248, 255));

        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField emailField = new JTextField();
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

        panel.add(new JScrollPane(form), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));

        JButton registerBtn = new JButton("Register");
        styleButton(registerBtn);
        registerBtn.addActionListener(e -> registerPatient(
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

        JButton backBtn = new JButton("Back to Login");
        styleButton(backBtn);
        backBtn.addActionListener(e -> mainLayout.show(mainPanel, "Login"));

        buttonPanel.add(backBtn);
        buttonPanel.add(registerBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void registerPatient(String firstName, String lastName, String email, String password,
                                String age, String dob, String sex, String contact,
                                String status, String address) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showError("First name, last name, email and password are required!");
            return;
        }

        try (Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO patients (first_name, last_name, email, password, age, dob, sex, contact, status, address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setInt(5, age.isEmpty() ? 0 : Integer.parseInt(age));
            stmt.setString(6, dob.isEmpty() ? null : dob);
            stmt.setString(7, sex.isEmpty() ? null : sex);
            stmt.setString(8, contact.isEmpty() ? null : contact);
            stmt.setString(9, status);
            stmt.setString(10, address.isEmpty() ? null : address);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            mainLayout.show(mainPanel, "Login");
        } catch (SQLException ex) {
            if (ex.getMessage().contains("Duplicate entry")) {
                showError("Email already registered!");
            } else {
                showError("Registration failed: " + ex.getMessage());
            }
        } catch (NumberFormatException ex) {
            showError("Please enter a valid age!");
        }
    }

    private JPanel createDashboardScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(createHeader("Main Menu"), BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 1, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        center.setBackground(Color.WHITE);

        JButton treatmentsBtn = new JButton("Choose Treatment");
        styleButton(treatmentsBtn);
        treatmentsBtn.addActionListener(e -> mainLayout.show(mainPanel, "Treatments"));

        JButton billingBtn = new JButton("Billing & Payment");
        styleButton(billingBtn);
        billingBtn.addActionListener(e -> {
            refreshBillingInfo();
            mainLayout.show(mainPanel, "Billing");
        });

        JButton logoutBtn = new JButton("Logout");
        styleButton(logoutBtn, new Color(255, 69, 0));
        logoutBtn.addActionListener(e -> {
            currentPatientId = -1;
            selectedTreatments.clear();
            selectedAppointmentDate = null;
            mainLayout.show(mainPanel, "Login");
        });

        center.add(treatmentsBtn);
        center.add(billingBtn);
        center.add(logoutBtn);

        panel.add(center, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createTreatmentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(createHeader("Choose Treatment"), BorderLayout.NORTH);

        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));
        checkboxPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        checkboxPanel.setBackground(Color.WHITE);

        String[][] treatments = {
            {"Preventive Care", "Dental Consultation", "Teeth Cleaning (Oral Prophylaxis)", "Fluoride Treatment", "Sealants (per tooth)"},
            {"Restorative Treatments", "Dental Fillings (Composite Resin)", "Root Canal Treatment", "Dental Crowns", "Dental Bridges"},
            {"Cosmetic Dentistry", "Teeth Whitening", "Porcelain Veneers", "Dental Bonding"},
            {"Orthodontics", "Braces", "Clear Aligners", "Retainers"}
        };

        List<JCheckBox> treatmentCheckboxes = new ArrayList<>();

        for (String[] category : treatments) {
            JLabel categoryLabel = new JLabel(category[0]);
            categoryLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            categoryLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
            checkboxPanel.add(categoryLabel);

            for (int i = 1; i < category.length; i++) {
                JCheckBox cb = new JCheckBox(category[i]);
                cb.setFont(new Font("SansSerif", Font.PLAIN, 14));
                cb.setBackground(Color.WHITE);
                checkboxPanel.add(cb);
                treatmentCheckboxes.add(cb);
            }
        }

        panel.add(new JScrollPane(checkboxPanel), BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Dashboard");
        styleButton(backButton);
        backButton.addActionListener(e -> mainLayout.show(mainPanel, "Dashboard"));

        JButton nextButton = new JButton("Next");
        styleButton(nextButton);
        nextButton.addActionListener(e -> {
            selectedTreatments.clear();
            for (JCheckBox cb : treatmentCheckboxes) {
                if (cb.isSelected()) {
                    selectedTreatments.add(cb.getText());
                }
            }
            mainLayout.show(mainPanel, "Calendar");
        });

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(backButton);
        bottom.add(nextButton);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createAppointmentCalendarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(createHeader("Choose Appointment Date"), BorderLayout.NORTH);

        JPanel calendarPanel = new JPanel();
        calendarPanel.setBackground(Color.WHITE);
        calendarPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        JCalendar jCalendar = new JCalendar();
        jCalendar.setWeekOfYearVisible(false);
        jCalendar.setPreferredSize(new Dimension(500, 350));
        calendarPanel.add(jCalendar);
        panel.add(calendarPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        styleButton(backButton);
        backButton.addActionListener(e -> mainLayout.show(mainPanel, "Treatments"));

        JButton confirmButton = new JButton("Confirm Appointment");
        styleButton(confirmButton);
        confirmButton.addActionListener(e -> {
            selectedAppointmentDate = jCalendar.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            JOptionPane.showMessageDialog(this, "Appointment set for: " + sdf.format(selectedAppointmentDate));
            mainLayout.show(mainPanel, "Dashboard");
        });

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(backButton);
        bottom.add(confirmButton);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBillingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(createHeader("Billing & Payment"), BorderLayout.NORTH);

        billingInfo = new JTextArea();
        billingInfo.setEditable(false);
        billingInfo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(new JScrollPane(billingInfo), BorderLayout.CENTER);

        JCheckBox paymentCheckBox = new JCheckBox("Payment Completed");
        paymentCheckBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        paymentCheckBox.setBackground(Color.WHITE);

        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paymentPanel.setBackground(Color.WHITE);
        paymentPanel.add(paymentCheckBox);
        panel.add(paymentPanel, BorderLayout.SOUTH);

        JButton backButton = new JButton("Back to Dashboard");
        styleButton(backButton);
        backButton.addActionListener(e -> mainLayout.show(mainPanel, "Dashboard"));

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(backButton);
        panel.add(bottom, BorderLayout.PAGE_END);

        return panel;
    }

    private void refreshBillingInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Billing Details\n");
        sb.append("=====================\n\n");

        if (selectedTreatments == null || selectedTreatments.isEmpty()) {
            sb.append("No treatments selected.\n");
        } else {
            sb.append("Selected Treatments:\n");
            for (String treatment : selectedTreatments) {
                sb.append("- ").append(treatment).append("\n");
            }
        }

        sb.append("\n");

        if (selectedAppointmentDate == null) {
            sb.append("Appointment Date: Not set\n");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sb.append("Appointment Date: ").append(sdf.format(selectedAppointmentDate)).append("\n");
        }

        if (billingInfo != null) {
            billingInfo.setText(sb.toString());
        }
    }

    private void styleButton(JButton button) {
        styleButton(button, new Color(0, 102, 204));
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DentalClinicUI();
        });
    }
}

