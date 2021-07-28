package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class Login extends JFrame {
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	public Login() {
		l1=new JLabel("Username");
		l1.setBounds(40, 40, 100, 30);
		l1.setFont(new Font("serif",Font.BOLD, 20));
		add(l1);
		
		l2=new JLabel("Password");
		l2.setBounds(40, 100, 100, 30);
		l2.setFont(new Font("serif",Font.BOLD, 20));
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(160, 40, 150, 30);
		add(t1);
		
		t2=new JPasswordField();
		t2.setBounds(160, 100, 150, 30);
		add(t2);
		
		b1=new JButton("Login");
		b1.setBounds(40, 170, 100, 30);
		b1.setForeground(Color.white);
		b1.setBackground(Color.green);
		b1.setFont(new Font("serif",Font.BOLD, 20));
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=t1.getText();
				@SuppressWarnings("deprecation")
				String pass=t2.getText();
				Conn c=new Conn();
				String sql="Select *from users where userid='"+username+"' AND pass='"+pass+"'";
				try {
					Statement stmt=c.con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						new Dashboard().setVisible(true);
						dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid username and password");
						
					}
				} catch (Exception e2) {
					System.out.println(e);
				}
				
				
				
				
			}
		});
		
		b2=new JButton("Cancel");
		b2.setBounds(160, 170, 100, 30);
		b2.setForeground(Color.white);
		b2.setBackground(Color.red);
		b2.setFont(new Font("serif",Font.BOLD, 20));
		add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/second.jpg"));
		Image i=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);//change to required size
		ImageIcon i2=new ImageIcon(i);//converting to imageicon
		l3=new JLabel(i2);
		l3.setBounds(330, 10, 200, 200);
		add(l3);
		
		
		getContentPane().setBackground(Color.white);//change hole frames color
		setBounds(350,200,550,300);
		setTitle("Login");
		setLayout(null);
		setVisible(true);
	}
	
	
}
