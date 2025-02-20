import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;


public class BasicSwingExample {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Basic Swing Program with Scanner");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);

        frame.setLayout(null);

        JLabel label = new JLabel("Enter your name");
        label.setBounds(50, 50, 150, 30);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(150, 50, 150, 30);
        frame.add(textField);

        JButton button = new JButton("Submit");
        button.setBounds(150, 100, 100, 30);
        frame.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(50, 150, 300, 100);
        textArea.setEditable(false);
        frame.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                String name = textField.getText();

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your age:");
                int age = scanner.nextInt();

                String message = "Hello " + name + "! Your are " + age + " years old.";

                textArea.setText(message);
                scanner.close();
            }
        });

        frame.setVisible(true);
    }
}