import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    public DashboardPanel(MainFrame mainFrame) {
        initializeUI(mainFrame);
    }

    private void initializeUI(MainFrame mainFrame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(UIUtils.createHeader("Main Menu"), BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 1, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        center.setBackground(Color.WHITE);

        // Add menu buttons
        JButton treatmentsBtn = UIUtils.createStyledButton("Choose Treatment", new Color(0, 102, 204));
        treatmentsBtn.addActionListener(e -> mainFrame.showPanel("Treatments"));
        
        JButton billingBtn = UIUtils.createStyledButton("Billing & Payment", new Color(0, 102, 204));
        billingBtn.addActionListener(e -> mainFrame.showPanel("Billing"));
        
        JButton logoutBtn = UIUtils.createStyledButton("Logout", new Color(255, 69, 0));
        logoutBtn.addActionListener(e -> {
            mainFrame.showPanel("Login");
        });

        center.add(treatmentsBtn);
        center.add(billingBtn);
        center.add(logoutBtn);

        add(center, BorderLayout.CENTER);
    }
}