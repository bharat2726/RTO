
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JLabel l;
    int fff=0;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
  //  JLabel l2;
    JTextField tf,tf2,tf3,tf4,tf5,tf6,tf7;
    //JTextField tf1;
    JPasswordField tf1;
    JButton b1,b2;String str;
    Login(int ff)
    {
        setVisible(true);
        setTitle("Login");

        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
//setSize(1970, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bharat\\Documents\\NetBeansProjects\\Vehicle\\src\\2.jpg")));
        //setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        l2=new JLabel("LOGIN");
        l2.setFont(new Font("Serif",Font.BOLD,80));
        l2.setBounds(800, 100, 500, 70);
        l2.setForeground(Color.WHITE);
        l=new JLabel("Name :");
        l.setBounds(700, 400, 100, 30);
        l.setFont(new Font("Serif",Font.BOLD,28));
        l.setForeground(Color.ORANGE);
        tf=new JTextField(15);
        tf.setBounds(950, 400, 200, 30);
        tf.setFont(new Font("Serif",Font.BOLD,28));
        l1=new JLabel("Password :");
        l1.setBounds(700, 500, 200, 30);
        l1.setFont(new Font("Serif",Font.BOLD,28));
        l1.setForeground(Color.ORANGE);
        tf1=new JPasswordField(15);
        tf1.setBounds(950, 500, 200, 30);
        tf1.setFont(new Font("Serif",Font.BOLD,28));
        b1=new JButton("Login");
        b1.setBounds(800, 630, 300,50);
        b1.setFont(new Font("Serif",Font.BOLD,18));
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Serif",Font.BOLD,28));
        b2=new JButton("HOME");
        b2.setFont(new Font("Serif",Font.BOLD,10));
        b2.setBounds(900, 900, 100,30);
        b2.setFont(new Font("Serif",Font.BOLD,18));
        add(l);
        add(l2);
        add(tf);
        add(l1);
        add(tf1);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        if(ff==1)
        {
            fff=1;
        }
        else if(ff==2)
        {
            fff=2;
        }
        else if(ff==3)
        {
            fff=3;
        }
        else if(ff==4)
        {
            fff=4;
        }
    }
    public static void main(String ar[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int ff=0;
                Login f=new Login(ff);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int f=0,ff=0;
        if(e.getSource()==b2)
        {
            setVisible(false);
            Department d=new Department();
        }
        else if(e.getSource()==b1)
        {
            String str1=null,str2=null;
            str1=tf.getText();
            str2=tf1.getText();
            if(fff==1)///////
            {
                if(str1.equals("RTO"))
            {
                if(str2.equals("12345678"))
                {
                    f=1;int z=1;
                     JOptionPane.showMessageDialog(this, "User Found","heading",JOptionPane.CLOSED_OPTION );
                    setVisible(false);
                    Vehiclenum v=new Vehiclenum(f,z);      
                }
                else
                {
                    setVisible(false);
                    JOptionPane.showMessageDialog(this, "Wrong Password","heading",JOptionPane.CLOSED_OPTION );
                    Login ll=new Login(fff);
                }
            }
                else
            {
                setVisible(false);
                
                JOptionPane.showMessageDialog(this, "Invalid User","heading",JOptionPane.CLOSED_OPTION );
                Login ll=new Login(fff);
            }
            }
            else if(fff==4)
            {
                if(str1.equals("POLICE"))
            {
                if(str2.equals("12345678"))
                {
                    f=4;int z=0;
                    
                     JOptionPane.showMessageDialog(this, "User Found","heading",JOptionPane.CLOSED_OPTION );
                     setVisible(false);
                    Vehiclenum v=new Vehiclenum(f,z);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Wrong Password","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                    Login ll=new Login(fff);
                }
            }
                else
            {
                
                
                JOptionPane.showMessageDialog(this, "Invalid User","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                Login ll=new Login(fff);
            }
            }
            else if(fff==2)
            {
                if(str1.equals("TOLL"))
            {
                if(str2.equals("12345678"))
                {
                    f=2;int z=0;
                    
                    JOptionPane.showMessageDialog(this, "User Found","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                    Vehiclenum v=new Vehiclenum(f,z);
                }
                else
                {
                    
                    JOptionPane.showMessageDialog(this, "Wrong Password","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                    Login ll=new Login(ff);
                }
            }
            }
            else if(fff==3)
            {
                if(str1.equals("POLLUTION CHECK"))
            {
                if(str2.equals("12345678"))
                {
                    f=3;int z=0;
                    
                     JOptionPane.showMessageDialog(this, "User Found","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                    Vehiclenum v=new Vehiclenum(f,z);
                    
                }
                else
                {
                    
                    JOptionPane.showMessageDialog(this, "Wrong Password","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                    Login ll=new Login(fff);
                }
            }
                else
            {
                
                
                JOptionPane.showMessageDialog(this, "Invalid User","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                Login ll=new Login(ff);
            }
            }
            
                else
            {
                
                
                JOptionPane.showMessageDialog(this, "Invalid User","heading",JOptionPane.CLOSED_OPTION );setVisible(false);
                Login ll=new Login(fff);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}