package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import au.com.bytecode.opencsv.CSVWriter;
import menu.MenuScreen;
import service.HeaderScreen;
import service.ReadWriteCSVFile;
import service.Tool;

public class Schedule {
	public static void schedules(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Schedules");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JButton generateShceduleButton = new JButton("Generate Schedule");
		generateShceduleButton.setBackground(Color.GREEN);		
		generateShceduleButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		generateShceduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
				Vector schedule=readWriteCSVFile.schedule();
				tool.setSchedule(readWriteCSVFile.schedule());
				try{
					CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\courseschedule.csv"));
					Iterator iterator=schedule.iterator();
					String[] record={"Semester","Course Code & Name","Faculty","Days","Number of student"};
					writer.writeNext(record);
					while(iterator.hasNext()){
						record=(String[])iterator.next();
						writer.writeNext(record);
					}			
					writer.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				viewSchedule(tool);
			}
		});
		generateShceduleButton.setBounds(135,200,300,30);
		tool.getPanel().add(generateShceduleButton);
		
		JButton testShceduleButton = new JButton("Test Schedule");
		testShceduleButton.setBackground(Color.GREEN);		
		testShceduleButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		testShceduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
				tool.setSchedule(readWriteCSVFile.schedule());
				viewSchedule(tool);
			}
		});
		testShceduleButton.setBounds(135,240,300,30);
		tool.getPanel().add(testShceduleButton);
		
		JButton updateShceduleButton = new JButton("Update Schedule");
		updateShceduleButton.setBackground(Color.GREEN);		
		updateShceduleButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateShceduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		updateShceduleButton.setBounds(135,280,300,30);
		//tool.getPanel().add(updateShceduleButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,360,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,360,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}
	
	public static void viewSchedule(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Schedule");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,250,20);
		tool.getPanel().add(label);
		
		ReadWriteCSVFile readCSVFile=new ReadWriteCSVFile();
		Object rowData[][]= { { "Data", "Data", "Data", "Data","Data"},
                { "Data", "Data", "Data", "Data","Data"} };;
		
		Object columnNames[] = { "Semester", "Course Code & Name", "Faculty", "Days","Num Of Students"};
		if(tool.getSchedule()!=null && tool.getSchedule().size()!=0){
			rowData=new Object[tool.getSchedule().size()][5];
			for(int i=0;i<tool.getSchedule().size();i++){
				String split[]=((String[])tool.getSchedule().get(i));
				if(split!=null && split.length>=5){
					rowData[i]=split;
				}
			}
		}
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 150, 450, 225);
		tool.getPanel().add(scroll);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(150,400,80,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(250,400,100,30);
		tool.getPanel().add(cancelButton);		
		
		tool.getPanel().repaint();
	}
}
