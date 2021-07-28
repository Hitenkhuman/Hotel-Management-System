package hotel.managment.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	Color c=new Color(0,100,0);
	public Reception() {
		b1=new JButton("New Customer Form");
		b1.setBackground(c);
		b1.setBounds(30, 30, 150, 30);	
		b1.setForeground(Color.white);
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomerInfo().setVisible(true);
				dispose();
				
			}
		});
		
		
		b2=new JButton("Room");
		b2.setBackground(c);
		b2.setBounds(30, 70, 150, 30);	
		b2.setForeground(Color.white);
		add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Room().setVisible(true);
				dispose();
			}
		});
		
		b3=new JButton("Department");
		b3.setBackground(c);
		b3.setBounds(30, 110, 150, 30);	
		b3.setForeground(Color.white);
		add(b3);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Department().setVisible(true);
				dispose();
			}
		});
		
		b4=new JButton("All Employee Info");
		b4.setBackground(c);
		b4.setBounds(30, 150, 150, 30);	
		b4.setForeground(Color.white);
		add(b4);
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new EmployeeInfo().setVisible(true);
				dispose();
			}
		});
		
		b5=new JButton("Customer Info");
		b5.setBackground(c);
		b5.setBounds(30, 190, 150, 30);	
		b5.setForeground(Color.white);
		add(b5);
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Customer().setVisible(true);
				dispose();
			}
		});
		
		
		
		b6=new JButton("Manager Info");
		b6.setBackground(c);
		b6.setBounds(30, 230, 150, 30);	
		b6.setForeground(Color.white);
		add(b6);
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerInfo().setVisible(true);
				dispose();
			
			}
		});
		
		b7=new JButton("Check Out");
		b7.setBackground(c);
		b7.setBounds(30, 270, 150, 30);	
		b7.setForeground(Color.white);
		add(b7);
		b7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new CheckOut().setVisible(true);
				dispose();
			}
		});
		
		
		b8=new JButton("Update Check Status");
		b8.setBackground(c);
		b8.setBounds(30, 310, 150, 30);	
		b8.setForeground(Color.white);
		add(b8);
		b8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new UpdateCheck().setVisible(true);
				dispose();
			}
		});
		
		b9=new JButton("Update Room Status");
		b9.setBackground(c);
		b9.setBounds(30, 350, 150, 30);	
		b9.setForeground(Color.white);
		add(b9);
		b9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateRoom().setVisible(true);
				dispose();
				
			}
		});
		
		b10=new JButton("Pickup Service");
		b10.setBackground(c);
		b10.setBounds(30, 390, 150, 30);	
		b10.setForeground(Color.white);
		add(b10);
		b10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PickUp().setVisible(true);
				dispose();
				
			}
		});
		
		b11=new JButton("Search Room");
		b11.setBackground(c);
		b11.setBounds(30, 430, 150, 30);	
		b11.setForeground(Color.white);
		add(b11);
		b11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchRoom().setVisible(true);
				dispose();
			}
		});
		
		b12=new JButton("Logout");
		b12.setBackground(c);
		b12.setBounds(30, 470, 150, 30);	
		b12.setForeground(Color.white);
		add(b12);
		b12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);;
				
			}
		});
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/fourth.jpg"));
		Image img = i1.getImage().getScaledInstance(500, 470, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(img);
		JLabel jb = new JLabel(i2);
		jb.setBounds(230,30, 500, 470);
		add(jb);
				
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setBounds(380, 200, 800, 570);
		setTitle("Reception");
	}

	public static void main(String[] args) {
		new Reception();
	}

}
