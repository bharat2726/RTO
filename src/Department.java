
import java.awt.Color;
import java.awt.Font;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bharat
 */
public class Department extends JFrame implements ActionListener{
    int ff=0;
    JLabel l1;
    JButton b1,b2,b3,b4;
    Department()
    {
        setVisible(true);
        //setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bharat\\Documents\\NetBeansProjects\\vehicle\\src\\1.jpg")));
        //setContentPane(new JLabel(new ImageIcon(1.read(new File(C:\Users\Bharat\Documents\NetBeansProjects\vehicle\src)))));
        //setSize(1970, 1080); 
        getContentPane().setBackground(Color.DARK_GRAY);
        //setBackground(Color.DARK_GRAY)
        setTitle("DEPARTMENT");
        l1=new JLabel("DEPARTMENT");
        l1.setFont(new Font("Serif",Font.BOLD,70));
        l1.setBounds(700, 200, 550, 50);
        l1.setForeground(Color.BLACK);
        b1=new JButton("RTO");
        b1.setBounds(350, 450, 300, 80);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Serif",Font.BOLD,28));
        b2=new JButton("Toll");
        b2.setBounds(700, 450, 300, 80);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Serif",Font.BOLD,28));
        b3=new JButton("Pollution Check");
        b3.setBounds(1050, 450, 300, 80);
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Serif",Font.BOLD,28));
        b4=new JButton("Police");
        b4.setBounds(1400, 450, 300, 80);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Serif",Font.BOLD,28));
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    public static void main(String ar[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int ff=0;
                Department d=new Department();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            setVisible(false);
            System.out.println("RTO");
            ff=1;
            Login l=new Login(ff);
        }
        if(e.getSource()==b2)
        {
            setVisible(false);
            System.out.println("Toll");
            ff=2;
            Login l=new Login(ff);
        }
        if(e.getSource()==b3)
        {
            setVisible(false);
            System.out.println("Pollution");
            ff=3;
            Login l=new Login(ff);
        }
        if(e.getSource()==b4)
        {
            setVisible(false);
            System.out.println("Police");
            ff=4;
            Login l=new Login(ff);
        }
        
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

