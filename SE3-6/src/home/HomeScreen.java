package home;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import menu.MenuScreen;
import service.HeaderScreen;
import service.Tool;

public class HomeScreen{
	public JFrame frame;
	public JPanel panel;
	public HomeScreen(){
		initialize();
	}
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("OCUGSECS");
		frame.setBounds(100, 100, 625, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		final JLabel label=new JLabel("Welcome to OCU");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(175,75,250,20);
		panel.add(label);
		
		JButton login = new JButton("Click to Login");
		login.setBackground(Color.GREEN);		
		login.setFont(new Font("Courier New", Font.PLAIN, 18));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HeaderScreen headerScreen=new HeaderScreen();
				Tool tool=new Tool();
				headerScreen.getLoginScreen(panel,tool);
			}
		});
		login.setBounds(175, 175, 200, 30);
		panel.add(login);
		frame.setVisible(true);
		frame.add(panel);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
