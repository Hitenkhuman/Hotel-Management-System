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

public class UpdateRoom extends JFrame{
	JLabel title,l1,l2,l3,l4;
	Choice ch1;
	JTextField t2,t3,t4;
	JButton b1,b2,b3;
	public UpdateRoom() {
		
		title = new JLabel("UPDATE ROOM STATUS");
		title.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		title.setBounds(100, 11, 260, 53);
		title.setForeground(Color.BLUE);
		add(title);
		
		
		l1 = new JLabel("ID ");
		l1.setBounds(35, 80, 200, 24);
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
		ch1.setBounds(240, 80, 150, 24);
		ch1.setFont(new Font("Raleway", Font.PLAIN, 15));
		ch1.setBackground(Color.white);
		add(ch1);
		
		
		l2 = new JLabel("Room No");
		l2.setBounds(35, 130, 200, 24);
		l2.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(l2);
		
		t2=new JTextField();
		t2.setBounds(240, 130, 150, 24);
		t2.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(t2);
		
		l3 = new JLabel("Availiblity");
		l3.setBounds(35, 180, 200, 24);
		l3.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(l3);
		
		t3=new JTextField();
		t3.setBounds(240, 180, 150, 24);
		t3.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(t3);

		l4 = new JLabel("Check Status");
		l4.setBounds(35, 230, 200, 24);
		l4.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(l4);
		
		t4=new JTextField();
		t4.setBounds(240, 230, 150, 24);
		t4.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(t4);
		
		b1=new JButton("Check");
		b1.setBounds(140, 280, 120, 30);
		b1.setBackground(Color.darkGray);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway", Font.PLAIN, 15));
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
						t3.setText(rs.getString("avail"));
						t4.setText(rs.getString("cleaningsts"));
						
					}
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		
		b2 = new JButton("Update");
		b2.setBounds(25, 330, 120, 30);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int roomno=Integer.parseInt(t2.getText());
				String avail=t3.getText();
				String status=t4.getText();
				Conn c = new Conn();
				try {
					String sql="UPDATE rooms set avail=?,cleaningsts=? WHERE roomno=?";
					PreparedStatement pd=c.con.prepareStatement(sql);
					pd.setString(1, avail);
					pd.setString(2, status);
					pd.setInt(3, roomno);
					int n=pd.executeUpdate();
					if(n>0) {
						JOptionPane.showMessageDialog(null, "Room Updated Successfully");
						new Reception().setVisible(true);
						dispose();
					}
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		
		b3 = new JButton("Back");
		b3.setBounds(260, 330, 120, 30);
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
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/seventh.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l5 = new JLabel(i2);
		l5.setBounds(400, 50, 500, 300);
		add(l5);
		
		setLayout(null);
		setBounds(380, 200, 950, 450);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setTitle("Update room");
	}
	public static void main(String[] args) {
		new UpdateRoom();
	}

}
