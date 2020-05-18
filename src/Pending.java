
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bharat
 */
public class Pending extends JFrame
{
    ImageIcon i;
    private JPanel contentPane;
	private JTable table;
    JLabel l;
    Pending()
    {
        setVisible(true);
        setSize(400, 400);
        setLayout(null);
        setTitle("Pending Vehicles");
       // setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        l=new JLabel("Pending Vechicles");
        l.setFont(new Font("Serif",Font.BOLD,38));
        l.setBounds(40, 40, 300, 80);
        l.setForeground(Color.WHITE);
        add(l);
        
        contentPane = new JPanel();
       // contentPane.setForeground(Color.BLACK);
//        contentPane.setBounds(25, 150, 100, 200);
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(Color.DARK_GRAY);
                
		String data[][]=null;
		String column[]=null;
		try{
			//Connection con=DB.getConnection();
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
			PreparedStatement ps=con.prepareStatement("select * from temp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		//table.setBounds(25, 150, 100, 100);
		contentPane.add(sp, BorderLayout.CENTER);
        
        
        
    }
    public static void main(String ar[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
					Pending p=new Pending();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
}
