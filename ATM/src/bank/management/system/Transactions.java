package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawal,minStatement,pinChange,fastCash,balanceEnquiry,exit;
    String pinNumber;
     Transactions(String pinNumber){
         this.pinNumber = pinNumber;
         setLayout(null);
         ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i3 =new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);

         JLabel text = new JLabel("Please select your Transaction");
         text.setBounds(200,300,700,35);
         image.add(text);
         text.setForeground(Color.white);
         text.setFont(new Font("System",Font.BOLD,16));

         deposit =new JButton("Deposit");
         deposit.setBounds(170,415,150,30);
         deposit.addActionListener(this);
         image.add(deposit);

         withdrawal =new JButton("Cash Withdraw");
         withdrawal.setBounds(355,415,150,30);
         withdrawal.addActionListener(this);
         image.add(withdrawal);

         fastCash  =new JButton("Fast Cash");
         fastCash.setBounds(170,450,150,30);
         fastCash.addActionListener(this);
         image.add(fastCash);

         minStatement =new JButton("Mini Statement");
         minStatement.setBounds(355,450,150,30);
         minStatement.addActionListener(this);
         image.add(minStatement);

         pinChange  =new JButton("Pin Change");
         pinChange.setBounds(170,485,150,30);
         pinChange.addActionListener(this);
         image.add(pinChange);

         balanceEnquiry  =new JButton("Balance Enquiry");
         balanceEnquiry.setBounds(355,485,150,30);
         balanceEnquiry.addActionListener(this);
         image.add(balanceEnquiry);

         exit  =new JButton("Exit");
         exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
         image.add(exit);

         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);


     }
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == exit){
             System.exit(0);
         } else if (ae.getSource() == deposit) {
             setVisible(false);
             new Deposit(pinNumber).setVisible(true);
         } else if (ae.getSource() == withdrawal) {
             setVisible(false);
             new Withdrawal(pinNumber).setVisible(true);
         }

     }
    public static void main(String[] args) {
            new Transactions("");
    }
}
