package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import menu.MenuScreen;
import service.HeaderScreen;
import service.Tool;

public class Reports {
	public static void generateReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		final JButton generateShceduleButton = new JButton("Generate Schedule Report");
		generateShceduleButton.setBackground(Color.GREEN);		
		generateShceduleButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		generateShceduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(generateShceduleButton, "Report File Path : "+System.getProperty("user.dir")+"\\src\\courseschedule.csv");
			}
		});
		generateShceduleButton.setBounds(135,200,300,30);
		tool.getPanel().add(generateShceduleButton);
		
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(125,300,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,300,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}	
}
