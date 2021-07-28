package hotel.managment.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CustomerInfo extends JFrame {
	JLabel title,lblId,l2,l3,l4,l5,l6,l7,l8;
	JTextField  t2, t3, t5,t7,t8;
	JComboBox c1;
	JRadioButton r1, r2;
	Choice ch1;
	ButtonGroup bb;
	public CustomerInfo() {
		title = new JLabel("NEW CUSTOMER FORM");
		title.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		title.setBounds(118, 11, 260, 53);
		add(title);
		
		lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		add(lblId);
		
		c1 = new JComboBox(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
		c1.setBounds(271, 73, 150, 20);
		c1.setBackground(Color.white);
		add(c1);
		
		l2 = new JLabel("Number :");
		l2.setBounds(35, 111, 200, 14);
		add(l2);
		
		
		t2 = new JTextField();
		t2.setBounds(271, 111, 150, 20);
		add(t2);
		t2.setColumns(10);
		
		l3 = new JLabel("Name :");
		l3.setBounds(35, 151, 200, 14);
		add(l3);
		
		t3 = new JTextField();
		t3.setBounds(271, 151, 150, 20);
		add(t3);
		t3.setColumns(10);
		
		l4 = new JLabel("Gender :");
		l4.setBounds(35, 191, 200, 14);
		add(l4);
		
		
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);
		r1.setBounds(271, 191, 80, 12);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 191, 100, 12);
		add(r2);
		
		bb=new ButtonGroup();
		bb.add(r1);
		bb.add(r2);
		

		l5 = new JLabel("Country :");
		l5.setBounds(35, 231, 200, 14);
		add(l5);
		
		t5 = new JTextField();
		t5.setBounds(271, 231, 150, 20);
		add(t5);
		t5.setColumns(10);
		
		l6 = new JLabel("Allocated Room Number :");
		l6.setBounds(35, 274, 200, 14);
		add(l6);
		
		ch1 = new Choice();
		try {
			Conn c = new Conn();
			Statement stmt=c.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from rooms where avail='Available' ");
			while (rs.next()) {
				ch1.add(rs.getInt(1)+"");
			}
		} catch (Exception e) {
		}
		ch1.setBounds(271, 274, 150, 20);
		ch1.setBackground(Color.white);
		add(ch1);
		
		
		
		l7 = new JLabel("Checked-In :");
		l7.setBounds(35, 316, 200, 14);
		add(l7);
		
		t7 = new JTextField();
		t7.setBounds(271, 316, 150, 20);
		add(t7);
		t7.setColumns(10);
		
		l8 = new JLabel("Deposit :");
		l8.setBounds(35, 359, 200, 14);
		add(l8);
		
		t8 = new JTextField();
		t8.setBounds(271, 359, 150, 20);
		add(t8);
		t8.setColumns(10);
		
		
		JButton b1 = new JButton("Add");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				String radio = null;

				if (r1.isSelected()) {
					radio = "Male";
				} else if (r2.isSelected()) {
					radio = "Female";
				}

				

				try {

					String id = (String) c1.getSelectedItem();
					String number = t2.getText();
					String gender = radio;
					String name = t3.getText();
					String country = t5.getText();
					int roomno = Integer.parseInt(ch1.getSelectedItem());
					String checkdin = t7.getText();
					String deposite = t8.getText();

					String sql1 = "INSERT INTO `customers`(`id`, `idnum`, `name`, `gender`, `country`, `roomno`, `status`, `deposite`) VALUES (?,?,?,?,?,?,?,?)";
					String sql2 = "update rooms set avail = 'Occupied' where roomno = ?" ;
					PreparedStatement pd=c.con.prepareStatement(sql1);
					pd.setString(1, id);
					pd.setString(2, number);
					pd.setString(3, name);
					pd.setString(4, gender);
					pd.setString(5, country);
					pd.setInt(6, roomno);
					pd.setString(7, checkdin);
					pd.setString(8, deposite);
					int n=pd.executeUpdate();
					if(n>0) {
						pd=c.con.prepareStatement(sql2);
						pd.setInt(1, roomno);
						int n2=pd.executeUpdate();
						if(n2>0) {
							JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
							new Reception().setVisible(true);
							setVisible(false);
						}
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				} catch (NumberFormatException s) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number");
				}
			}
		});
		b1.setBounds(100, 430, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				dispose();
			}
		});
		b2.setBounds(260, 430, 120, 30);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		add(b2);
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/fifth.png"));
		Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(500, 0, 300, 500);
		add(l1);
		
		setLayout(null);
		setBounds(380, 200, 850, 550);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setTitle("New Customer Form");
	}
	public static void main(String[] args) {
		new CustomerInfo();
	}

}
