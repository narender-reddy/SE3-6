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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import au.com.bytecode.opencsv.CSVWriter;
import menu.MenuScreen;
import service.HeaderScreen;
import service.ReadWriteCSVFile;
import service.Tool;

public class Managefaculties {
	public static void addFaculty(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Faculty");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("LastName");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField lastNameTextField = new JTextField();
		lastNameTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(lastNameTextField);
		
		JLabel nameLabel = new JLabel("FirstName");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField firstNameTextField = new JTextField();
		firstNameTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(firstNameTextField);
		
		JLabel descLabel = new JLabel("Grad School");
		descLabel.setBounds(75, 235, 100, 20);
		descLabel.setForeground(Color.WHITE);
		tool.getPanel().add(descLabel);
		
		final JTextField gradSchoolTextField = new JTextField();
		gradSchoolTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(gradSchoolTextField);
		
		JLabel offeredSpringLabel = new JLabel("Degree");
		offeredSpringLabel.setBounds(60, 270, 100, 20);
		offeredSpringLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSpringLabel);
		
		final JTextField degreeTextField = new JTextField();
		degreeTextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(degreeTextField);
		
		JLabel capacityLabel = new JLabel("Title");
		capacityLabel.setBounds(60, 305, 100, 20);
		capacityLabel.setForeground(Color.WHITE);
		tool.getPanel().add(capacityLabel);
		
		final JTextField titleTextField = new JTextField();
		titleTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(titleTextField);
		
		JLabel degreeLabel = new JLabel("DaysToTeach");
		degreeLabel.setBounds(300, 165, 100, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField dayToTeachTextField = new JTextField();
		dayToTeachTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(dayToTeachTextField);
		
		JLabel gradLabel = new JLabel("MaxLoadFall");
		gradLabel.setBounds(300, 200, 100, 20);
		gradLabel.setForeground(Color.WHITE);
		tool.getPanel().add(gradLabel);
		
		final JTextField loadTextField = new JTextField();
		loadTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(loadTextField);
		
		JLabel offeredFallLabel = new JLabel("MaxLoadSpring");
		offeredFallLabel.setBounds(300, 235, 100, 20);
		offeredFallLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredFallLabel);
		
		final JTextField loadSpringTextField = new JTextField();
		loadSpringTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(loadSpringTextField);
		
		JLabel offeredSummerLabel = new JLabel("MaxLoadSummer");
		offeredSummerLabel.setBounds(295, 270, 100, 20);
		offeredSummerLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSummerLabel);
		
		final JTextField loadSumTextField = new JTextField();
		loadSumTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(loadSumTextField);
				
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,375,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(200,375,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton addCourse = new JButton("Add Faculty");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lastNameTextField!=null && lastNameTextField.getText().trim().length()!=0 && firstNameTextField!=null && firstNameTextField.getText().trim().length()!=0 
						&& gradSchoolTextField!=null && gradSchoolTextField.getText().trim().length()!=0 && degreeTextField!=null && degreeTextField.getText().trim().length()!=0 
						&& titleTextField!=null && titleTextField.getText().trim().length()!=0 && dayToTeachTextField!=null && dayToTeachTextField.getText().trim().length()!=0 
						&& loadTextField!=null && loadTextField.getText().trim().length()!=0 && loadSpringTextField!=null && loadSpringTextField.getText().trim().length()!=0 
						&& loadSumTextField!=null && loadSumTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Faculty.csv",true));
						String [] record = {lastNameTextField.getText(),firstNameTextField.getText(),gradSchoolTextField.getText(),degreeTextField.getText(),titleTextField.getText(),dayToTeachTextField.getText(),loadTextField.getText(),loadSpringTextField.getText(),loadSumTextField.getText()};
						writer.writeNext(record);
						writer.close();
						if(tool.getFaculty()!=null && tool.getFaculty().size()!=0){
							Vector faculty=tool.getFaculty();
							faculty.add(record);
							tool.setCourses(faculty);
						}else{
							Vector faculty=new Vector();
							faculty.add(record);
							tool.setCourses(faculty);
						}
						Managefaculties.viewFaculty(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter course details");
				}
			}
		});
		addCourse.setBounds(325,375,175,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void editFaculty(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Update Faculty");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		String[] faculty=(String[])tool.getFaculty().get(tool.getSelectedTableRowValue());
		
		JLabel numberLabel = new JLabel("LastName");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField lastNameTextField = new JTextField();
		lastNameTextField.setText(faculty[0]);
		lastNameTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(lastNameTextField);
		
		JLabel nameLabel = new JLabel("FirstName");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField firstNameTextField = new JTextField();
		firstNameTextField.setText(faculty[1]);
		firstNameTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(firstNameTextField);
		
		JLabel descLabel = new JLabel("Grad School");
		descLabel.setBounds(75, 235, 100, 20);
		descLabel.setForeground(Color.WHITE);
		tool.getPanel().add(descLabel);
		
		final JTextField gradSchoolTextField = new JTextField();
		gradSchoolTextField.setText(faculty[2]);
		gradSchoolTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(gradSchoolTextField);
		
		JLabel offeredSpringLabel = new JLabel("Degree");
		offeredSpringLabel.setBounds(60, 270, 100, 20);
		offeredSpringLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSpringLabel);
		
		final JTextField degreeTextField = new JTextField();
		degreeTextField.setText(faculty[3]);
		degreeTextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(degreeTextField);
		
		JLabel capacityLabel = new JLabel("Title");
		capacityLabel.setBounds(60, 305, 100, 20);
		capacityLabel.setForeground(Color.WHITE);
		tool.getPanel().add(capacityLabel);
		
		final JTextField titleTextField = new JTextField();
		titleTextField.setText(faculty[4]);
		titleTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(titleTextField);
		
		JLabel degreeLabel = new JLabel("DaysToTeach");
		degreeLabel.setBounds(300, 165, 100, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField dayToTeachTextField = new JTextField();
		dayToTeachTextField.setText(faculty[5]);
		dayToTeachTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(dayToTeachTextField);
		
		JLabel gradLabel = new JLabel("MaxLoadFall");
		gradLabel.setBounds(300, 200, 100, 20);
		gradLabel.setForeground(Color.WHITE);
		tool.getPanel().add(gradLabel);
		
		final JTextField loadTextField = new JTextField();
		loadTextField.setText(faculty[6]);
		loadTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(loadTextField);
		
		JLabel offeredFallLabel = new JLabel("MaxLoadSpring");
		offeredFallLabel.setBounds(300, 235, 100, 20);
		offeredFallLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredFallLabel);
		
		final JTextField loadSpringTextField = new JTextField();
		loadSpringTextField.setText(faculty[7]);
		loadSpringTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(loadSpringTextField);
		
		JLabel offeredSummerLabel = new JLabel("MaxLoadSummer");
		offeredSummerLabel.setBounds(295, 270, 100, 20);
		offeredSummerLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSummerLabel);
		
		final JTextField loadSumTextField = new JTextField();
		loadSumTextField.setText(faculty[8]);
		loadSumTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(loadSumTextField);
				
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,375,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(200,375,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton addCourse = new JButton("Update Faculty");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lastNameTextField!=null && lastNameTextField.getText().trim().length()!=0 && firstNameTextField!=null && firstNameTextField.getText().trim().length()!=0 
						&& gradSchoolTextField!=null && gradSchoolTextField.getText().trim().length()!=0 && degreeTextField!=null && degreeTextField.getText().trim().length()!=0 
						&& titleTextField!=null && titleTextField.getText().trim().length()!=0 && dayToTeachTextField!=null && dayToTeachTextField.getText().trim().length()!=0 
						&& loadTextField!=null && loadTextField.getText().trim().length()!=0 && loadSpringTextField!=null && loadSpringTextField.getText().trim().length()!=0 
						&& loadSumTextField!=null && loadSumTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Faculty.csv"));
						Vector faculty=tool.getFaculty();
						Iterator iterator=faculty.iterator();
						Vector updateFaculties=new Vector();
						int i=0;
						while(iterator.hasNext()){
							String records[]=(String[])iterator.next();
							if(i==(tool.getSelectedTableRowValue())){
								String [] record = {lastNameTextField.getText(),firstNameTextField.getText(),gradSchoolTextField.getText(),degreeTextField.getText(),titleTextField.getText(),dayToTeachTextField.getText(),loadTextField.getText(),loadSpringTextField.getText(),loadSumTextField.getText()};
								writer.writeNext(record);
								updateFaculties.add(record);
							}else{
								writer.writeNext(records);
								updateFaculties.add(records);
							}
							i++;
						}						
						writer.close();
						tool.setSelectedTableRowValue(-1);
						tool.setFaculty(updateFaculties);
						Managefaculties.viewFaculty(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter course details");
				}
			}
		});
		addCourse.setBounds(315,375,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void viewFaculty(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Faculty");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(175,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3", "4","5", "6", "7", "8","9"},{ "1", "2", "3", "4","5", "6", "7", "8","9"} };
		Object columnNames[] = { "Last Name", "First Name", "Grad School", "Degree", "Title", "Days","MaxLoadFall","MaxLoadSpring","MaxLoadSummer"};
		if(tool.getFaculty()!=null && tool.getFaculty().size()!=0){
			rowData=new Object[tool.getFaculty().size()][9];
			for(int i=0;i<tool.getFaculty().size();i++){
				String split[]=((String[])tool.getFaculty().get(i));
				if(split!=null && split.length>=9){
					rowData[i]=split;
				}
			}
		}
		final JTable facultyTable = new JTable(rowData, columnNames);
		facultyTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = facultyTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(facultyTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(facultyTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(facultyTable);
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
		exitButton.setBounds(150,450,80,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(250,450,100,30);
		tool.getPanel().add(cancelButton);		
		
		JButton addButton = new JButton("Add Faculty");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFaculty(tool);
			}
		});
		addButton.setBounds(50,400,170,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Faculty");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						editFaculty(tool);	
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
				}
			}
		});
		updateButton.setBounds(225,400,170,30);
		tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("Delete");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						Vector faculties=tool.getFaculty();
						faculties.remove(tool.getSelectedTableRowValue());
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Faculty.csv"));
						Iterator iterator=faculties.iterator();
						while(iterator.hasNext()){
							String[] record=(String[])iterator.next();
							writer.writeNext(record);
						}			
						writer.close();
						tool.setFaculty(faculties);
						tool.setSelectedTableRowValue(-1);
						Managefaculties.viewFaculty(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(deleteButton, "Please you should select one row only");
				}		
			}
		});
		deleteButton.setBounds(400,400,100,30);
		tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
}
