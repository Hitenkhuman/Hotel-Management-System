package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Room extends JFrame{
	JTable t1;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5;
	public Room() {
		t1=new JTable();
		t1.setBounds(20, 40, 500, 400);
		t1.setFont(new Font("serif", Font.ROMAN_BASELINE,15));
		add(t1);
		
		b1=new JButton("Load data");
		b1.setBounds(100, 480, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("serif", Font.BOLD, 15));
		b1.setForeground(Color.white);
		add(b1);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Conn c=new Conn();
					String sql="SELECT * FROM rooms";
					Statement st=c.con.createStatement();
					ResultSet rs=st.executeQuery(sql);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		b2=new JButton("Back");
		b2.setBounds(280, 480, 120, 30);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("serif", Font.BOLD, 15));
		add(b2);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				dispose();
			}
		});
		
		l1=new JLabel("Room No");
		l1.setBounds(50, 20, 70, 20);
		add(l1);

		l2=new JLabel("Availiblity");
		l2.setBounds(140, 20, 70, 20);
		add(l2);
		
		l3=new JLabel("Status");
		l3.setBounds(235, 20, 90, 20);
		add(l3);
		
		l4=new JLabel("Price");
		l4.setBounds(345, 20, 70, 20);
		add(l4);
		
		l5=new JLabel("Bed Type");
		l5.setBounds(440, 20, 70, 20);
		add(l5);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/eight.jpg"));
		Image img = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img);
		JLabel jb = new JLabel(i2);
		jb.setBounds(520,10, 600,600);
		add(jb);
		
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setBounds(280, 200, 1120, 600);
		setTitle("Rooms");
		
	}

	public static void main(String[] args) {
		new Room();
	}

}
