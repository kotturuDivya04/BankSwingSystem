package ui;

import javax.swing.*;
import java.awt.*;
import service.BankService;
import model.Account;

public class DepositUI extends JFrame {

    public DepositUI(){

        setTitle("Deposit Money");
        setSize(400,400);
        setLayout(new BorderLayout());

        // Header
        JLabel title = new JLabel("Deposit Money", JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setOpaque(true);
        title.setBackground(new Color(46,204,113));
        title.setForeground(Color.WHITE);

        add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3,2,15,15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        formPanel.setBackground(new Color(230,255,240));

        JTextField accField = new JTextField();
        JTextField amtField = new JTextField();

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBackground(new Color(46,204,113));
        depositBtn.setForeground(Color.WHITE);
        depositBtn.setFont(new Font("Arial",Font.BOLD,16));

        formPanel.add(new JLabel("Account Number"));
        formPanel.add(accField);

        formPanel.add(new JLabel("Amount"));
        formPanel.add(amtField);

        formPanel.add(new JLabel(""));
        formPanel.add(depositBtn);

        add(formPanel,BorderLayout.CENTER);

        depositBtn.addActionListener(e -> {

            int accNo = Integer.parseInt(accField.getText());
            double amt = Double.parseDouble(amtField.getText());

            Account a = BankService.findAccount(accNo);

            if(a != null){
                a.deposit(amt);
                JOptionPane.showMessageDialog(this,"Deposit Successful");
            } else {
                JOptionPane.showMessageDialog(this,"Account Not Found");
            }

        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}