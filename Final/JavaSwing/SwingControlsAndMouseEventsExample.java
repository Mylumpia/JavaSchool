import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingControlsAndMouseEventsExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Controls and Mouse Events");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("This is a Jlabel");
        frame.add(label);

        JTextField textField = new JTextField(20);
        frame.add(textField);

        JTextArea textArea = new JTextArea(5,20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        JButton button = new JButton("Click Me");
        frame.add(button);

        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        frame.add(comboBox);


        JCheckBox checkBox = new JCheckBox("Accept Terms and Conditions");
        frame.add(checkBox);

        JRadioButton radioButton1 = new JRadioButton("Option 1");   
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        frame.add(radioButton1);
        frame.add(radioButton2);

        String[] listData = {"List Item 1", "List Item 2", "List Item 3"};
        JList<String> list = new JList<>(listData);
        frame.add(new JScrollPane(list));

        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                textArea.append("Button was clicked!\n");
            }
            
            });

            label.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                label.setText("Mouse Entered Jlabel");
            }    

            public void mouseExited(MouseEvent e){
                label.setText("This is a JLabel");
            }
            
        });

        textArea.addMouseMotionListener (new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e){
                textArea.setText("Mouse moved inside JtextArea!");
            }
        });

        comboBox.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                textArea.append("ComboBox item clicked: " + comboBox.getSelectedItem() + "\n");
            }
        });

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selectedItem = (String) comboBox.getSelectedItem();
                textArea.append("ComboBox selected: " + selectedItem + "\n");
            }
        });

        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (checkBox.isSelected()){
                    textArea.append("Checkbox is selected.\n");
                }else{
                    textArea.append("Checkbox is not Selected. \n");
                }
            }
        });

        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (radioButton1.isSelected()){
                    textArea.append("Option 1 selected. \n");
                }
            }
        });

        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (radioButton2.isSelected()){
                    textArea.append("Option 2 selected.\n");
                }
            }
        });

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
                String selectedValue = list.getSelectedValue();
                textArea.append("Jlist selected: " + selectedValue + "\n");
            }

        });

        frame.setVisible(true);
    }
}
