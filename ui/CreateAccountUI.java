package ui;

import javax.swing.*;
import java.awt.*;
import service.BankService;

public class CreateAccountUI extends JFrame {

    public CreateAccountUI(){

        setTitle("Create Account");
        setSize(400,400);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Create Account",JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setOpaque(true);
        title.setBackground(new Color(52,152,219));
        title.setForeground(Color.WHITE);

        add(title,BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4,2,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        panel.setBackground(new Color(235,245,255));

        JTextField accField=new JTextField();
        JTextField nameField=new JTextField();
        JTextField balField=new JTextField();

        JButton btn=new JButton("Create");

        btn.setBackground(new Color(52,152,219));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,16));

        panel.add(new JLabel("Account Number"));
        panel.add(accField);

        panel.add(new JLabel("Name"));
        panel.add(nameField);

        panel.add(new JLabel("Initial Balance"));
        panel.add(balField);

        panel.add(new JLabel(""));
        panel.add(btn);

        add(panel,BorderLayout.CENTER);

        btn.addActionListener(e->{

            int accNo=Integer.parseInt(accField.getText());
            String name=nameField.getText();
            double bal=Double.parseDouble(balField.getText());

            BankService.createAccount(accNo,name,bal);

            JOptionPane.showMessageDialog(this,"Account Created");
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}