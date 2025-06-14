
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentPanel extends JPanel {
    public AppointmentPanel(MainFrame mainFrame, PatientManager patientManager) {
        initializeUI(mainFrame, patientManager);
    }

    private void initializeUI(MainFrame mainFrame, PatientManager patientManager) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(UIUtils.createHeader("Choose Appointment Date"), BorderLayout.NORTH);

        JPanel calendarPanel = new JPanel();
        calendarPanel.setBackground(Color.WHITE);
        calendarPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(editor);
        dateSpinner.setFont(new Font("SansSerif", Font.PLAIN, 14));

        calendarPanel.add(new JLabel("Select Appointment Date:"));
        calendarPanel.add(dateSpinner);
        add(calendarPanel, BorderLayout.CENTER);

        JButton backButton = UIUtils.createStyledButton("Back", new Color(0, 102, 204));
        backButton.addActionListener(e -> mainFrame.showPanel("Treatments"));

        JButton confirmButton = UIUtils.createStyledButton("Confirm Appointment", new Color(0, 102, 204));
        confirmButton.addActionListener(e -> {
            Date selectedDate = (Date) dateSpinner.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            JOptionPane.showMessageDialog(this, "Appointment set for: " + sdf.format(selectedDate));
            mainFrame.showPanel("Dashboard");
        });

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(backButton);
        bottom.add(confirmButton);
        add(bottom, BorderLayout.SOUTH);
    }
}