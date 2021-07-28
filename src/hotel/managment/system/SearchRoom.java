package hotel.managment.system;

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

public class SearchRoom extends JFrame{

	JComboBox c1;
	JCheckBox cb1;
	JButton b1,b2;
	JTable t1;
	JLabel lt1,l1,l2,l3,l4,l5,l6,l7,title;
	public SearchRoom() {
		title = new JLabel("Search For Room");
		title.setFont(new Font("Yu Mincho", Font.BOLD, 30));
		title.setBounds(350, 11, 260, 53);
		title.setForeground(Color.BLACK);
		add(title);
		
		
		lt1 = new JLabel("Room Bed Type");
		lt1.setBounds(35, 80, 150, 24);
		lt1.setFont(new Font("Raleway", Font.PLAIN, 15));
		add(lt1);
		
		c1=new JComboBox(new String[] {"Single Bed","Double Bed"});
		c1.setBounds(190, 80, 120, 30);
		c1.setFont(new Font("Raleway", Font.PLAIN, 15));
		c1.setBackground(Color.WHITE);
		add(c1);
		
		
		cb1=new JCheckBox("Only Display Available");
		cb1.setBounds(650, 80, 200, 30);
		cb1.setFont(new Font("Raleway", Font.PLAIN, 15));
		cb1.setBackground(Color.WHITE);
		add(cb1);
		
		l1=new JLabel("Room No");
		l1.setBounds(70, 180, 70, 20);
		l1.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l1);

		l2=new JLabel("Availiblity");
		l2.setBounds(270, 180, 90, 20);
		l2.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l2);
		
		l3=new JLabel("Status");
		l3.setBounds(480, 180, 90, 20);
		l3.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l3);
		
		l4=new JLabel("Price");
		l4.setBounds(670, 180, 70, 20);
		l4.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l4);
		
		l5=new JLabel("Bed Type");
		l5.setBounds(840, 180, 70, 20);
		l5.setFont(new Font("Raleway", Font.BOLD, 15));
		add(l5);
		
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
				String btype=(String) c1.getSelectedItem();
				String sql=null;
				if(cb1.isSelected()) {
					try {
						
						sql="SELECT * FROM rooms WHERE btype=? AND avail='Available'";
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
					
						sql="SELECT * FROM rooms WHERE btype=?";
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
		setTitle("Search Room");
	}

	public static void main(String[] args) {
		new SearchRoom();

	}

}
