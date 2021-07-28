package hotel.managment.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRooms extends JFrame {

	private JPanel contentPane;
	private JTextField t1, t4;
	private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
	JButton b1, b2;
	Choice c1;

	public AddRooms() {
		setBounds(280, 200, 1000, 450);
		setLayout(null);
		setTitle("Add Rooms");

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/twelve.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l15 = new JLabel(i2);
		l15.setBounds(400, 30, 500, 370);
		add(l15);

		JLabel mlb = new JLabel("Add Rooms");
		mlb.setForeground(Color.GREEN);

		mlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		mlb.setBounds(194, 10, 120, 22);
		add(mlb);

		JLabel l1 = new JLabel("Room Number");
		l1.setForeground(new Color(25, 25, 112));
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(64, 70, 150, 22);
		add(l1);

		t1 = new JTextField();
		t1.setBounds(190, 70, 156, 15);
		t1.setFont(new Font("serif", Font.BOLD, 20));
		add(t1);

		JLabel l2 = new JLabel("Availability");
		l2.setForeground(new Color(25, 25, 112));
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(64, 110, 102, 22);
		add(l2);

		comboBox = new JComboBox(new String[] { "Available", "Occupied" });
		comboBox.setBounds(190, 110, 154, 20);
		comboBox.setBackground(Color.WHITE);
		add(comboBox);

		JLabel l3 = new JLabel("Cleaning Status");
		l3.setForeground(new Color(25, 25, 112));
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(64, 150, 150, 22);
		add(l3);

		comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
		comboBox_2.setBounds(190, 150, 154, 20);
		comboBox_2.setBackground(Color.WHITE);
		add(comboBox_2);

		JLabel l4 = new JLabel("Price");
		l4.setForeground(new Color(25, 25, 112));
		l4.setFont(new Font("Tahoma", Font.BOLD, 15));
		l4.setBounds(64, 190, 102, 22);
		add(l4);

		t4 = new JTextField();
		t4.setBounds(190, 190, 156, 20);
		t4.setFont(new Font("serif", Font.BOLD, 15));
		add(t4);

		JLabel l5 = new JLabel("Bed Type");
		l5.setForeground(new Color(25, 25, 112));
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(64, 230, 102, 22);
		add(l5);

		comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed" });
		comboBox_3.setBounds(190, 230, 154, 20);
		comboBox_3.setBackground(Color.WHITE);
		add(comboBox_3);

		b1 = new JButton("Add");
		b1.setBounds(64, 321, 111, 33);
		b1.setBackground(Color.GREEN);
		b1.setForeground(Color.WHITE);
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String avail = (String) comboBox.getSelectedItem();
				String cleansts = (String) comboBox_2.getSelectedItem();
				String btype = (String) comboBox_3.getSelectedItem();
				int roomno=Integer.parseInt(t1.getText());
				int price=Integer.parseInt(t4.getText());
				
				Conn c = new Conn();
				
				try {
					String sql="INSERT INTO `rooms`(`roomno`, `avail`, `cleaningsts`, `price`, `btype`) VALUES (?,?,?,?,?)";
					PreparedStatement ps = c.con.prepareStatement(sql);
					ps.setInt(1, roomno);
					ps.setString(2,avail);
					ps.setString(3, cleansts);
					ps.setInt(4, price);
					ps.setString(5,btype);
					
					int n = ps.executeUpdate();
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "New Room Added");
						setVisible(false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});

		b2 = new JButton("Back");
		b2.setBounds(198, 321, 111, 33);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Dashboard().setVisible(true);
				dispose();
			}
		});

		getContentPane().setBackground(Color.WHITE);

	}

	public static void main(String[] args) {
		new AddRooms().setVisible(true);
	}
}
