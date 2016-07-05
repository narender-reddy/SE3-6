package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import menu.MenuScreen;
import service.HeaderScreen;
import service.ReadWriteCSVFile;
import service.Tool;

public class Reports {
	static ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
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
				scheduleReports(tool);
			}
		});
		generateShceduleButton.setBounds(135,200,300,30);
		tool.getPanel().add(generateShceduleButton);
		
		final JButton generateStudentButton = new JButton("Student Report");
		generateStudentButton.setBackground(Color.GREEN);		
		generateStudentButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		generateStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentReports(tool);
			}
		});
		generateStudentButton.setBounds(135,250,300,30);
		tool.getPanel().add(generateStudentButton);
		
		final JButton generateFacultyButton = new JButton("Faculty Report");
		generateFacultyButton.setBackground(Color.GREEN);		
		generateFacultyButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		generateFacultyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facultyReports(tool);
			}
		});
		generateFacultyButton.setBounds(135,300,300,30);
		tool.getPanel().add(generateFacultyButton);
		
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(125,400,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,400,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}
	
	public static void studentReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Student Degree Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(175,125,350,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3"} };
		Object columnNames[] = { "Degree Name", "Current Students", "Forecast"};
		HashMap degreeStudentMap=readWriteCSVFile.readWriteStudentsDegreesMap();
		HashMap degreeForecastVector=readWriteCSVFile.readWriteDegreeData();
		if(degreeStudentMap!=null && degreeStudentMap.size()!=0){
			rowData=new Object[degreeStudentMap.size()][3];
			int i=0;
			for (Object key : degreeStudentMap.keySet()) {
				rowData[i][0]=key.toString();
				rowData[i][1]=degreeStudentMap.get(key);
				if(degreeForecastVector.get(key)!=null && (degreeForecastVector.get(key)).toString().trim().length()!=0){
					rowData[i][2]=degreeForecastVector.get(key);
				}else{
					rowData[i][2]="0";
				}
				i++;
			}
		}
		final JTable courseTable = new JTable(rowData, columnNames);
		courseTable.setRowSelectionAllowed(true);
		JScrollPane scroll = new JScrollPane(courseTable);
		scroll.setBounds(50, 150, 450, 150);
		tool.getPanel().add(scroll);
		
		final JLabel labels=new JLabel("Student Courses Reports");
		labels.setFont(new Font("Courier New", Font.ITALIC, 24));
		labels.setForeground(Color.WHITE);
		labels.setBounds(175,305,350,20);
		tool.getPanel().add(labels);
		
		Object rowsData[][]= { { "1", "2", "3"} };
		Object columnsNames[] = { "Student Id", "Courses Completed", "Course Pending"};
		HashMap degreeCoursesMap=readWriteCSVFile.readWriteStudentsCoursesMap();
		if(degreeCoursesMap!=null && degreeCoursesMap.size()!=0){
			rowsData=new Object[degreeCoursesMap.size()][3];
			int i=0;
			for (Object key : degreeCoursesMap.keySet()) {
				rowsData[i][0]=key.toString();
				rowsData[i][1]=degreeCoursesMap.get(key);
				if(Integer.parseInt((String)degreeCoursesMap.get(key))>10){
					rowsData[i][2]="0";
				}else{
					rowsData[i][2]=(10-Integer.parseInt((String)degreeCoursesMap.get(key)));
				}
				i++;
			}
		}
		final JTable courseTables = new JTable(rowsData, columnsNames);
		courseTables.setRowSelectionAllowed(true);
		scroll = new JScrollPane(courseTables);
		scroll.setBounds(50, 330, 450, 125);
		tool.getPanel().add(scroll);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(125,460,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,460,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}
	
	public static void facultyReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Faculty Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
		Vector schedule=readWriteCSVFile.schedule();
		Object rowData[][]= { { "1", "2", "3"} };
		Object columnNames[] = { "Faculty Name", "Load", "Over Load"};
		HashMap facultyMap=readWriteCSVFile.getFacultiesLoad();
		if(facultyMap!=null && facultyMap.size()!=0){
			rowData=new Object[facultyMap.size()][3];
			int i=0;
			for (Object key : facultyMap.keySet()) {
				rowData[i][0]=key.toString();
				rowData[i][1]=facultyMap.get(key);
				int hours=0;
				for(int index=0;index<schedule.size();index++){
					String scheduleData[]=(String[])schedule.get(index);
					if(scheduleData[2].equalsIgnoreCase(key.toString())){
						hours=hours+3;
					}
				}
				if(hours-(Integer.parseInt((String)facultyMap.get(key)))<=0){
					rowData[i][2]=0;
				}else{
					rowData[i][2]=(hours-(Integer.parseInt((String)facultyMap.get(key))));
				}
				i++;
			}
		}
		final JTable courseTable = new JTable(rowData, columnNames);
		courseTable.setRowSelectionAllowed(true);
		JScrollPane scroll = new JScrollPane(courseTable);
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
		exitButton.setBounds(125,400,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,400,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}	
	
	public static void scheduleReports(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Schedule Reports");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
		tool.setSchedule(readWriteCSVFile.schedule());
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
		exitButton.setBounds(125,400,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(325,400,100,30);
		tool.getPanel().add(cancelButton);
		
		tool.getPanel().repaint();
	}
}
