// TreatmentPanel.java
import javax.swing.*;
import java.awt.*;

public class TreatmentPanel extends JPanel {
    public TreatmentPanel(MainFrame mainFrame) {
        initializeUI(mainFrame);
    }

    private void initializeUI(MainFrame mainFrame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(UIUtils.createHeader("Choose Treatment"), BorderLayout.NORTH);

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
            }
        }

        add(new JScrollPane(checkboxPanel), BorderLayout.CENTER);

        JButton backButton = UIUtils.createStyledButton("Back to Dashboard", new Color(0, 102, 204));
        backButton.addActionListener(e -> mainFrame.showPanel("Dashboard"));

        JButton nextButton = UIUtils.createStyledButton("Next", new Color(0, 102, 204));
        nextButton.addActionListener(e -> mainFrame.showPanel("Calendar"));

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(backButton);
        bottom.add(nextButton);
        add(bottom, BorderLayout.SOUTH);
    }
}