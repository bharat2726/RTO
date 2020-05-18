
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class RTO extends JFrame implements ActionListener
{String strx2=null,strx1=null;int count1=0,flag=0;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JButton b,b1;
    RTO(String strx,String str11,int count,int f)
    {
       setContentPane(new JLabel(new ImageIcon("C:\\Users\\91788\\Desktop\\STUFF\\New folder\\Vehicle\\src\\4.jpeg")));
        //strx="CH01A0714";
        System.out.println(strx);
        System.out.println(str11);
        setVisible(true);
        //setLocationRelativeTo(null);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setLayout(null);
        ///setSize(1970, 1080);
        //getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Regional Transport Office");
        l1=new JLabel("Regional Transport Office");
        l1.setBounds(500, 100, 1000, 100);
        l1.setFont(new Font("Serif",Font.BOLD,80));
        l1.setForeground(Color.WHITE);
        t2=new JLabel();
        t2.setBounds(920, 250, 300, 50);
        t2.setFont(new Font("Serif",Font.BOLD,30));
        t2.setForeground(Color.WHITE);
        l2=new JLabel("Owner's Name:");
        l2.setBounds(600, 250, 300, 50);
        l2.setFont(new Font("Serif",Font.BOLD,30));
        l2.setForeground(Color.WHITE);
        t3=new JLabel();
        t3.setBounds(920, 350, 300, 50);
        t3.setFont(new Font("Serif",Font.BOLD,30));
        t3.setForeground(Color.WHITE);
        l3=new JLabel("Address:");
        l3.setBounds(600, 350, 300, 50);
        l3.setFont(new Font("Serif",Font.BOLD,30));
        l3.setForeground(Color.WHITE);
        t4=new JLabel();
        t4.setBounds(920, 400, 300, 50);
        t4.setFont(new Font("Serif",Font.BOLD,30));
        t4.setForeground(Color.WHITE);
        l4=new JLabel("Vehicle's Model:");
        l4.setBounds(600, 400, 300, 50);
        l4.setFont(new Font("Serif",Font.BOLD,30));
        l4.setForeground(Color.WHITE);
        
        t6=new JLabel();
        t6.setBounds(920, 450, 300, 50);
        t6.setFont(new Font("Serif",Font.BOLD,30));
        t6.setForeground(Color.WHITE);
        l6=new JLabel("Vehicle's Age:");
        l6.setBounds(600, 450, 300, 50);
        l6.setFont(new Font("Serif",Font.BOLD,30));
        l6.setForeground(Color.WHITE);
        t7=new JLabel();
        t7.setBounds(920, 500, 300, 50);
        t7.setFont(new Font("Serif",Font.BOLD,30));
        t7.setForeground(Color.WHITE);
        l7=new JLabel("Vehicle's Engine:");
        l7.setBounds(600, 500,300, 50);
        l7.setFont(new Font("Serif",Font.BOLD,30));
        l7.setForeground(Color.WHITE);
        t8=new JLabel();
        t8.setBounds(1120, 550, 300, 50);
        t8.setFont(new Font("Serif",Font.BOLD,30));
        t8.setForeground(Color.WHITE);
        l8=new JLabel("Is Vehicle's Pollution Check validated?:");
        l8.setBounds(600, 550, 700, 50);
        l8.setFont(new Font("Serif",Font.BOLD,30));
        l8.setForeground(Color.WHITE);
        t9=new JLabel();
        t9.setBounds(1120, 600, 300, 50);
        t9.setFont(new Font("Serif",Font.BOLD,30));
        t9.setForeground(Color.WHITE);
        l9=new JLabel("Does Vehicle need to upgrade to BS4?:");
        l9.setBounds(600, 600, 700, 50);
        l9.setFont(new Font("Serif",Font.BOLD,30));
        l9.setForeground(Color.WHITE);
        t10=new JLabel();
        t10.setBounds(920, 300, 300, 50);
        t10.setFont(new Font("Serif",Font.BOLD,30));
        t10.setForeground(Color.WHITE);
        l10=new JLabel("Vehicle's Number:");
        l10.setBounds(600, 300, 300, 50);
        l10.setFont(new Font("Serif",Font.BOLD,30));
        l10.setForeground(Color.WHITE);
        b=new JButton("Done");
        b.setBounds(650, 700, 150, 50);
        b1=new JButton("Show Pending");
        b1.setBounds(850, 700, 150, 50);
        
        add(l2);
        add(l1);
        add(l3);
        add(l4);
        //add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(t2);
        add(t3);
        add(t4);
        //add(t5);
        add(t6);
        add(t7);
        add(t8);
        add(t9);
        add(t10);
        add(b);
        add(b1);
        b.addActionListener(this);
        b1.addActionListener(this);
        count1=count;/////////////////////////////////////////////////////////////////////////////
         //System.out.println(count1+"Count");
        strx1=str11;
        strx2=strx;
        System.out.println(strx2);
        flag=f;
        try{
            String str1=null,strxx=null;
            int y=0,year=0,i=0;
            System.out.println("xx");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
            PreparedStatement ps = null;
            if(strx1.equals("CH"))
            {
                ps=con.prepareStatement("select * from chd where Vehicle_Number=?");
            }
            else if(strx1.equals("PB"))
            {
                ps=con.prepareStatement("select * from pb where Vehicle_Number=?");
            }
           else if(strx1.equals("HR"))
            {
                ps=con.prepareStatement("select * from hr where Vehicle_Number=?");
            }
            ps.setString(1, strx2);
            ResultSet rs=ps.executeQuery();
            System.out.println(rs+"**********");
            while(rs.next())
            {
                t2.setText(rs.getString(1));
                System.out.println(t2.getText()+"*");
                t3.setText(rs.getString(2));
                System.out.println(t3.getText()+"*");
                t4.setText(rs.getString(3));
                System.out.println(t4.getText()+"*");
                str1=rs.getString(5);
                y=Integer.parseInt(str1);
                for(i=y;i<2019;i++)
                {
                    System.out.println(i+"==i");
                    year=year+1;
                }
              //  strxx=String.valueOf(year);
                System.out.println(year+" 8888888==y");                
                System.out.println(str1+" 8888888==str1");                
              //  System.out.println(strxx+" 8888888==strxx");
                t6.setText(year+"");
                if(y<2014)
                    t7.setText("BS3");
                else
                    t7.setText("BS4");
                String s=null;
                s=rs.getString(7);
                System.out.println(s+"*");
                if(s.equals("Yes")){
                    t8.setText("Yes");}
                else{
                    t8.setText("No");}
                if(s.equals("Yes"))
                {
                    t9.setText("No");
                }
                else
                {
                    if(y<2014)
                        t9.setText("Yes");
                    else
                        t9.setText("No");
                }
                //t9.setText(rs.getString(00));
                t10.setText(rs.getString(4));
                System.out.println(t10.getText()+"*");
            }
        }
        catch(ClassNotFoundException | SQLException ee)
        {
            System.out.println(ee);
        }
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String strx=null,strxx=null;int c=0,ff=0;
                RTO r=new RTO(strx,strxx,c,ff);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b)
        {
            //int f=0;
            setVisible(false);
            int z=1;
            Vehiclenum v=new Vehiclenum(flag,z);
        }
        else
        {
           Pending p=new Pending();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
