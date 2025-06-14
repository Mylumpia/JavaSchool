import javax.swing.*;
import java.awt.*;

public class BillingPanel extends JPanel {
    public BillingPanel(MainFrame mainFrame, PatientManager patientManager) {
        initializeUI(mainFrame, patientManager);
    }

    private void initializeUI(MainFrame mainFrame, PatientManager patientManager) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(UIUtils.createHeader("Billing & Payment"), BorderLayout.NORTH);

        JTextArea billingInfo = new JTextArea();
        billingInfo.setEditable(false);
        billingInfo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        billingInfo.setText("Billing details will appear here...\n");

        JCheckBox paymentCheckBox = new JCheckBox("Payment Completed");
        paymentCheckBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        paymentCheckBox.setBackground(Color.WHITE);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        content.add(new JScrollPane(billingInfo), BorderLayout.CENTER);

        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paymentPanel.setBackground(Color.WHITE);
        paymentPanel.add(paymentCheckBox);
        content.add(paymentPanel, BorderLayout.SOUTH);

        add(content, BorderLayout.CENTER);

        JButton backButton = UIUtils.createStyledButton("Back to Dashboard", new Color(0, 102, 204));
        backButton.addActionListener(e -> mainFrame.showPanel("Dashboard"));

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(backButton);
        add(bottom, BorderLayout.SOUTH);
    }
}