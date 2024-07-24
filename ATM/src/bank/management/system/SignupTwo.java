package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {
    String formno;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,income,education;

    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details. ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,40);
        add(additionalDetails);

        JLabel re = new JLabel("Religion: ");
        re.setFont(new Font("Raleway",Font.BOLD,20));
        re.setBounds(100,140,100,30);
        add(re);

        String valReligion[] =  {"Hindu","Muslim","Sikh","Christian","Other"};
        religion= new  JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        add(religion);


        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        cat.setBackground(Color.white);
        add(cat);

        String valCategory []={"General","OBC","SC","ST","Other"};
        category= new  JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        add(category);


        JLabel inc = new JLabel("Income: ");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,240,200,30);
        add(inc);

        String incomeCategory []={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income= new  JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);

        JLabel edu = new JLabel("Educational ");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);

        JLabel qua = new JLabel("Qualification: ");
        qua.setFont(new Font("Raleway",Font.BOLD,20));
        qua.setBounds(100,315,200,30);
        add(qua);

        String educationalValues []={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        education= new  JComboBox(incomeCategory);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);

        JLabel occ = new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,390,200,30);
        add(occ);

        String occupationalValues []={"Salaried","Self-Employeed","Business","Student","Retired"};
        occupation= new  JComboBox(occupationalValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);


        JLabel pN = new JLabel("PAN Number: ");
        pN.setFont(new Font("Raleway",Font.BOLD,20));
        pN.setBounds(100,440,200,30);
        add(pN);

        pan = new JTextField();
        pan.setBounds(300,440,400,30);
        pan.setFont(new Font("Arial",Font.BOLD,14));
        add(pan);

        JLabel aN = new JLabel("Aadhar Number: ");
        aN.setFont(new Font("Raleway",Font.BOLD,20));
        aN.setBounds(100,490,200,30);
        add(aN);

        aadhar = new JTextField();
        aadhar.setBounds(300,490,400,30);
        aadhar.setFont(new Font("Arial",Font.BOLD,14));
        add(aadhar);

        JLabel sC = new JLabel("Senior Citizen: ");
        sC.setFont(new Font("Raleway",Font.BOLD,20));
        sC.setBounds(100,540,200,30);
        add(sC);

        syes =new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.yellow);
        add(syes);

        sno =new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.yellow);
        add(sno);


        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        JLabel eA = new JLabel("Existing Account: ");
        eA.setFont(new Font("Raleway",Font.BOLD,20));
        eA.setBounds(100,590,200,30);
        add(eA);

        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.yellow);
        add(eyes);

        eno =new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.yellow);
        add(eno);


        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);


        JButton next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.yellow);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else {
            seniorcitizen="No";
        }

        String existingaccount=null;
        if (eyes.isSelected()){
            existingaccount="Yes";
        }else {
            existingaccount = "No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();

        try {

                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

        }catch (Exception e){
            System.out.println(e);
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
