package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDrivers extends JFrame{
	JTextField t1, t2, t4,t5,t7;
	JComboBox c1,c2;
	JButton b1,b2;
	JLabel name, age, gender, company, model, avail, loc;
	
	public AddDrivers() {
		
		
		name = new JLabel("Name");
		name.setBounds(60, 30, 100, 20);
		name.setFont(new Font("serif", Font.BOLD, 20));
		add(name);

		age = new JLabel("Age");
		age.setBounds(60, 80, 100, 25);
		age.setFont(new Font("serif", Font.BOLD, 20));
		add(age);

		gender = new JLabel("Gender");
		gender.setBounds(60, 130, 100, 20);
		gender.setFont(new Font("serif", Font.BOLD, 20));
		add(gender);

		company = new JLabel("Car Comapany");
		company.setBounds(60, 180, 140, 25);
		company.setFont(new Font("serif", Font.BOLD, 20));
		add(company);

		model = new JLabel("Model");
		model.setBounds(60, 230, 100, 20);
		model.setFont(new Font("serif", Font.BOLD, 20));
		add(model);

		avail = new JLabel("Availiblity");
		avail.setBounds(60, 280, 100, 20);
		avail.setFont(new Font("serif", Font.BOLD, 20));
		add(avail);

		loc = new JLabel("Location");
		loc.setBounds(60, 330, 100, 20);
		loc.setFont(new Font("serif", Font.BOLD, 20));
		add(loc);
		
		t1 = new JTextField();
		t1.setBounds(200, 30, 200, 30);
		t1.setFont(new Font("serif", Font.BOLD, 20));
		add(t1);

		t2 = new JTextField();
		t2.setBounds(200, 80, 200, 30);
		t2.setFont(new Font("serif", Font.BOLD, 20));
		add(t2);
		
		String gen[]= {"Male","Female","Other"};
		c1=new JComboBox(gen);
		c1.setBounds(200, 130, 200, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		t4 = new JTextField();
		t4.setBounds(200, 180, 200, 30);
		t4.setFont(new Font("serif", Font.BOLD, 20));
		add(t4);
		
		t5 = new JTextField();
		t5.setBounds(200, 230, 200, 30);
		t5.setFont(new Font("serif", Font.BOLD, 20));
		add(t5);
		
		String av[]= {"Available","Busy"};
		c2=new JComboBox(av);
		c2.setBounds(200, 280, 200, 30);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		t7 = new JTextField();
		t7.setBounds(200, 330, 200, 30);
		t7.setFont(new Font("serif", Font.BOLD, 20));
		add(t7);
		
		b1 = new JButton("Add");
		b1.setBounds(100, 380, 120, 33);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = t1.getText();
				int age = Integer.parseInt(t2.getText());
				String gender = (String) c1.getSelectedItem();
				String company = t4.getText();
				String model = t5.getText();
				String avail = (String) c2.getSelectedItem();
				String loc = t7.getText();
				
				Conn c = new Conn();

				String sql = "INSERT INTO `drivers`(`name`, `age`, `gender`, `company`, `model`, `avail`, `location`) VALUES (?,?,?,?,?,?,?)";
				try {
					PreparedStatement ps = c.con.prepareStatement(sql);
					ps.setString(1, name);
					ps.setInt(2, age);
					ps.setString(3, gender);
					ps.setString(4, company);
					ps.setString(5, model);
					ps.setString(6,avail);
					ps.setString(7, loc);
					int n = ps.executeUpdate();
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "New Driver Added");
						setVisible(false);
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			
				
			}
		});
		
		b2 = new JButton("Back");
		b2.setBounds(250, 380, 120, 33);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/eleven.jpg"));
		Image img = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img);
		JLabel jb = new JLabel(i2);
		jb.setBounds(420,80, 500, 300);
		add(jb);
		
		JLabel title = new JLabel("Add Drivers");
		title.setForeground(Color.darkGray);
		title.setBounds(580, 20, 200, 40);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(title);
		
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setBounds(280, 200, 1000, 530);
		setTitle("Add Drivers");
		
		
		
		
	}
	public static void main(String[] args) {
		new AddDrivers();
	}

}
