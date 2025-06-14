// LoginPanel.java
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginPanel extends JPanel {
    private final MainFrame mainFrame;
    private final PatientManager patientManager;

    public LoginPanel(MainFrame mainFrame, PatientManager patientManager) {
        this.mainFrame = mainFrame;
        this.patientManager = patientManager;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));
        add(createHeader("Patient Login"), BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(40, 100, 20, 100));
        form.setBackground(new Color(240, 248, 255));

        JTextField emailField = new JTextField();
        
        JPasswordField passwordField = new JPasswordField();

        form.add(new JLabel("Email:"));
        form.add(emailField);
        form.add(new JLabel("Password:"));
        form.add(passwordField);

        JButton loginBtn = UIUtils.createStyledButton("Login", new Color(0, 102, 204));
        form.add(new JLabel());
        form.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (email.isEmpty() || password.isEmpty()) {
                UIUtils.showError(this, "Please enter both email and password");
                return;
            }

            try {
                if (patientManager.login(email, password)) {
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    mainFrame.showPanel("Dashboard");
                } else {
                    UIUtils.showError(this, "Invalid email or password");
                }
            } catch (SQLException ex) {
                UIUtils.showError(this, "Database error: " + ex.getMessage());
            }
        });

        add(form, BorderLayout.CENTER);

        JPanel footer = new JPanel();
        footer.setBackground(new Color(240, 248, 255));
        JButton signUpBtn = UIUtils.createStyledButton("Sign Up", new Color(34, 139, 34));
        signUpBtn.addActionListener(e -> mainFrame.showPanel("SignUp"));
        footer.add(signUpBtn);
        add(footer, BorderLayout.SOUTH);
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