package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
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

public class ManageStudents {
	public static void addStudent(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Student");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("ID");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField idTextField = new JTextField();
		idTextField.setBounds(155, 163, 125, 25);
		tool.getPanel().add(idTextField);
		
		JLabel nameLabel = new JLabel("Course Code");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField ccodeTextField = new JTextField();
		ccodeTextField.setBounds(155, 198, 125, 25);
		tool.getPanel().add(ccodeTextField);
		
		JLabel creditsLabel = new JLabel("Course Name");
		creditsLabel.setBounds(75, 235, 100, 20);
		creditsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(creditsLabel);
		
		final JTextField ccName = new JTextField();
		ccName.setBounds(155, 233, 125, 25);
		tool.getPanel().add(ccName);
		
		JLabel degreeLabel = new JLabel("Semester");
		degreeLabel.setBounds(295, 165, 100, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField semTextField = new JTextField();
		semTextField.setBounds(415, 163, 100, 25);
		tool.getPanel().add(semTextField);
		
		degreeLabel = new JLabel("Grade");
		degreeLabel.setBounds(295, 200, 110, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField gradeTextField = new JTextField();
		gradeTextField.setBounds(415, 198, 100, 25);
		tool.getPanel().add(gradeTextField);
		
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
		
		
		final  JButton addCourse = new JButton("Add Student");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTextField!=null && idTextField.getText().trim().length()!=0 && ccodeTextField!=null && ccodeTextField.getText().trim().length()!=0 
						&& ccName!=null && ccName.getText().trim().length()!=0 && semTextField!=null && semTextField.getText().trim().length()!=0 
						&& gradeTextField!=null && gradeTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\StudentCourses.csv",true));
						String [] record = {idTextField.getText(),ccodeTextField.getText(),ccName.getText(),semTextField.getText(),gradeTextField.getText()};
						writer.writeNext(record);
						writer.close();
						if(tool.getStudentsCoursesVector()!=null && tool.getStudentsCoursesVector().size()!=0){
							Vector courses=tool.getStudentsCoursesVector();
							courses.add(record);
							tool.setStudentsCoursesVector(courses);
						}else{
							Vector courses=new Vector();
							courses.add(record);
							tool.setStudentsCoursesVector(courses);
						}
						ManageStudents.viewStudents(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter course details");
				}
			}
		});
		addCourse.setBounds(325,300,175,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void editStudent(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Update Student");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		String[] student=(String[])tool.getStudentsCoursesVector().get(tool.getSelectedTableRowValue());
		
		JLabel numberLabel = new JLabel("ID");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField idTextField = new JTextField();
		idTextField.setText(student[0]);
		idTextField.setBounds(155, 163, 125, 25);
		tool.getPanel().add(idTextField);
		
		JLabel nameLabel = new JLabel("Course Code");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField ccodeTextField = new JTextField();
		ccodeTextField.setText(student[1]);
		ccodeTextField.setBounds(155, 198, 125, 25);
		tool.getPanel().add(ccodeTextField);
		
		JLabel creditsLabel = new JLabel("Course Name");
		creditsLabel.setBounds(75, 235, 100, 20);
		creditsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(creditsLabel);
		
		final JTextField ccName = new JTextField();
		ccName.setText(student[2]);
		ccName.setBounds(155, 233, 125, 25);
		tool.getPanel().add(ccName);
		
		JLabel degreeLabel = new JLabel("Semester");
		degreeLabel.setBounds(295, 165, 100, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField semTextField = new JTextField();
		semTextField.setText(student[3]);
		semTextField.setBounds(415, 163, 100, 25);
		tool.getPanel().add(semTextField);
		
		degreeLabel = new JLabel("Grade");
		degreeLabel.setBounds(295, 200, 110, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField gradeTextField = new JTextField();
		gradeTextField.setText(student[4]);
		gradeTextField.setBounds(415, 198, 100, 25);
		tool.getPanel().add(gradeTextField);
		
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
		
		
		final JButton addCourse = new JButton("Update Student");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTextField!=null && idTextField.getText().trim().length()!=0 && ccodeTextField!=null && ccodeTextField.getText().trim().length()!=0 
						&& ccName!=null && ccName.getText().trim().length()!=0 && semTextField!=null && semTextField.getText().trim().length()!=0 
						&& gradeTextField!=null && gradeTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\StudentCourses.csv"));
						Vector courses=tool.getStudentsCoursesVector();
						Iterator iterator=courses.iterator();
						Vector updateStudentCourses=new Vector();
						int i=0;
						while(iterator.hasNext()){
							String records[]=(String[])iterator.next();
							if(i==(tool.getSelectedTableRowValue())){
								String [] record = {idTextField.getText(),ccodeTextField.getText(),ccName.getText(),semTextField.getText(),gradeTextField.getText()};
								writer.writeNext(record);
								updateStudentCourses.add(record);
							}else{
								writer.writeNext(records);
								updateStudentCourses.add(records);
							}
							i++;
						}						
						writer.close();
						tool.setSelectedTableRowValue(-1);
						tool.setStudentsCoursesVector(updateStudentCourses);
						ManageStudents.viewStudents(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter course details");
				}
			}
		});
		addCourse.setBounds(325,300,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void viewStudents(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Students");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3", "4"},{ "1", "2", "3", "4"} };
		Object columnNames[] = { "Student ID", "Course Code", "Course Name", "Semester"};
		if(tool.getStudentsCourses()!=null && tool.getStudentsCourses().size()!=0){
			rowData=new Object[tool.getStudentsCoursesVector().size()][4];
			int i=0;
			for (Object key : tool.getStudentsCourses().keySet()) {
				ArrayList studentCourses=(ArrayList)tool.getStudentsCourses().get(key);
				if(studentCourses!=null && studentCourses.size()!=0){
					for(int in=0;in<studentCourses.size();in++){
						String split[]=((String[])studentCourses.get(in));
						if(i<=(tool.getStudentsCoursesVector().size()-1) && split!=null && split.length>=4){
							System.out.println(i);
							rowData[i]=split;
							i++;
						}
					}
				}
			}
		}
		final JTable studentTable = new JTable(rowData, columnNames);
		studentTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = studentTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(studentTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(studentTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(studentTable);
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
		
		JButton addButton = new JButton("Add Student");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent(tool);
			}
		});
		addButton.setBounds(50,400,170,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Student");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						editStudent(tool);
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
						Vector studentCourses=tool.getStudentsCoursesVector();
						studentCourses.remove(tool.getSelectedTableRowValue());
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\StudentCourses.csv"));
						Iterator iterator=studentCourses.iterator();
						while(iterator.hasNext()){
							String[] record=(String[])iterator.next();
							writer.writeNext(record);
						}			
						writer.close();
						ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
						tool.setStudentsCourses(readWriteCSVFile.readStudentData());
						tool.setSelectedTableRowValue(-1);
						ManageStudents.viewStudents(tool);
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
