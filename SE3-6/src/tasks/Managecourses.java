package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
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

import menu.MenuScreen;
import service.HeaderScreen;
import service.Tool;
import au.com.bytecode.opencsv.CSVWriter;

public class Managecourses {
	public static void addCourse(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Course");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("Code");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField numberTextField = new JTextField();
		numberTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(numberTextField);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel descLabel = new JLabel("Description");
		descLabel.setBounds(75, 235, 100, 20);
		descLabel.setForeground(Color.WHITE);
		tool.getPanel().add(descLabel);
		
		final JTextField descriptionTextField = new JTextField();
		descriptionTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(descriptionTextField);
		
		JLabel offeredSpringLabel = new JLabel("Offered Spring");
		offeredSpringLabel.setBounds(60, 270, 100, 20);
		offeredSpringLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSpringLabel);
		
		final JTextField springTextField = new JTextField();
		springTextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(springTextField);
		
		JLabel capacityLabel = new JLabel("Capacity");
		capacityLabel.setBounds(60, 305, 100, 20);
		capacityLabel.setForeground(Color.WHITE);
		tool.getPanel().add(capacityLabel);
		
		final JTextField capacityTextField = new JTextField();
		capacityTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(capacityTextField);
		
		JLabel degreeLabel = new JLabel("Prequisite");
		degreeLabel.setBounds(300, 165, 100, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField preqTextField = new JTextField();
		preqTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(preqTextField);
		
		JLabel gradLabel = new JLabel("Teacher");
		gradLabel.setBounds(300, 200, 100, 20);
		gradLabel.setForeground(Color.WHITE);
		tool.getPanel().add(gradLabel);
		
		final JTextField teacherTextField = new JTextField();
		teacherTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(teacherTextField);
		
		JLabel offeredFallLabel = new JLabel("Offered Fall");
		offeredFallLabel.setBounds(300, 235, 100, 20);
		offeredFallLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredFallLabel);
		
		final JTextField fallTextField = new JTextField();
		fallTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(fallTextField);
		
		JLabel offeredSummerLabel = new JLabel("Offered Summer");
		offeredSummerLabel.setBounds(300, 270, 100, 20);
		offeredSummerLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSummerLabel);
		
		final JTextField summerTextField = new JTextField();
		summerTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(summerTextField);
		
		JLabel creditsLabel = new JLabel("Credits");
		creditsLabel.setBounds(300, 305, 100, 20);
		creditsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(creditsLabel);
		
		final JTextField creditTextField = new JTextField();
		creditTextField.setBounds(400, 303, 125, 25);
		tool.getPanel().add(creditTextField);
		
		
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
		
		
		final JButton addCourse = new JButton("Add Course");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberTextField!=null && numberTextField.getText().trim().length()!=0 && nameTextField!=null && nameTextField.getText().trim().length()!=0 
						&& descriptionTextField!=null && descriptionTextField.getText().trim().length()!=0 && springTextField!=null && springTextField.getText().trim().length()!=0 
						&& capacityTextField!=null && capacityTextField.getText().trim().length()!=0 && preqTextField!=null && preqTextField.getText().trim().length()!=0 
						&& teacherTextField!=null && teacherTextField.getText().trim().length()!=0 && fallTextField!=null && fallTextField.getText().trim().length()!=0 
						&& summerTextField!=null && summerTextField.getText().trim().length()!=0 && creditTextField!=null && creditTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Courses.csv",true));
						String [] record = {numberTextField.getText(),nameTextField.getText(),descriptionTextField.getText(),creditTextField.getText(),capacityTextField.getText(),fallTextField.getText(),springTextField.getText(),summerTextField.getText(),preqTextField.getText(),teacherTextField.getText()};
						writer.writeNext(record);
						writer.close();
						if(tool.getCourses()!=null && tool.getCourses().size()!=0){
							Vector courses=tool.getCourses();
							courses.add(record);
							tool.setCourses(courses);
						}else{
							Vector courses=new Vector();
							courses.add(record);
							tool.setCourses(courses);
						}
						Managecourses.viewCourse(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter course details");
				}
			}
		});
		addCourse.setBounds(325,375,150,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void editCourse(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Edit Course");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		String[] course=(String[])tool.getCourses().get(tool.getSelectedTableRowValue());
		
		JLabel numberLabel = new JLabel("Code");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField numberTextField = new JTextField();
		numberTextField.setText(course[0]);
		numberTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(numberTextField);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField nameTextField = new JTextField();
		nameTextField.setText(course[1]);
		nameTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(nameTextField);
		
		JLabel descLabel = new JLabel("Description");
		descLabel.setBounds(75, 235, 100, 20);
		descLabel.setForeground(Color.WHITE);
		tool.getPanel().add(descLabel);
		
		final JTextField descriptionTextField = new JTextField();
		descriptionTextField.setText(course[2]);
		descriptionTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(descriptionTextField);
		
		JLabel offeredSpringLabel = new JLabel("Offered Spring");		
		offeredSpringLabel.setBounds(60, 270, 100, 20);
		offeredSpringLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSpringLabel);
		
		final JTextField springTextField = new JTextField();
		springTextField.setText(course[6]);
		springTextField.setBounds(145, 268, 125, 25);
		tool.getPanel().add(springTextField);
		
		JLabel capacityLabel = new JLabel("Capacity");
		capacityLabel.setBounds(60, 305, 100, 20);
		capacityLabel.setForeground(Color.WHITE);
		tool.getPanel().add(capacityLabel);
		
		final JTextField capacityTextField = new JTextField();
		capacityTextField.setText(course[4]);
		capacityTextField.setBounds(145, 303, 125, 25);
		tool.getPanel().add(capacityTextField);
		
		JLabel degreeLabel = new JLabel("Prequisite");
		degreeLabel.setBounds(300, 165, 100, 20);
		degreeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(degreeLabel);
		
		final JTextField preqTextField = new JTextField();
		preqTextField.setText(course[8]);
		preqTextField.setBounds(400, 163, 125, 25);
		tool.getPanel().add(preqTextField);
		
		JLabel gradLabel = new JLabel("Teacher");
		gradLabel.setBounds(300, 200, 100, 20);
		gradLabel.setForeground(Color.WHITE);
		tool.getPanel().add(gradLabel);
		
		final JTextField teacherTextField = new JTextField();
		teacherTextField.setText(course[9]);
		teacherTextField.setBounds(400, 198, 125, 25);
		tool.getPanel().add(teacherTextField);
		
		JLabel offeredFallLabel = new JLabel("Offered Fall");
		offeredFallLabel.setBounds(300, 235, 100, 20);
		offeredFallLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredFallLabel);
		
		final JTextField fallTextField = new JTextField();
		fallTextField.setText(course[5]);
		fallTextField.setBounds(400, 233, 125, 25);
		tool.getPanel().add(fallTextField);
		
		JLabel offeredSummerLabel = new JLabel("Offered Summer");
		offeredSummerLabel.setBounds(300, 270, 100, 20);
		offeredSummerLabel.setForeground(Color.WHITE);
		tool.getPanel().add(offeredSummerLabel);
		
		final JTextField summerTextField = new JTextField();
		summerTextField.setText(course[7]);
		summerTextField.setBounds(400, 268, 125, 25);
		tool.getPanel().add(summerTextField);
		
		JLabel creditsLabel = new JLabel("Credits");
		creditsLabel.setBounds(300, 305, 100, 20);
		creditsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(creditsLabel);
		
		final JTextField creditTextField = new JTextField();
		creditTextField.setText(course[3]);
		creditTextField.setBounds(400, 303, 125, 25);
		tool.getPanel().add(creditTextField);
		
		
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
		
		
		final JButton addCourse = new JButton("Update Course");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberTextField!=null && numberTextField.getText().trim().length()!=0 && nameTextField!=null && nameTextField.getText().trim().length()!=0 
						&& descriptionTextField!=null && descriptionTextField.getText().trim().length()!=0 && springTextField!=null && springTextField.getText().trim().length()!=0 
						&& capacityTextField!=null && capacityTextField.getText().trim().length()!=0 && preqTextField!=null && preqTextField.getText().trim().length()!=0 
						&& teacherTextField!=null && teacherTextField.getText().trim().length()!=0 && fallTextField!=null && fallTextField.getText().trim().length()!=0 
						&& summerTextField!=null && summerTextField.getText().trim().length()!=0 && creditTextField!=null && creditTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Courses.csv"));
						Vector courses=tool.getCourses();
						Iterator iterator=courses.iterator();
						Vector updateCourses=new Vector();
						int i=0;
						while(iterator.hasNext()){
							String records[]=(String[])iterator.next();
							if(i==(tool.getSelectedTableRowValue())){
								String [] record = {numberTextField.getText(),nameTextField.getText(),descriptionTextField.getText(),creditTextField.getText(),capacityTextField.getText(),fallTextField.getText(),springTextField.getText(),summerTextField.getText(),preqTextField.getText(),teacherTextField.getText()};
								writer.writeNext(record);
								updateCourses.add(record);
							}else{
								writer.writeNext(records);
								updateCourses.add(records);
							}
							i++;
						}						
						writer.close();
						tool.setSelectedTableRowValue(-1);
						tool.setCourses(updateCourses);						
						Managecourses.viewCourse(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter course details");
				}
			}
		});
		addCourse.setBounds(325,375,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void viewCourse(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Courses");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3", "4","5", "6", "7", "8","9", "10"},{ "1", "2", "3", "4","5", "6", "7", "8","9", "10"} };;
		Object columnNames[] = { "Course Code", "Course Name", "Descrption", "Course Hours","Course Cap","Offered Fall", "Offered Spring", "Offered Summer", "Prereqs","Teachers"};
		if(tool.getCourses()!=null && tool.getCourses().size()!=0){
			rowData=new Object[tool.getCourses().size()][10];
			for(int i=0;i<tool.getCourses().size();i++){
				String split[]=((String[])tool.getCourses().get(i));
				if(split!=null && split.length>=10){
					rowData[i]=split;
				}
			}
		}
		final JTable courseTable = new JTable(rowData, columnNames);
		courseTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = courseTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(courseTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(courseTable.getSelectedRow());		        	
		        }
	    	}
	    });
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
		
		JButton addButton = new JButton("Add Course");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourse(tool);
			}
		});
		addButton.setBounds(50,400,150,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Course");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						editCourse(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
				}						
			}
		});
		updateButton.setBounds(205,400,170,30);
		tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("Delete");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						Vector courses=tool.getCourses();
						courses.remove(tool.getSelectedTableRowValue());
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Courses.csv"));
						Iterator iterator=courses.iterator();
						while(iterator.hasNext()){
							String[] record=(String[])iterator.next();
							writer.writeNext(record);
						}			
						writer.close();
						tool.setCourses(courses);
						tool.setSelectedTableRowValue(-1);
						Managecourses.viewCourse(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(deleteButton, "Please you should select one row only");
				}
			}
		});
		deleteButton.setBounds(380,400,100,30);
		tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
}
