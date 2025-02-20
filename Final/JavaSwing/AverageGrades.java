import javax.swing.*;
import java.awt.event.*;

public class AverageGrades {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Average of Three Grades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel label1 = new JLabel("Enter Grade 1:");
        label1.setBounds(50, 50, 150, 30);
        frame.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setBounds(150, 50, 150, 30);
        frame.add(textField1);

        JLabel label2 = new JLabel("Enter Grade 2:");
        label2.setBounds(50, 100, 150, 30);
        frame.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setBounds(150, 100, 150, 30);
        frame.add(textField2);

        JLabel label3 = new JLabel("Enter Grade 3:");
        label3.setBounds(50, 150, 150, 30);
        frame.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(150, 150, 150, 30);
        frame.add(textField3);

        JButton button = new JButton("Calculate Average");
        button.setBounds(150, 200, 150, 30);
        frame.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(50, 230, 300, 50);
        textArea.setEditable(false);
        frame.add(textArea);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double grade1 = Double.parseDouble(textField1.getText());
                    double grade2 = Double.parseDouble(textField2.getText());
                    double grade3 = Double.parseDouble(textField3.getText());
                    double average = (grade1 + grade2 + grade3) / 3;
                    textArea.setText("Average: " + average);
                }catch (NumberFormatException ex){
                    textArea.setText("Invalid input. Please enter valid grades.");
                }
            }
        });

        frame.setVisible(true);

    }
    
}
