package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame{

	JMenuBar mb;
	JMenuItem i1,i2,i3,i4;
	JMenu m1,m2;
	
	public Dashboard() {
		
		mb=new JMenuBar();
		mb.setBounds(0, 0, 1950, 30);
		add(mb);
		
		m1=new JMenu("Hotel Managment");
		m1.setForeground(Color.blue);
		mb.add(m1);
		
		m2=new JMenu("Admin");
		m2.setForeground(Color.red);
		mb.add(m2);
		
		i1=new JMenuItem("RECEPTION");
		m1.add(i1);
		i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				
			}
		});
		
		i2=new JMenuItem("ADD EMPLOYEE");
		m2.add(i2);
		i2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEmployee().setVisible(true);
			}
		});
		
		i3=new JMenuItem("ADD ROOMS");
		m2.add(i3);
		i3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddRooms().setVisible(true);
				
			}
		});
		
		i4=new JMenuItem("ADD DRIVERS");
		m2.add(i4);
		i4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddDrivers().setVisible(true);
				
			}
		});
		
		ImageIcon ii=new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/third.jpg"));
		Image i=ii.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i);
		JLabel l1=new JLabel(i2);
		l1.setBounds(0, 0, 1920, 1000);
		add(l1);
		
		
		JLabel l2=new JLabel("THE TAJ HOTEL WELCOMES YOU");
		l2.setBounds(450, 100, 700, 50);
		l2.setForeground(Color.cyan);
		l2.setFont(new Font("serif",Font.BOLD,40));
		l1.add(l2);
		
		setLayout(null);
		setBounds(-10,0, 1950, 1000);
		setVisible(true);
		
		setTitle("Dashboard");
		
		
		
	}
	public static void main(String[] args) {
		new Dashboard();
	}
	
}
