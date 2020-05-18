
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bharat
 */
public class Vehiclenum extends JFrame implements ActionListener
{
    int flag=0,count=0,zz=0;
    JTextField tf,tf1,tf2,tf3;
    JButton b,b1,b2;
    JLabel l;
    Vehiclenum(int f,int z)
    {
        setVisible(true);
        setLayout(null);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);        
//setSize(1970, 1080);
setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bharat\\Documents\\NetBeansProjects\\Vehicle\\src\\3.jpg")));
        setTitle("Vehicle Number");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        l=new JLabel("VEHICLE NUMBER");
        l.setBounds(600, 200, 1000, 80);
        l.setFont(new Font("Serif",Font.CENTER_BASELINE,80));
        l.setForeground(Color.BLACK);
        //Icon icon = null;
        //l.setIcon(icon);
        tf=new JTextField();
        tf.setFont(new Font("Serif",Font.BOLD,50));
        tf.setBounds(700, 450, 100, 80);
        tf1=new JTextField();
        tf1.setFont(new Font("Serif",Font.BOLD,50));
        tf1.setBounds(820, 450, 80, 80);
        tf2=new JTextField();
        tf2.setFont(new Font("Serif",Font.BOLD,50));
        tf2.setBounds(920, 450, 80, 80);
        tf3=new JTextField();
        tf3.setFont(new Font("Serif",Font.BOLD,50));
        tf3.setBounds(1020, 450, 120, 80);
        b=new JButton("SEARCH");
        b.setBounds(820, 600, 200, 80);
        b.setFont(new Font("Serif",Font.BOLD,25));
        b1=new JButton("Logout");
        b1.setBounds(810, 900, 100, 50);
        b1.setFont(new Font("Serif",Font.BOLD,20));
        b2=new JButton("Reset");
        b2.setBounds(950, 900,100, 50);
        b2.setFont(new Font("Serif",Font.BOLD,20));
        add(l);
        add(tf);
        add(tf1);
        add(tf2);
        add(tf3);
        add(b);
        add(b1);
        b1.addActionListener(this);
        b.addActionListener(this);
        add(b2);
        b2.addActionListener(this);
        zz=z;
        flag=f;
        
    }
    public static void main(String ar[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int f = 0,zzz=0;
                Vehiclenum v=new Vehiclenum(f,zzz);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String str1=null,str2=null,str3=null,strx=null,str4=null;
        str1=tf.getText();
        str2=tf1.getText();
        str3=tf2.getText();
        str4=tf3.getText();
        strx=str1+str2+str3+str4;
        if(e.getSource()==b2)
        {
            System.out.println(strx);
            tf.setText("");
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        }
        else if(e.getSource()==b1)
        {
            int ff=0;
            setVisible(false);
            Login l=new Login(ff);
        }
        else if(e.getSource()==b)
        {
            if(str1.equals("CH"))
            {
                boolean status=false;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
                    PreparedStatement ps=con.prepareStatement("select * from chd where Vehicle_Number=?");//prepare a statement
                    String name=null;
                    ps.setString(1, strx);
                    ResultSet rs=ps.executeQuery();
                    status=rs.next();
                    Vector v=new Vector();
                    while(rs.next())
                    {
                        String x=rs.getString(1);
                        System.out.println(x);
                        v.add(x);
                    }
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
                if(status)
                {
                    
                    JOptionPane.showMessageDialog(this, "Resgistered","heading",JOptionPane.CLOSED_OPTION );
                    tf.setText("");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    System.out.println(flag);
                    if(flag==1)
                    {
                        int res=JOptionPane.showConfirmDialog(this, "View Information?","heading",JOptionPane.YES_NO_OPTION);
                        setVisible(false);
                        if(res==JOptionPane.YES_OPTION)
                        {
                            System.out.println(strx);
                            RTO r=new RTO(strx,str1,count,flag);
                        }
                        
                    }
                    else if(flag==2)
                    {
                        System.out.println("`````9999");
                        int res=JOptionPane.showConfirmDialog(this, "Do you want to continue?","heading",JOptionPane.YES_NO_OPTION);
                        if(res==JOptionPane.YES_NO_OPTION)
                        {
                            System.out.println(strx);
                            int f = 2,z=0;
                            Vehiclenum v=new Vehiclenum(f,z);
                        }
                    }
                    else if(flag==3)
                    {
                        int fff=1;
                        String s=strx;
                       Pollution pp=new Pollution(fff,s);
                        
                    }
                    if(flag==4)
                    {
                       Police p=new Police(strx,str1,flag);
                    }
                }
                else
                {
                    
                    JOptionPane.showMessageDialog(this, "Not Resgistered","heading",JOptionPane.CLOSED_OPTION );
                    if(zz==1){
                        int response=JOptionPane.showConfirmDialog(this, "Do you want to Register?", "heading ", JOptionPane.YES_NO_OPTION);
                    setVisible(false);
                    if(response==JOptionPane.YES_NO_OPTION)
                    {
                        Registration r=new Registration();
                
                    }
                    else
                    {
                        setVisible(false);
                    }}
                    else{
                    JOptionPane.showMessageDialog(this, "Go to RTO office and get Registrerd","heading",JOptionPane.CLOSED_OPTION);
                    count++;
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
                        Statement st=con.createStatement();
                        String q="insert into temp(VN) values('"+strx+"')";
                        int x;
                        x=st.executeUpdate(q);//execute created statement
                         if(x>0)
                        {
                            System.out.println("Inserted");
                        }
                        else
                        {
                            System.out.println("Not Inserted");
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
                    Vehiclenum v=new Vehiclenum(flag,zz);
                    }
                }
            }
            else if(str1.equals("PB"))
            {
                boolean status=false;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
                    PreparedStatement ps=con.prepareStatement("select * from pb where Vehicle_Number=?");//prepare a statement
                    String name=null;
                    ps.setString(1, strx);
                    ResultSet rs=ps.executeQuery();
                    status=rs.next();
                    Vector v=new Vector();
                    while(rs.next())
                    {
                    String x=rs.getString(1);
                    System.out.println(x);
                    v.add(x);
                    }
                    //System.out.println(rs.getNString("password"));
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
                if(status)
                {
                    
                    System.out.println("```````8`");
                    
                    JOptionPane.showMessageDialog(this, "Resgistered","heading",JOptionPane.CLOSED_OPTION );
                    tf.setText("");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    System.out.println(flag);
                    if(flag==1)
                    {
                        int res=JOptionPane.showConfirmDialog(this, "View Information?","heading",JOptionPane.YES_NO_OPTION);
                        setVisible(false);
                        if(res==JOptionPane.YES_OPTION)
                        {
                            System.out.println(strx);
                            RTO r=new RTO(strx,str1,count,flag);
                        }
                     }
                    else if(flag==2)
                    {
                        System.out.println("````````");
                        int res=JOptionPane.showConfirmDialog(this, "Do you want to continue?","heading",JOptionPane.YES_NO_OPTION);
                        if(res==JOptionPane.YES_OPTION)
                        {
                            System.out.println(strx);
                            int f=2;
                            Vehiclenum v=new Vehiclenum(f,zz);
                        }
                    }
                    if(flag==3)
                    {
                       int fff=2;
                       String s=strx;
                       Pollution pp=new Pollution(fff,s);
                        
                    }
                    if(flag==4)
                    {
                        Police p=new Police(strx,str1,flag);
                    }
                }
                else
                {
                    
                    JOptionPane.showMessageDialog(this, "Not Resgistered","heading",JOptionPane.CLOSED_OPTION );
                    if(zz==1){
                        int response=JOptionPane.showConfirmDialog(this, "Do you want to Register?", "heading ", JOptionPane.YES_NO_OPTION);
                    setVisible(false);
                    if(response==JOptionPane.YES_NO_OPTION)
                    {
                        Registration r=new Registration();
                
                    }
                    else
                    {
                        setVisible(false);
                    }}
                    else{
                    JOptionPane.showMessageDialog(this, "Go to RTO office and get Registrerd","heading",JOptionPane.CLOSED_OPTION);
                    count++;
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
                        Statement st=con.createStatement();
                        String q="insert into temp(VN) values('"+strx+"')";
                        int x;
                        x=st.executeUpdate(q);//execute created statement
                         if(x>0)
                        {
                            System.out.println("Inserted");
                        }
                        else
                        {
                            System.out.println("Not Inserted");
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
                    Vehiclenum v=new Vehiclenum(flag,zz);
                    }
                }
            }
            else if(str1.equals("HR"))
            {
                boolean status = false;
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
                    PreparedStatement ps=con.prepareStatement("select * from hr where Vehicle_Number=?");//prepare a statement
                    String name=null;
                    ps.setString(1, strx);
                    ResultSet rs=ps.executeQuery();
                    status=rs.next();
                    Vector v=new Vector();
                    while(rs.next())
                    {
                        String x=rs.getString(1);
                        System.out.println(x);
                        v.add(x);
                    }
                    //System.out.println(rs.getNString("password"));
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
                if(status)
                {
                    
                    JOptionPane.showMessageDialog(this, "Resgistered","heading",JOptionPane.CLOSED_OPTION );
                    tf.setText("");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    System.out.println(flag);
                    if(flag==1)
                    {
                        int res=JOptionPane.showConfirmDialog(this, "View Information?","heading",JOptionPane.YES_NO_OPTION);
                        setVisible(false);
                        if(res==JOptionPane.YES_OPTION)
                        {
                            System.out.println(strx);
                            RTO r=new RTO(strx,str1,count,flag);
                        }
                     }
                    if(flag==2){
                        int res=JOptionPane.showConfirmDialog(this, "Do you want to continue?","heading",JOptionPane.YES_NO_OPTION);
                        if(res==JOptionPane.YES_OPTION)
                        {
                            System.out.println(strx);
                            int f = 2;
                            Vehiclenum v=new Vehiclenum(f,zz);
                        }
                    }
                    if(flag==3)
                    {
                       int fff=3;
                       String s=strx;
                       Pollution pp=new Pollution(fff,s);
                        
                    }
                    if(flag==4)
                    {
                        Police p=new Police(strx,str1,flag);
                    }
                }
                else
                {
                    
                    JOptionPane.showMessageDialog(this, "Not Resgistered","heading",JOptionPane.CLOSED_OPTION );
                    
                    if(zz==1){
                        int response=JOptionPane.showConfirmDialog(this, "Do you want to Register?", "heading ", JOptionPane.YES_NO_OPTION);
                    setVisible(false);
                    if(response==JOptionPane.YES_NO_OPTION)
                    {
                        Registration r=new Registration();
                
                    }
                    else
                    {
                        setVisible(false);
                    }}
                    else{
                    JOptionPane.showMessageDialog(this, "Go to RTO office and get Registrerd","heading",JOptionPane.CLOSED_OPTION);
                    count++;
                    //strx
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
                        Statement st=con.createStatement();
                        String q="insert into temp(VN) values('"+strx+"')";
                        int x;
                        x=st.executeUpdate(q);//execute created statement
                         if(x>0)
                        {
                            System.out.println("Inserted");
                        }
                        else
                        {
                            System.out.println("Not Inserted");
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
                    Vehiclenum v=new Vehiclenum(flag,zz);}
                    /*int response=JOptionPane.showConfirmDialog(this, "Do you want to Resgister?","heading",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
                    if(response==JOptionPane.YES_NO_OPTION)
                    {
                        Registration r=new Registration();
                    }
                    else
                    {
                        setVisible(false);
                    }*/
                }
            }
            else
            {
                
                JOptionPane.showMessageDialog(this, "Enter Only Tricity Vehicle","heading",JOptionPane.CLOSED_OPTION );
                setVisible(true);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
