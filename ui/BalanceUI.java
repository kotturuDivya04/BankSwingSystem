package ui;

import javax.swing.*;
import java.awt.*;
import service.BankService;
import model.Account;

public class BalanceUI extends JFrame {

    public BalanceUI(){

        setTitle("Check Balance");
        setSize(400,350);
        setLayout(new BorderLayout());

        JLabel title=new JLabel("Check Balance",JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setOpaque(true);
        title.setBackground(new Color(155,89,182));
        title.setForeground(Color.WHITE);

        add(title,BorderLayout.NORTH);

        JPanel panel=new JPanel(new GridLayout(2,2,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        panel.setBackground(new Color(245,235,255));

        JTextField accField=new JTextField();

        JButton btn=new JButton("Check");

        btn.setBackground(new Color(155,89,182));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,16));

        panel.add(new JLabel("Account Number"));
        panel.add(accField);

        panel.add(new JLabel(""));
        panel.add(btn);

        add(panel,BorderLayout.CENTER);

        btn.addActionListener(e->{

            int accNo=Integer.parseInt(accField.getText());

            Account a=BankService.findAccount(accNo);

            if(a!=null){

                JOptionPane.showMessageDialog(this,"Balance: "+a.getBalance());

            }else{

                JOptionPane.showMessageDialog(this,"Account Not Found");
            }

        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}