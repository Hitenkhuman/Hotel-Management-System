package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class AddEmployee extends JFrame {
	JTextField t1, t2, t3, t4, t5, t6;
	JRadioButton r1, r2;
	JComboBox c1;
	JButton b1;
	ButtonGroup bb;
	JLabel name, age, gender, job, salary, phone, aadhar, email;

	public AddEmployee() {

		name = new JLabel("NAME");
		name.setBounds(60, 30, 100, 20);
		name.setFont(new Font("serif", Font.BOLD, 20));
		add(name);

		age = new JLabel("AGE");
		age.setBounds(60, 80, 100, 20);
		age.setFont(new Font("serif", Font.BOLD, 20));
		add(age);

		gender = new JLabel("GENDER");
		gender.setBounds(60, 130, 100, 20);
		gender.setFont(new Font("serif", Font.BOLD, 20));
		add(gender);

		job = new JLabel("JOB");
		job.setBounds(60, 180, 100, 20);
		job.setFont(new Font("serif", Font.BOLD, 20));
		add(job);

		salary = new JLabel("SALARY");
		salary.setBounds(60, 230, 100, 20);
		salary.setFont(new Font("serif", Font.BOLD, 20));
		add(salary);

		phone = new JLabel("PHONE");
		phone.setBounds(60, 280, 100, 20);
		phone.setFont(new Font("serif", Font.BOLD, 20));
		add(phone);

		aadhar = new JLabel("AADHAR");
		aadhar.setBounds(60, 330, 100, 20);
		aadhar.setFont(new Font("serif", Font.BOLD, 20));
		add(aadhar);

		email = new JLabel("EMAIL");
		email.setBounds(60, 380, 100, 20);
		email.setFont(new Font("serif", Font.BOLD, 20));
		add(email);

		t1 = new JTextField();
		t1.setBounds(200, 30, 200, 30);
		t1.setFont(new Font("serif", Font.BOLD, 20));
		add(t1);

		t2 = new JTextField();
		t2.setBounds(200, 80, 200, 30);
		t2.setFont(new Font("serif", Font.BOLD, 20));
		add(t2);

		r1 = new JRadioButton("Male",true);
		r1.setBounds(200, 130, 100, 30);
		r1.setFont(new Font("serif", Font.BOLD, 20));
		r1.setBackground(Color.white);
		add(r1);

		r2 = new JRadioButton("Female",false);
		r2.setBounds(300, 130, 100, 30);
		r2.setFont(new Font("serif", Font.BOLD, 20));
		r2.setBackground(Color.white);
		add(r2);

		String str[] = { "Front Desk Clerks", "Chef", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager",
				"Housekeeping", "Forters" };
		c1 = new JComboBox(str);
		c1.setBounds(200, 180, 200, 30);
		c1.setBackground(Color.white);
		add(c1);

		t3 = new JTextField();
		t3.setBounds(200, 230, 200, 30);
		t3.setFont(new Font("serif", Font.BOLD, 20));
		add(t3);

		t4 = new JTextField();
		t4.setBounds(200, 280, 200, 30);
		t4.setFont(new Font("serif", Font.BOLD, 20));
		add(t4);

		t5 = new JTextField();
		t5.setBounds(200, 330, 200, 30);
		t5.setFont(new Font("serif", Font.BOLD, 20));
		add(t5);

		t6 = new JTextField();
		t6.setBounds(200, 380, 200, 30);
		t6.setFont(new Font("serif", Font.BOLD, 20));
		add(t6);
		
		bb=new ButtonGroup();
		bb.add(r1);
		bb.add(r2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/tenth.jpg"));
		Image img = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img);
		JLabel jb = new JLabel(i2);
		jb.setBounds(420, 30, 500, 500);
		add(jb);

		b1 = new JButton("SUBMIT");
		b1.setBounds(200, 430, 200, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.blue);
		add(b1);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = t1.getText();
				int age = Integer.parseInt(t2.getText());
				String salary = t3.getText();
				String phone = t4.getText();
				String aadhar = t5.getText();
				String email = t6.getText();

				String gender = null;
				if (r2.isSelected()) {
					gender = "Female";
				} else {
					gender = "Male";
				}

				String job = (String) c1.getSelectedItem();

					Conn c = new Conn();

					String sql = "INSERT INTO `employee`( `name`, `age`, `gender`, `job`, `salary`, `phone`, `aadhar`, `email`) VALUES (?,?,?,?,?,?,?,?)";
					try {
						PreparedStatement ps = c.con.prepareStatement(sql);
						ps.setString(1, name);
						ps.setInt(2, age);
						ps.setString(3, gender);
						ps.setString(4, job);
						ps.setString(5, salary);
						ps.setString(6, phone);
						ps.setString(7, aadhar);
						ps.setString(8, email);
						int n = ps.executeUpdate();
						if (n > 0) {
							JOptionPane.showMessageDialog(null, "New Employee Added");
							setVisible(false);
						}

					} catch (Exception e1) {

						e1.printStackTrace();
					}
				

			}
		});

		JLabel title = new JLabel("ADD EMPLOYEE DETAILS");
		title.setForeground(Color.BLUE);
		title.setBounds(50, 0, 400, 40);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		jb.add(title);

		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setBounds(280, 200, 950, 530);
		setTitle("Add Employee");
	}

	public static void main(String[] args) {
		new AddEmployee();
	}

}
