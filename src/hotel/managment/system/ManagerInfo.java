package hotel.managment.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame {
	JTable t1;
	JButton b1, b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	public ManagerInfo() {
		t1 = new JTable();
		t1.setBounds(0, 40, 1000, 500);
		t1.setFont(new Font("serif", Font.ROMAN_BASELINE,15));
		add(t1);

		b1 = new JButton("Load Data");
		b1.setBounds(350, 550, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("serif", Font.BOLD, 15));
		b1.setForeground(Color.white);
		add(b1);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Conn c=new Conn();
					String sql="SELECT `name`, `age`, `gender`, `job`, `salary`, `phone`, `aadhar`, `email` FROM `employee` WHERE job='Manager'";
					Statement st=c.con.createStatement();
					ResultSet rs=st.executeQuery(sql);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		b2 = new JButton("Back");
		b2.setBounds(500, 550, 120, 30);
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
		
		l1=new JLabel("Name");
		l1.setBounds(50, 20, 70, 20);
		add(l1);

		l2=new JLabel("Age");
		l2.setBounds(170, 20, 70, 20);
		add(l2);
		
		l3=new JLabel("Gender");
		l3.setBounds(300, 20, 70, 20);
		add(l3);
		
		l4=new JLabel("Department");
		l4.setBounds(420, 20, 70, 20);
		add(l4);
		
		l5=new JLabel("Salary");
		l5.setBounds(530, 20, 70, 20);
		add(l5);
		
		
		
		l6=new JLabel("Phone");
		l6.setBounds(660, 20, 70, 20);
		add(l6);
		
		l7=new JLabel("Aadhar");
		l7.setBounds(780, 20, 70, 20);
		add(l7);
		
		l8=new JLabel("Email");
		l8.setBounds(890, 20, 70, 20);
		add(l8);
		
		setLayout(null);
		setBounds(380, 200, 1000, 650);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setTitle("Manager Data");
	}

	public static void main(String[] args) {
		new ManagerInfo();
	}

}

