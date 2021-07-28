package hotel.managment.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckOut extends JFrame{
	JLabel l1,l2,l3,title;
	JTextField t2;
	Choice ch1;
	JButton b1,b2,b3;
	Color cr=new Color(25,0,51);
	public CheckOut() {
		title = new JLabel("CHECK-OUT");
		title.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		title.setBounds(100, 11, 260, 53);
		title.setForeground(cr);
		add(title);
		
		l1 = new JLabel("Customer ID ");
		l1.setBounds(35, 80, 150, 24);
		l1.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(l1);
		
		ch1 = new Choice();
		try {
			Conn c = new Conn();
			Statement stmt=c.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers");
			while (rs.next()) {
				ch1.add(rs.getString(3));
			}
		} catch (Exception e) {
		}
		ch1.setBounds(190, 80, 150, 24);
		ch1.setFont(new Font("Raleway", Font.PLAIN, 15));
		ch1.setBackground(Color.white);
		add(ch1);
		
		
		l2 = new JLabel("Room Number");
		l2.setBounds(35, 130, 150, 24);
		l2.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(l2);
		
		t2=new JTextField();
		t2.setBounds(190, 130, 150, 24);
		t2.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(t2);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/tick.png"));
		Image i1 = i.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		i = new ImageIcon(i1);
		b1=new JButton(i);
		b1.setBounds(345, 80, 20, 20);
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = (String) ch1.getSelectedItem();
				Conn c = new Conn();
				try {
					 String sql="SELECT * FROM customers JOIN rooms ON customers.roomno=rooms.roomno WHERE idnum=?";
					PreparedStatement pd=c.con.prepareStatement(sql);
					pd.setString(1, id);
					ResultSet rs=pd.executeQuery();
					if(rs.next()) {
						t2.setText(rs.getString("roomno"));
					}
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		
		b2 = new JButton("CHECK OUT");
		b2.setBounds(35, 180, 130, 30);
		b2.setBackground(cr);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = (String) ch1.getSelectedItem();
				int roomno=Integer.parseInt(t2.getText());
				
				Conn c = new Conn();
				try {
					
					String sql="DELETE from customers WHERE idnum=?";
					PreparedStatement pd=c.con.prepareStatement(sql);
					pd.setString(1, id);
					
					
					int n=pd.executeUpdate();
					
					if(n>0) {
						sql="UPDATE rooms SET avail='Available' WHERE roomno=?";
						pd=c.con.prepareStatement(sql);
						pd.setInt(1, roomno);
						int n2=pd.executeUpdate();
						if(n2>0) {
							JOptionPane.showMessageDialog(null, "Check-Out Successfully");
							new Reception().setVisible(true);
							dispose();
						}
					}
				
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		
		b3 = new JButton("Back");
		b3.setBounds(210, 180, 130, 30);
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				dispose();
			}
		});
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/sixth.jpg"));
		Image i3 = i2.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
		ImageIcon i4 = new ImageIcon(i3);
		JLabel l3 = new JLabel(i4);
		l3.setBounds(375, 11, 400, 225);
		add(l3);
		
		setLayout(null);
		setBounds(380, 200, 800, 290);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setTitle("Check Out");
	}
	public static void main(String[] args) {
		new CheckOut();
	}

}
