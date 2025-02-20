import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArrayNumberSum {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Array Input Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter intergers (comma-separated");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Calculate Sum");
        JTextArea textArea = new JTextArea(10,30);
        textArea.setEditable(false);   

        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(scrollPane);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String input = textField.getText();
                String[] inputArray = input.split(",");
                int[] numbers = new int[inputArray.length];
                int sum = 0;

                try{
                    for (int i = 0; i < inputArray.length; i++){
                        numbers[i] = Integer.parseInt(inputArray[i].trim());
                        sum += numbers[i];
                    }
                    textArea.setText("Entered Array: ");
                    for (int num : numbers){
                        textArea.append(num + " ");
                    }
                    textArea.append("\nSum: " + sum);
                }catch (NumberFormatException ex){
                    textArea.setText("Please enter valid integers.");
                }
            }
        });

        frame.setVisible(true);


    }
}
