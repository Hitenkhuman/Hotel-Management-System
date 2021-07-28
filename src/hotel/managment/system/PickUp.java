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

import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame{

	JComboBox c1;
	JCheckBox cb1;
	JButton b1,b2;
	JTable t1;
	Choice ch1;
	JLabel lt1,l1,l2,l3,l4,l5,l6,l7,title;
	public PickUp() {
		title = new JLabel("PickUp Service");
		title.setFont(new Font("Yu Mincho", Font.BOLD, 30));
		title.setBounds(350, 11, 260, 53);
		title.setForeground(Color.BLACK);
		add(title);
		
		
		lt1 = new JLabel("Type of Car");
		lt1.setBounds(35, 80, 150, 24);
		lt1.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(lt1);
		
		ch1 = new Choice();
		try {
			Conn c = new Conn();
			Statement stmt=c.con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT  `company` FROM `drivers`");
			while (rs.next()) {
				ch1.add(rs.getString(1));
			}
		} catch (Exception e) {
		}
		ch1.setBounds(190, 80, 120, 30);
		ch1.setFont(new Font("Raleway", Font.PLAIN, 15));
		ch1.setBackground(Color.WHITE);
		add(ch1);
		
		
		cb1=new JCheckBox("Only Display Available");
		cb1.setBounds(650, 80, 200, 30);
		cb1.setFont(new Font("Raleway", Font.PLAIN, 15));
		cb1.setBackground(Color.WHITE);
		add(cb1);
		
		l1=new JLabel("Name");
		l1.setBounds(50, 180, 70, 20);
		l1.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l1);

		l2=new JLabel("Age");
		l2.setBounds(210, 180, 90, 20);
		l2.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l2);
		
		l3=new JLabel("Gender");
		l3.setBounds(330, 180, 90, 20);
		l3.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l3);
		
		l4=new JLabel("Company");
		l4.setBounds(470, 180, 90, 20);
		l4.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l4);
		
		l5=new JLabel("Brand");
		l5.setBounds(630, 180, 90, 20);
		l5.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l5);
		
		l6=new JLabel("Availiblity");
		l6.setBounds(740, 180, 90, 20);
		l6.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l6);
		
		l7=new JLabel("Location");
		l7.setBounds(890, 180, 90, 20);
		l7.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l7);
		
		t1=new JTable();
		t1.setBounds(0, 200, 1000,300);
		t1.setFont(new Font("Raleway", Font.PLAIN, 15));
		t1.setBackground(Color.WHITE);
		add(t1);
		
		b1=new JButton("Submit");
		b1.setBounds(350, 520, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Conn c=new Conn();
				String btype=(String) ch1.getSelectedItem();
				String sql=null;
				if(cb1.isSelected()) {
					try {
						
						sql="SELECT `name`, `age`, `gender`, `company`, `model`, `avail`, `location` FROM drivers WHERE company=? AND avail='Available'";
						PreparedStatement pd=c.con.prepareStatement(sql);
						pd.setString(1,btype);
						ResultSet rs=pd.executeQuery();
						t1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else {
					try {
					
						sql="SELECT `name`, `age`, `gender`, `company`, `model`, `avail`, `location` FROM drivers WHERE company=?";
						PreparedStatement pd=c.con.prepareStatement(sql);
						pd.setString(1,btype);
						ResultSet rs=pd.executeQuery();
						t1.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		b2 = new JButton("Back");
		b2.setBounds(500, 520, 120, 30);
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
		setBounds(380, 200, 1000, 600);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setTitle("PickUp Service");
	}

	public static void main(String[] args) {
		new PickUp();

	}

}
