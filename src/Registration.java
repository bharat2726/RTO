
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.lang.c
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Registration extends JFrame implements ActionListener
{
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel l8;
    JTextField tf1,tf2,tf3,tf4,tf44,tf444,tf4444,tf5;
    JTextField tf6;
    //JTextField tf7;
    JRadioButton r1,r2;
    JButton b,b1;
    ButtonGroup bg;
    Registration()
    {
        setVisible(true);
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bharat\\Documents\\NetBeansProjects\\Vehicle\\src\\4.png")));
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);        
//setSize(1970, 1080);
        setLayout(null);
        l1=new JLabel("REGISTRATION FORM");
        l1.setBounds(570, 100, 1000, 100);
        l1.setFont(new Font("Serif",Font.BOLD,80));
        l1.setForeground(Color.WHITE);
        l2=new JLabel("Owner's Name: ");
        l2.setBounds(600, 300, 400, 100);
        l2.setFont(new Font("Serif",Font.BOLD,40));
        l2.setForeground(Color.WHITE);
        tf1=new JTextField();
        tf1.setBounds(900, 330, 200, 40);
        tf1.setFont(new Font("Serif",Font.BOLD,40));
        l3=new JLabel("Address:");
        l3.setBounds(600, 350, 200, 100);
        l3.setFont(new Font("Serif",Font.BOLD,40));
        l3.setForeground(Color.WHITE);
        tf2=new JTextField();
        tf2.setBounds(900, 380, 200, 40);
        tf2.setFont(new Font("Serif",Font.BOLD,40));
        l4=new JLabel("Vehicle Model:");
        l4.setBounds(600, 400, 300, 100);
        l4.setFont(new Font("Serif",Font.BOLD,40));
        l4.setForeground(Color.WHITE);
        tf3=new JTextField();
        tf3.setBounds(900, 430, 200, 40);
        tf3.setFont(new Font("Serif",Font.BOLD,40));
        l5=new JLabel("Vehicle Number:");
        l5.setBounds(600, 450, 300, 100);
        l5.setFont(new Font("Serif",Font.BOLD,40));
        l5.setForeground(Color.WHITE);
        tf4=new JTextField();
        tf4.setBounds(900, 480,40,40);
        tf4.setFont(new Font("Serif",Font.BOLD,40));
        tf44=new JTextField();
        tf44.setBounds(950, 480,40,40);
        tf44.setFont(new Font("Serif",Font.BOLD,40));
        tf444=new JTextField();
        tf444.setBounds(1000, 480,40,40);
        tf444.setFont(new Font("Serif",Font.BOLD,40));
        tf4444=new JTextField();
        tf4444.setBounds(1050, 480,70,40);
        tf4444.setFont(new Font("Serif",Font.BOLD,40));
        l6=new JLabel("Maufacturing Year:");
        l6.setBounds(600, 500, 400, 100);
        l6.setFont(new Font("Serif",Font.BOLD,40));
        l6.setForeground(Color.WHITE);
        tf5=new JTextField();
        tf5.setBounds(950, 530,200,40);
        tf5.setFont(new Font("Serif",Font.BOLD,40));
        l7=new JLabel("Wheel:");
        l7.setBounds(600, 550, 300, 100);
        l7.setFont(new Font("Serif",Font.BOLD,40));
        l7.setForeground(Color.WHITE);
        r1=new JRadioButton("2 wheeler");
        r1.setBounds(730, 580  , 120, 40);
        r1.setSelected(false);
        r1.setFont(new Font("Serif",Font.BOLD,20));
        r1.setForeground(Color.BLACK);
        r2=new JRadioButton("4 Wheeler");
        r2.setBounds(870, 580, 200, 40);
        r2.setSelected(false);
        r1.setBackground(Color.WHITE);
        r2.setFont(new Font("Serif",Font.BOLD,20));
        r2.setForeground(Color.BLACK);
        r2.setBackground(Color.WHITE);
        b=new JButton("Submit");
        b.setBounds(650, 700, 200, 50);
        b1=new JButton("Reset");
        b1.setBounds(930, 700, 200, 50);
        bg=new ButtonGroup();
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);        
        add(tf3);
        add(l5);
        //bg.add(tf4);
        //bg.add(tf5);
        add(tf4);
        tf4.setColumns(2);
        add(tf44);
        add(tf444);
        add(tf4444);
        add(l6);
        add(tf5);
        add(b);
        add(b1);
        add(l7);
        //add(tf6);
        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);
        b1.addActionListener(this);
        b.addActionListener(this);
    }
    public static void main(String ar[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
             Registration r=new Registration();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String str=null,str1=null,str2=null,str3=null,str4=null,str5=null,str6=null,str7=null,str8=null,str9=null,strx=null;
        int f=0;
        if(e.getSource()==b1)
        {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf44.setText("");
            tf444.setText("");
            tf4444.setText("");
            tf5.setText("");
            bg.clearSelection();
        }
        if(e.getSource()==b)
        {
            str=tf1.getText();
            System.out.println(str);
            str1=tf2.getText();
            str3=tf3.getText();
            str4=tf4.getText();
            if(str4.equals("CH"))
            {
                System.out.println(str4);
                f=1;}
            if(str4.equals("PB"))
            {
                System.out.println(str4);
                f=2;}
            if(str4.equals("HR"))
            {
                System.out.println(str4);
                f=3;}
            str5=tf44.getText();
            str6=tf444.getText();
            str7=tf4444.getText();
            str8=tf5.getText();
            if(r1.isSelected()==true)
                str9="2 Wheeler";
            else
                str9="4 Wheeler";
            strx=str4+str5+str6+str7;
            
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
            Statement st=con.createStatement();
            if(f==1)
            {
                String q="insert into chd(Owner_Name,Address,Vehicle_Model,Vehicle_Number,Maufacturing_Year,Wheel_Type) values('"+str+"','"+str1+"','"+str3+"','"+strx+"','"+str8+"','"+str9+"')";
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
            else if(f==2)
            {
                String q="insert into pb(Owner_Name,Address,Vehicle_Model,Vehicle_Number,Maufacturing_Year,Wheel_Type) values('"+str+"','"+str1+"','"+str3+"','"+strx+"','"+str8+"','"+str9+"')";
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
            else if(f==3)
            {
                String q="insert into hr(Owner_Name,Address,Vehicle_Model,Vehicle_Number,Maufacturing_Year,Wheel_Type) values('"+str+"','"+str1+"','"+str3+"','"+strx+"','"+str8+"','"+str9+"')";
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
            JOptionPane.showMessageDialog(this, "Valide Pollution Check at Pollution Check Outlets","heading",JOptionPane.CLOSED_OPTION);
            
        }
        catch(SQLException ee)
        {
            System.out.println(ee);
        }
        catch(Exception eee)
        {
            System.out.println(eee);
        }
            setVisible(false);
        int Ff=0;
        int z=1;
            Vehiclenum v=new Vehiclenum(Ff,z);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}