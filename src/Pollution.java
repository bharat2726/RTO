
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bharat
 */
public class Pollution extends JFrame implements ActionListener
{
    int f=0;
    String sss=null;
    JLabel l1,l2,l3;
    JComboBox cb1;
    JRadioButton b1,b2;
    ButtonGroup bg;
    JButton b,bb,bbb;
    Pollution(int ff,String s)
    {
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("POLLUTION CHECK");
        setVisible(true);
setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);        
//setSize(1970, 1080);
        //setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bharat\\Documents\\NetBeansProjects\\Vehicle\\src\\6.jpg")));
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bharat\\Documents\\NetBeansProjects\\Vehicle\\src\\6.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLayout(null);
        l1=new JLabel("POLLUTION CHECK");
        l1.setFont(new Font("Serif",Font.BOLD,80));
        l1.setBounds(600, 100, 1000, 80);
        l1.setForeground(Color.YELLOW);
        l2=new JLabel("Enter Pollution Check Month:");
        l2.setFont(new Font("Serif",Font.BOLD,40));
        l2.setBounds(700, 300, 550, 40);
        l2.setForeground(Color.WHITE);
        cb1=new JComboBox();
        cb1.addItem("Select..");
        cb1.addItem("01");
        cb1.addItem("02");
        cb1.addItem("03");
        cb1.addItem("04");
        cb1.addItem("05");
        cb1.addItem("06");
        cb1.addItem("07");
        cb1.addItem("08");
        cb1.addItem("09");
        cb1.addItem("10");
        cb1.addItem("11");
        cb1.addItem("12");   
        cb1.setForeground(Color.WHITE);
        cb1.setFont(new Font("Serif",Font.BOLD,30));
        cb1.setBounds(1300, 300, 150, 40);
        cb1.setBackground(Color.DARK_GRAY);
        l3=new JLabel("Pollution Check Done? :");
        l3.setFont(new Font("Serif",Font.BOLD,40));
        l3.setBounds(700, 380, 450, 40);
        l3.setForeground(Color.BLACK);
        b1=new JRadioButton("Yes");
        b1.setFont(new Font("Serif",Font.BOLD,40));
        b1.setBounds(1200, 380, 150, 40);
        b1.setForeground(Color.WHITE);
        b1.setSelected(false);
        b1.setBackground(Color.DARK_GRAY);
        b2=new JRadioButton("No");
        b2.setFont(new Font("Serif",Font.BOLD,40));
        b2.setBounds(1400, 380, 150, 40);
        b2.setForeground(Color.WHITE);
        b2.setSelected(false);
        b2.setBackground(Color.DARK_GRAY);
        bg=new ButtonGroup();
        b= new JButton("Submit");
        b.setBounds(800, 550, 200, 50);
        bb=new JButton("Back");
        bb.setBounds(1050, 550, 200, 50);
        bbb=new JButton("Logout");
        bbb.setBounds(950, 900, 100, 40);
        add(l1);
        add(l2);
        add(cb1);
        add(l3);
        bg.add(b1);
        bg.add(b2);
        add(b1);
        add(b2);
        add(b);
        add(bb);
        b.addActionListener(this);
        bb.addActionListener(this);
        bbb.addActionListener(this);
        if(ff==1)
            f=1;
        else if(ff==2)
            f=2;
        else if(ff==3)
            f=3;
        sss=s;
        add(bbb);
    }
    public static void main(String ar[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int f = 0;
                String ss=null;
                Pollution p=new Pollution(f,ss);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==bb)
        {
            int ffff=0,z=0;
            setVisible(false);
            Vehiclenum vv=new Vehiclenum(ffff,z);
        }
        else if(e.getSource()==b)
        {
            String str1=null,str2=null;
            if(cb1.getSelectedIndex()==1)
                str1="01";
            else if(cb1.getSelectedIndex()==1)
                str1="01";
            else if(cb1.getSelectedIndex()==2)
                str1="02";
            else if(cb1.getSelectedIndex()==3)
                str1="03";
            else if(cb1.getSelectedIndex()==4)
                str1="04";
            else if(cb1.getSelectedIndex()==5)
                str1="05";
            else if(cb1.getSelectedIndex()==6)
                str1="06";
            else if(cb1.getSelectedIndex()==7)
                str1="07";
            else if(cb1.getSelectedIndex()==8)
                str1="08";
            else if(cb1.getSelectedIndex()==9)
                str1="09";
            else if(cb1.getSelectedIndex()==10)
                str1="10";
            else if(cb1.getSelectedIndex()==11)
                str1="11";
            else if(cb1.getSelectedIndex()==12)
                str1="12";
            if(b1.isSelected()==true)
                str2="Yes";
            else if(b2.isSelected()==true)
                str2="No";
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
                Statement st=con.createStatement();
                PreparedStatement ps;
                if(f==1)
                {
                    /*ps=con.prepareStatement("insert into CHD(Pollution,PC_Month) values('"+str2+"','"+str1+"') where Vehicle_Number=?");
                    ps.setString(1, sss);*/
                    String q="update chd set Pollution='"+str2+"',PC_Month='"+str1+"' where Vehicle_Number='"+sss+"'";
                    int x;
                    x=st.executeUpdate(q);//execute created statement
                    if(x>0)
                    {
                        System.out.println("Inserted");
                        int ffff=0,z=0;
            setVisible(false);
            Vehiclenum vv=new Vehiclenum(ffff,z);
                        
                    }
                    else
                    {
                        System.out.println("Not Inserted");
                    }
                }
                else if(f==2)
                {
                    String q="update pb set Pollution='"+str2+"',PC_Month='"+str1+"' where Vehicle_Number='"+sss+"'";
                    int x;
                    x=st.executeUpdate(q);//execute created statement
                    if(x>0)
                    {
                        System.out.println("Inserted");
                        int ffff=0,z=0;
            setVisible(false);
            Vehiclenum vv=new Vehiclenum(ffff,z);
                    }
                    else
                    {
                        System.out.println("Not Inserted");
                    }
                }
                else if(f==3)
                {
                    String q="update hr set Pollution='"+str2+"',PC_Month='"+str1+"' where Vehicle_Number='"+sss+"'";
                    int x;
                    x=st.executeUpdate(q);//execute created statement
                    if(x>0)
                    {
                        System.out.println("Inserted");
                        int ffff=0,z=0;
            setVisible(false);
            Vehiclenum vv=new Vehiclenum(ffff,z);
                    }
                    else
                    {
                        System.out.println("Not Inserted");
                    }
                } 
            }
            catch(SQLException ee)
            {
                System.out.println(ee);
            }
            catch(Exception eee)
            {
                System.out.println(eee);
            }
        }
        else
        {
            setVisible(false);
            int fff=0;
            Login ll=new Login(fff);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
