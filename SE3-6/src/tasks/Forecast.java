package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import menu.MenuScreen;
import service.HeaderScreen;
import service.Tool;

public class Forecast {
	public static void addForecast(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Update Forecast");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("Degree Code");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField semesterName = new JTextField();
		semesterName.setBounds(205, 163, 75, 30);
	    tool.getPanel().add(semesterName);
		
		JLabel nameLabel = new JLabel("Number of Students");
		nameLabel.setBounds(75, 200, 115, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField numTextField = new JTextField();
		numTextField.setBounds(205, 198, 150, 25);
		tool.getPanel().add(numTextField);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,300,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(200,300,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton addCourse = new JButton("Update Forecast");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(semesterName!=null && semesterName.getText().trim().length()!=0 
						&& numTextField!=null && numTextField.getText().trim().length()!=0){
					try{
						Vector degreeVector=new Vector();		
						try{
							CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\Degrees.csv"));
							List<String[]> totalDegreesList=reader.readAll();
							CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Degrees.csv"));
							for(String[] degree : totalDegreesList){
								if(degree[0].equalsIgnoreCase(semesterName.getText().trim())){
									degree[3]=numTextField.getText();
									writer.writeNext(degree);
									degreeVector.add(degree);
								}else{
									writer.writeNext(degree);
									degreeVector.add(degree);
								}
							}								
							writer.close();
							tool.setDegrees(degreeVector);
						}catch(Exception ex){
							ex.printStackTrace();
						}
						JOptionPane.showMessageDialog(addCourse, "Updated Succesfully");
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter Degree code and forecast details");
				}
			}
		});
		addCourse.setBounds(305,300,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
}
