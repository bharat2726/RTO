
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
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bharat
 */
public class Police extends JFrame implements ActionListener{
    int flag=0;
    String strx=null,str=null;
    JLabel l,l1,l2,l3,l4,t1,t2,t3,t4;
    JButton b;
    Police(String str2,String str1,int f)
    {
        setVisible(true);
        setLayout(null);
        //setLocationRelativeTo(null);
        
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Bharat\\Documents\\NetBeansProjects\\Vehicle\\src\\5.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(1970, 1080);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Police");
        l=new JLabel("POLICE");
        l.setFont(new Font("Serif",Font.BOLD,80));
        l.setBounds(800, 100, 1000, 80);
        l.setForeground(Color.YELLOW);
        l1=new JLabel("Owner's Name:");
        l1.setFont(new Font("Serif",Font.BOLD,40));
        l1.setBounds(700, 300, 300, 40);
        l1.setForeground(Color.WHITE);
        l2=new JLabel("Vehicle Number:");
        l2.setFont(new Font("Serif",Font.BOLD,40));
        l2.setBounds(700, 350, 300, 40);
        l2.setForeground(Color.WHITE);
        l3=new JLabel("Engine:");
        l3.setFont(new Font("Serif",Font.BOLD,40));
        l3.setBounds(700, 400, 300, 50);
        l3.setForeground(Color.WHITE);
        l4=new JLabel("Pollution Check:");
        l4.setFont(new Font("Serif",Font.BOLD,40));
        l4.setBounds(700, 450, 300, 40);
        l4.setForeground(Color.WHITE);
        
        t1=new JLabel();
        t1.setFont(new Font("Serif",Font.BOLD,40));
        t1.setBounds(1000, 300, 400, 40);
        t1.setForeground(Color.WHITE);
        t2=new JLabel();
        t2.setFont(new Font("Serif",Font.BOLD,40));
        t2.setBounds(1000, 350, 400, 40);
        t2.setForeground(Color.WHITE);
        t3=new JLabel();
        t3.setFont(new Font("Serif",Font.BOLD,40));
        t3.setBounds(850, 400, 400, 40);
        t3.setForeground(Color.WHITE);
        t4=new JLabel();
        t4.setFont(new Font("Serif",Font.BOLD,40));
        t4.setBounds(1000, 450, 400, 40);
        t4.setForeground(Color.WHITE);
        b=new JButton("Done");
        b.setBounds(900, 600, 200, 50);
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(b);
        b.addActionListener(this);
        //////////////
        flag=f;
        strx=str2;str=str1;
        try{
//            String str1=null,strxx=null;
            int y=0,year=0,i=0;
            System.out.println("xx");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
            PreparedStatement ps = null;
            if(str.equals("CH"))
            {
                ps=con.prepareStatement("select * from chd where Vehicle_Number=?");
            }
            else if(str.equals("PB"))
            {
                ps=con.prepareStatement("select * from pb where Vehicle_Number=?");
            }
           else if(str.equals("HR"))
            {
                ps=con.prepareStatement("select * from hr where Vehicle_Number=?");
            }
            ps.setString(1, strx);
            ResultSet rs=ps.executeQuery();
            System.out.println(rs+"**********");
            while(rs.next())
            {
                t1.setText(rs.getString(1));
                //System.out.println(t2.getText()+"*");
                t2.setText(rs.getString(4));
                str1=rs.getString(5);
                y=Integer.parseInt(str1);
                if(y<2014)
                    t3.setText("BS3");
                else
                    t3.setText("BS4");
                
                String s=null;
                s=rs.getString(8);
                y=Integer.parseInt(s);
                if((y+6)>12){
                    t4.setText("Valid");}
                else{
                        t4.setText("OutDated");}
            }
        }
        catch(ClassNotFoundException | SQLException ee)
        {
            System.out.println(ee);
        }
        if(t3.getText()=="BS3")
        {
            if(t4.getText()=="OutDated")
                JOptionPane.showMessageDialog(this, "POLLUTING ENVIRONMENT","heading",JOptionPane.CLOSED_OPTION);
        }
        ///////////////////
    }
    public static void main(String ar[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String s=null,ss=null;
                int f=0;
                Police p=new Police(s,ss,f);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            setVisible(false);
            int z=0;
            Vehiclenum vv=new Vehiclenum(flag,z);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
