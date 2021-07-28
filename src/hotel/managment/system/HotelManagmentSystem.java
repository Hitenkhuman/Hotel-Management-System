package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagmentSystem extends JFrame implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HotelManagmentSystem() {
		Random rand = new Random();
		float r,g,b;
		setBounds(100, 100, 1365, 565);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/first.jpg"));
		
		JLabel l1=new JLabel(i1);
		l1.setBounds(0, 0, 1366, 565);
		add(l1);
		
		JLabel l2=new JLabel("Hotel Managment System");
		l2.setBounds(20, 440, 800, 80);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif", Font.BOLD, 65));
		l1.add(l2);
		
		JButton b1=new JButton("Next");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(960, 460, 100, 40);
		b1.setFont(new Font("serif", Font.BOLD, 25));
		
		b1.addActionListener(this);
		l1.add(b1);
		
		setLayout(null);
		setVisible(true);
		setTitle("Welcome");
		while(true) {
			l2.setVisible(false);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				
			}
			l2.setVisible(true);
			r=rand.nextFloat();
			g=rand.nextFloat();
			b=rand.nextFloat();
			l2.setForeground(new Color(r, g, b));
			try {
				Thread.sleep(100);
			} catch (Exception e) {	
			}
		}
		
		
	}
	

	public static void main(String[] args) {
		new HotelManagmentSystem();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Login().setVisible(true);
		//this.setVisible(false);
		dispose();
	}

}
