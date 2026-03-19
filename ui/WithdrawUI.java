package ui;

import javax.swing.*;
import java.awt.*;
import service.BankService;
import model.Account;

public class WithdrawUI extends JFrame {

    public WithdrawUI(){

        setTitle("Withdraw Money");
        setSize(400,400);
        setLayout(new BorderLayout());

        JLabel title=new JLabel("Withdraw Money",JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setOpaque(true);
        title.setBackground(new Color(231,76,60));
        title.setForeground(Color.WHITE);

        add(title,BorderLayout.NORTH);

        JPanel panel=new JPanel(new GridLayout(3,2,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        panel.setBackground(new Color(255,235,235));

        JTextField accField=new JTextField();
        JTextField amtField=new JTextField();

        JButton btn=new JButton("Withdraw");

        btn.setBackground(new Color(231,76,60));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,16));

        panel.add(new JLabel("Account Number"));
        panel.add(accField);

        panel.add(new JLabel("Amount"));
        panel.add(amtField);

        panel.add(new JLabel(""));
        panel.add(btn);

        add(panel,BorderLayout.CENTER);

        btn.addActionListener(e->{

            int accNo=Integer.parseInt(accField.getText());
            double amt=Double.parseDouble(amtField.getText());

            Account a=BankService.findAccount(accNo);

            if(a!=null){

                if(a.withdraw(amt))
                    JOptionPane.showMessageDialog(this,"Withdraw Successful");
                else
                    JOptionPane.showMessageDialog(this,"Insufficient Balance");

            }else{

                JOptionPane.showMessageDialog(this,"Account Not Found");
            }

        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}