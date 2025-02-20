import javax.swing.*;
import java.awt.event.*;

public class BasicSwingVersionTwo {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Basic Swing Program with Name and Age");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);
        frame.setLayout(null);


        JLabel labelName = new JLabel("Enter your name:");
        labelName.setBounds(50, 50, 150, 30);
        frame.add(labelName);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(150, 50, 150, 30);
        frame.add(textFieldName);

        JLabel labelAge = new JLabel("Enter your age:");
        labelAge.setBounds(50, 100, 150, 30);
        frame.add(labelAge);

        JTextField textFieldAge = new JTextField();
        textFieldAge.setBounds(150, 100, 150, 30);
        frame.add(textFieldAge);

        JButton button = new JButton("Submit");
        button.setBounds(150, 150, 100, 30);
        frame.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(50, 200, 300, 50);
        textArea.setEditable(false);
        frame.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = textFieldName.getText();
                String ageText = textFieldAge.getText();

                int age = 0;
                try{
                    age = Integer.parseInt(ageText);
                }catch (NumberFormatException ex){
                    textArea.setText("Invalid age input. Please enter a valid number.");
                    return;
                }

                String message = "Hello, " + name + "! You are " + age + " years old.";
                textArea.setText(message);

            }
        });

        frame.setVisible(true);
    }
}
