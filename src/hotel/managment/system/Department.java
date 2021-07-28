package hotel.managment.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;
public class Department extends JFrame{

	
	JButton b1,b2;
	JTable t1;
	
	JLabel l1,l2;
	public Department() {
		
		l2 = new JLabel("Department");
		l2.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		l2.setBounds(120, 11, 120, 25);
		l2.setForeground(Color.BLACK);
		add(l2);
		
		l1 = new JLabel("Budget");
		l1.setFont(new Font("Yu Mincho", Font.BOLD, 15));
		l1.setBounds(470, 11, 120, 25);
		l1.setForeground(Color.BLACK);
		add(l1);
	
		t1=new JTable();
		t1.setBounds(10, 50, 690,300);
		t1.setFont(new Font("Raleway", Font.PLAIN, 15));
		t1.setBackground(Color.WHITE);
		add(t1);
		
		b1=new JButton("Load Data");
		b1.setBounds(120, 370, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Conn c=new Conn();
				String sql=null;
					try {
						
						sql="SELECT * FROM department";
						Statement stmt=c.con.createStatement();
						ResultSet rs=stmt.executeQuery(sql);
						t1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		b2 = new JButton("Back");
		b2.setBounds(340, 370, 120, 30);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				dispose();
			}
		});
		
		setLayout(null);
		setBounds(380, 200, 700, 500);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setTitle("Department");
	}

	public static void main(String[] args) {
		new Department();

	}

}
