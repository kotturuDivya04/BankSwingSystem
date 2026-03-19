package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {

        setTitle("Bank Management System");
        setSize(900,500);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("BANK MANAGEMENT SYSTEM", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setOpaque(true);
        title.setBackground(new Color(40,60,120));
        title.setForeground(Color.WHITE);

        add(title,BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(2,2,30,30));
        panel.setBorder(BorderFactory.createEmptyBorder(60,80,60,80));
        panel.setBackground(new Color(230,240,255));

        JButton createBtn = new JButton("Create Account");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton balanceBtn = new JButton("Check Balance");

        style(createBtn,new Color(52,152,219));
        style(depositBtn,new Color(46,204,113));
        style(withdrawBtn,new Color(231,76,60));
        style(balanceBtn,new Color(155,89,182));

        panel.add(createBtn);
        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(balanceBtn);

        add(panel,BorderLayout.CENTER);

        createBtn.addActionListener(e-> new CreateAccountUI());
        depositBtn.addActionListener(e-> new DepositUI());
        withdrawBtn.addActionListener(e-> new WithdrawUI());
        balanceBtn.addActionListener(e-> new BalanceUI());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void style(JButton btn, Color color){
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,18));
        btn.setFocusPainted(false);
    }
}