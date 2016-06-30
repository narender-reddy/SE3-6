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

public class Managedegreeplans {
	public static void addDegree(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Degree Plan");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,120,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("DegreeCode");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField degreeCodeTextField = new JTextField();
		degreeCodeTextField.setBounds(175, 163, 200, 25);
		tool.getPanel().add(degreeCodeTextField);
		
		JLabel nameLabel = new JLabel("Grad School");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField gradSchoolTextField = new JTextField();
		gradSchoolTextField.setBounds(175, 198, 200, 25);
		tool.getPanel().add(gradSchoolTextField);
		
		JLabel creditsLabel = new JLabel("DegreeName");
		creditsLabel.setBounds(75, 235, 100, 20);
		creditsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(creditsLabel);
		
		final JTextField degreeNameTextField = new JTextField();
		degreeNameTextField.setBounds(175, 233, 200, 25);
		tool.getPanel().add(degreeNameTextField);
		
		JLabel forecastLabel = new JLabel("Forecast");
		forecastLabel.setBounds(75, 270, 100, 20);
		forecastLabel.setForeground(Color.WHITE);
		tool.getPanel().add(forecastLabel);
		
		final JTextField forecastTextField = new JTextField();
		forecastTextField.setBounds(175, 268, 200, 25);
		tool.getPanel().add(forecastTextField);	
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(75,440,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(190,440,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton addCourse = new JButton("Add Degree Plan");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(degreeCodeTextField!=null && degreeCodeTextField.getText().trim().length()!=0 && gradSchoolTextField!=null && gradSchoolTextField.getText().trim().length()!=0 
						&& forecastTextField!=null && forecastTextField.getText().trim().length()!=0 && degreeNameTextField!=null && degreeNameTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Degrees.csv",true));
						String [] record = {degreeCodeTextField.getText(),gradSchoolTextField.getText(),forecastTextField.getText(),degreeNameTextField.getText()};
						writer.writeNext(record);
						writer.close();
						if(tool.getDegrees()!=null && tool.getDegrees().size()!=0){
							Vector degrees=tool.getDegrees();
							degrees.add(record);
							tool.setDegrees(degrees);
						}else{
							Vector degrees=new Vector();
							degrees.add(record);
							tool.setDegrees(degrees);
						}
						Managedegreeplans.viewDegreePlan(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}					
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter degree plan details");
				}
			}
		});
		addCourse.setBounds(315,440,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void addDegreePlan(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Degree Plan");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,120,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("DegreeCode");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField degreeCodeTextField = new JTextField();
		degreeCodeTextField.setBounds(175, 163, 200, 25);
		tool.getPanel().add(degreeCodeTextField);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(75, 200, 100, 20);
		descriptionLabel.setForeground(Color.WHITE);
		tool.getPanel().add(descriptionLabel);
		
		final JTextField descriptionTextField = new JTextField();
		descriptionTextField.setBounds(175, 198, 200, 25);
		tool.getPanel().add(descriptionTextField);
		
		JLabel hourLabel = new JLabel("Hours");
		hourLabel.setBounds(75, 235, 100, 20);
		hourLabel.setForeground(Color.WHITE);
		tool.getPanel().add(hourLabel);
		
		final JTextField hourTextField = new JTextField();
		hourTextField.setBounds(175, 233, 200, 25);
		tool.getPanel().add(hourTextField);
		
		JLabel typeLabel = new JLabel("Type");
		typeLabel.setBounds(75, 270, 100, 20);
		typeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(typeLabel);
		
		final JTextField typeTextField = new JTextField();
		typeTextField.setBounds(175, 268, 200, 25);
		tool.getPanel().add(typeTextField);
		
		JLabel coursesLabel = new JLabel("Courses");
		coursesLabel.setBounds(75, 305, 100, 20);
		coursesLabel.setForeground(Color.WHITE);
		tool.getPanel().add(coursesLabel);
		
		final JTextField coursesTextField = new JTextField();
		coursesTextField.setBounds(175, 303, 200, 25);
		tool.getPanel().add(coursesTextField);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(75,440,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(190,440,100,30);
		tool.getPanel().add(cancelButton);
		
		
		final JButton addCourse = new JButton("Add Degree Plan");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(degreeCodeTextField!=null && degreeCodeTextField.getText().trim().length()!=0 && descriptionTextField!=null && descriptionTextField.getText().trim().length()!=0 
						&& hourTextField!=null && hourTextField.getText().trim().length()!=0 && typeTextField!=null && typeTextField.getText().trim().length()!=0 
						&& coursesTextField!=null && coursesTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\DegreePlan.csv",true));
						String [] record = {degreeCodeTextField.getText(),descriptionTextField.getText(),hourTextField.getText(),typeTextField.getText(),coursesTextField.getText()};
						writer.writeNext(record);
						writer.close();
						if(tool.getDegreePlan()!=null && tool.getDegreePlan().size()!=0){
							Vector degrees=tool.getDegreePlan();
							degrees.add(record);
							tool.setDegreePlan(degrees);
						}else{
							Vector degrees=new Vector();
							degrees.add(record);
							tool.setDegreePlan(degrees);
						}
						Managedegreeplans.viewDegreePlanReqs(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addCourse, "Please enter degree plan details");
				}
			}
		});
		addCourse.setBounds(315,440,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void editDegree(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Update Degree Plan");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(175,120,275,20);
		tool.getPanel().add(label);
		
		String[] degree=null;
		Vector degreePlans=tool.getDegreePlan();
		Iterator iterator=degreePlans.iterator();
		int count=0;
		while(iterator.hasNext()){
			String records[]=(String[])iterator.next();
			if(records!=null && records[0].equalsIgnoreCase(tool.getDegreeCode())){
				if(tool.getSelectedTableRowValue()==count){
					degree = records;
				}
				count++;
			}
		}	
		
		JLabel numberLabel = new JLabel("DegreeCode");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField degreeCodeTextField = new JTextField();
		degreeCodeTextField.setText(degree[0]);
		degreeCodeTextField.setBounds(175, 163, 200, 25);
		tool.getPanel().add(degreeCodeTextField);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(75, 200, 100, 20);
		descriptionLabel.setForeground(Color.WHITE);
		tool.getPanel().add(descriptionLabel);
		
		final JTextField descriptionTextField = new JTextField();
		descriptionTextField.setText(degree[1]);
		descriptionTextField.setBounds(175, 198, 200, 25);
		tool.getPanel().add(descriptionTextField);
		
		JLabel hourLabel = new JLabel("Hours");
		hourLabel.setBounds(75, 235, 100, 20);
		hourLabel.setForeground(Color.WHITE);
		tool.getPanel().add(hourLabel);
		
		final JTextField hourTextField = new JTextField();
		hourTextField.setText(degree[2]);
		hourTextField.setBounds(175, 233, 200, 25);
		tool.getPanel().add(hourTextField);
		
		JLabel typeLabel = new JLabel("Type");
		typeLabel.setBounds(75, 270, 100, 20);
		typeLabel.setForeground(Color.WHITE);
		tool.getPanel().add(typeLabel);
		
		final JTextField typeTextField = new JTextField();
		typeTextField.setText(degree[3]);
		typeTextField.setBounds(175, 268, 200, 25);
		tool.getPanel().add(typeTextField);
		
		JLabel coursesLabel = new JLabel("Courses");
		coursesLabel.setBounds(75, 303, 305, 20);
		coursesLabel.setForeground(Color.WHITE);
		tool.getPanel().add(coursesLabel);
		
		final JTextField coursesTextField = new JTextField();
		coursesTextField.setText(degree[4]);
		coursesTextField.setBounds(175, 303, 200, 25);
		tool.getPanel().add(coursesTextField);			
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(75,350,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(190,350,100,30);
		tool.getPanel().add(cancelButton);
		
		
		JButton addCourse = new JButton("Edit Degree Plan");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(degreeCodeTextField!=null && degreeCodeTextField.getText().trim().length()!=0 && descriptionTextField!=null && descriptionTextField.getText().trim().length()!=0 
						&& hourTextField!=null && hourTextField.getText().trim().length()!=0 && typeTextField!=null && typeTextField.getText().trim().length()!=0 
						&& coursesTextField!=null && coursesTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\DegreePlan.csv"));
						Vector degreePlans=tool.getDegreePlan();
						Iterator iterator=degreePlans.iterator();
						Vector updateDegreePlans=new Vector();
						int count=0;
						while(iterator.hasNext()){
							String records[]=(String[])iterator.next();
							if(records!=null && records[0].equalsIgnoreCase(tool.getDegreeCode())){
								if(tool.getSelectedTableRowValue()==count){
									String [] record = {degreeCodeTextField.getText(),descriptionTextField.getText(),hourTextField.getText(),typeTextField.getText(),coursesTextField.getText()};
									writer.writeNext(record);
									updateDegreePlans.add(record);
								}else{
									writer.writeNext(records);
									updateDegreePlans.add(records);
								}
								count++;
							}else{
								writer.writeNext(records);
								updateDegreePlans.add(records);
							}
						}						
						writer.close();
						tool.setSelectedTableRowValue(-1);
						tool.setDegreePlan(updateDegreePlans);
						Managedegreeplans.viewDegreePlanReqs(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		});
		addCourse.setBounds(305,350,215,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
	
	public static void viewDegreePlan(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Degree Plan");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,250,20);
		tool.getPanel().add(label);
		
//		Object rowData[][]= { { "1", "2", "3", "4"},{ "1", "2", "3", "4"} };
//		Object columnNames[] = { "Degree Code", "Grad School", "Degree Name", "Forecast"};
//		if(tool.getDegrees()!=null && tool.getDegrees().size()!=0){
//			rowData=new Object[tool.getDegrees().size()][4];
//			for(int i=0;i<tool.getDegrees().size();i++){
//				String split[]=((String[])tool.getDegrees().get(i));
//				if(split!=null && split.length>=3){
//					rowData[i]=split;
//				}
//			}
//		}
//		final JTable degreeTable = new JTable(rowData, columnNames);
//		degreeTable.setRowSelectionAllowed(true);
//	    ListSelectionModel cellSelectionModel = degreeTable.getSelectionModel();
//	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
//	    	public void valueChanged(ListSelectionEvent e) {
//	    		if(degreeTable.getSelectedRow() > -1){
//		        	tool.setSelectedTableRowValue(degreeTable.getSelectedRow());		        	
//		        }
//	    	}
//	    });
//		JScrollPane scroll = new JScrollPane(degreeTable);
//		scroll.setBounds(50, 150, 450, 225);
//		tool.getPanel().add(scroll);
		
		if(tool.getDegrees()!=null && tool.getDegrees().size()!=0){
			for(int i=0;i<tool.getDegrees().size();i++){
				final String split[]=((String[])tool.getDegrees().get(i));
				JButton degreeButton = new JButton(split[0]);
				degreeButton.setBackground(Color.GREEN);		
				degreeButton.setFont(new Font("Courier New", Font.PLAIN, 18));
				degreeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tool.setDegreeCode(split[0]);
						Managedegreeplans.viewDegreePlanReqs(tool);
					}
				});
				degreeButton.setBounds(200,175+(i*30),200,30);
				tool.getPanel().add(degreeButton);
			}
		}
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(200,450,80,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(300,450,100,30);
		tool.getPanel().add(cancelButton);		
		
		JButton addButton = new JButton("Add Degree");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDegree(tool);
			}
		});
		addButton.setBounds(225,400,150,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Degree");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					editDegree(tool);	
				}else{
					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
				}
			}
		});
		updateButton.setBounds(205,400,170,30);
		//tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("Delete");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						Vector degrees=tool.getDegrees();
						degrees.remove(tool.getSelectedTableRowValue());
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Degrees.csv"));
						Iterator iterator=degrees.iterator();
						while(iterator.hasNext()){
							String[] record=(String[])iterator.next();
							writer.writeNext(record);
						}			
						writer.close();
						tool.setDegrees(degrees);
						tool.setSelectedTableRowValue(-1);
						Managedegreeplans.viewDegreePlan(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(deleteButton, "Please you should select one row only");
				}		
			}
		});
		deleteButton.setBounds(380,400,100,30);
		//tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
	
	public static void viewDegreePlanReqs(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Degree Plan");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3", "4", "5"},{ "1", "2", "3", "4", "5"} };
		Object columnNames[] = { "Degree Code", "Description", "Hours", "Type", "Courses"};
		if(tool.getDegreePlan()!=null && tool.getDegreePlan().size()!=0){
			rowData=new Object[tool.getDegreePlan().size()][5];
			int count=0;
			for(int i=0;i<tool.getDegreePlan().size();i++){
				String split[]=((String[])tool.getDegreePlan().get(i));
				if(split!=null && split[0].equalsIgnoreCase(tool.getDegreeCode()) && split.length>=5){
					rowData[count]=split;
					count++;
				}
			}
		}
		final JTable degreeTable = new JTable(rowData, columnNames);
		degreeTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = degreeTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(degreeTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(degreeTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(degreeTable);
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
		exitButton.setBounds(200,450,80,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(300,450,100,30);
		tool.getPanel().add(cancelButton);		
		
		JButton addButton = new JButton("Add Degree Plan");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDegreePlan(tool);
			}
		});
		addButton.setBounds(35,400,200,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Degree Plan");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					editDegree(tool);	
				}else{
					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
				}
			}
		});
		updateButton.setBounds(250,400,215,30);
		tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("Delete");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						Vector degreePlans=tool.getDegreePlan();
						Vector updateDegreePlans=new Vector();
						degreePlans.remove(tool.getSelectedTableRowValue());
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\DegreePlan.csv"));
						Iterator iterator=degreePlans.iterator();
						int count=0;
						while(iterator.hasNext()){
							String[] record=(String[])iterator.next();
							if(record!=null && record[0].equalsIgnoreCase(tool.getDegreeCode())){
								if(tool.getSelectedTableRowValue()!=count){
									writer.writeNext(record);
									updateDegreePlans.add(record);
								}								
								count++;
							}else{
								writer.writeNext(record);
								updateDegreePlans.add(record);
							}
						}			
						writer.close();
						tool.setDegreePlan(updateDegreePlans);
						Managedegreeplans.viewDegreePlanReqs(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(deleteButton, "Please you should select one row only");
				}		
			}
		});
		deleteButton.setBounds(475,400,100,30);
		tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
}
