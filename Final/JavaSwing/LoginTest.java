import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginTest {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Login Form");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);

        frame.setLayout(null);

        JLabel labelTitle = new JLabel("Welcome!");
        labelTitle.setBounds(130, 10, 150, 30);
        labelTitle.setFont(new Font("Bold", Font.BOLD, 25));
        frame.add(labelTitle);

        JLabel labelExtra = new JLabel("© 2025 Your School");
        labelExtra.setBounds(150, 210, 150, 30);
        labelExtra.setFont(new Font("smol", Font.ITALIC, 11));
        frame.add(labelExtra);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(50, 50, 150, 30);
        frame.add(labelUsername);

        JTextField textFieldUsername = new JTextField();
        textFieldUsername.setBounds(150, 50, 150, 30);
        frame.add(textFieldUsername);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(50, 100, 150, 30);
        frame.add(labelPassword);

        JPasswordField textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(150, 100, 150, 30);
        frame.add(textFieldPassword);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(90, 150, 100, 30);
        frame.add(buttonLogin);

        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(200, 150, 100, 30);
        frame.add(buttonCancel);


        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(buttonLogin, "Login Attepted for: " + textFieldUsername.getText(), "Message" , JOptionPane.INFORMATION_MESSAGE);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                textFieldUsername.setText("");
                textFieldPassword.setText("");
            }
        });

        frame.setVisible(true);
    } 
}
