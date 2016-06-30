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

import au.com.bytecode.opencsv.CSVWriter;
import menu.MenuScreen;
import service.HeaderScreen;
import service.Tool;

public class ManageSemesters {
	public static void addSemester(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Add Semester");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		JLabel numberLabel = new JLabel("Semester");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField semesterTextField = new JTextField();
		semesterTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(semesterTextField);
		
		JLabel nameLabel = new JLabel("Start Date");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField startDateTextField = new JTextField();
		startDateTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(startDateTextField);
		
		JLabel creditsLabel = new JLabel("End Date");
		creditsLabel.setBounds(75, 235, 100, 20);
		creditsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(creditsLabel);
		
		final JTextField endDateTextField = new JTextField();
		endDateTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(endDateTextField);
		
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
		
		
		final JButton addCourse = new JButton("Add Semester");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(semesterTextField!=null && semesterTextField.getText().trim().length()!=0 && startDateTextField!=null && startDateTextField.getText().trim().length()!=0 
						&& endDateTextField!=null && endDateTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Semesters.csv",true));
						String [] record = {semesterTextField.getText(),startDateTextField.getText(),endDateTextField.getText()};
						writer.writeNext(record);
						writer.close();
						if(tool.getSemesters()!=null && tool.getSemesters().size()!=0){
							Vector semesters=tool.getSemesters();
							semesters.add(record);
							tool.setSemesters(semesters);
						}else{
							Vector semesters=new Vector();
							semesters.add(record);
							tool.setSemesters(semesters);
						}
						ManageSemesters.viewSemester(tool);
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
	
	public static void editSemester(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Edit Semester");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(225,125,250,20);
		tool.getPanel().add(label);
		
		String[] semester=(String[])tool.getSemesters().get(tool.getSelectedTableRowValue());
		
		JLabel numberLabel = new JLabel("Semester");
		numberLabel.setBounds(75, 165, 100, 20);
		numberLabel.setForeground(Color.WHITE);
		tool.getPanel().add(numberLabel);
		
		final JTextField semesterTextField = new JTextField();
		semesterTextField.setText(semester[0]);
		semesterTextField.setBounds(145, 163, 125, 25);
		tool.getPanel().add(semesterTextField);
		
		JLabel nameLabel = new JLabel("Start Date");
		nameLabel.setBounds(75, 200, 100, 20);
		nameLabel.setForeground(Color.WHITE);
		tool.getPanel().add(nameLabel);
		
		final JTextField startDateTextField = new JTextField();
		startDateTextField.setText(semester[1]);
		startDateTextField.setBounds(145, 198, 125, 25);
		tool.getPanel().add(startDateTextField);
		
		JLabel creditsLabel = new JLabel("End Date");
		creditsLabel.setBounds(75, 235, 100, 20);
		creditsLabel.setForeground(Color.WHITE);
		tool.getPanel().add(creditsLabel);
		
		final JTextField endDateTextField = new JTextField();
		endDateTextField.setText(semester[2]);
		endDateTextField.setBounds(145, 233, 125, 25);
		tool.getPanel().add(endDateTextField);
		
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
		
		
		final JButton addCourse = new JButton("Update Semester");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(semesterTextField!=null && semesterTextField.getText().trim().length()!=0 && startDateTextField!=null && startDateTextField.getText().trim().length()!=0 
						&& endDateTextField!=null && endDateTextField.getText().trim().length()!=0){
					try{
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Semesters.csv"));
						Vector semester=tool.getSemesters();
						Iterator iterator=semester.iterator();
						Vector updateSemesters=new Vector();
						int i=0;
						while(iterator.hasNext()){
							String records[]=(String[])iterator.next();
							if(i==(tool.getSelectedTableRowValue())){
								String [] record = {semesterTextField.getText(),startDateTextField.getText(),endDateTextField.getText()};
								writer.writeNext(record);
								updateSemesters.add(record);
							}else{
								writer.writeNext(records);
								updateSemesters.add(records);
							}
							i++;
						}						
						writer.close();
						tool.setSelectedTableRowValue(-1);
						tool.setSemesters(updateSemesters);
						ManageSemesters.viewSemester(tool);
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
	
	public static void viewSemester(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("View Semester");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(200,125,250,20);
		tool.getPanel().add(label);
		
		Object rowData[][]= { { "1", "2", "3"},{ "1", "2", "3"} };;
		Object columnNames[] = { "Semester Name", "Start Date", "End Date"};
		if(tool.getSemesters()!=null && tool.getSemesters().size()!=0){
			rowData=new Object[tool.getSemesters().size()][3];
			for(int i=0;i<tool.getSemesters().size();i++){
				String split[]=((String[])tool.getSemesters().get(i));
				if(split!=null && split.length>=3){
					rowData[i]=split;
				}
			}
		}
		final JTable semesterTable = new JTable(rowData, columnNames);
		semesterTable.setRowSelectionAllowed(true);
	    ListSelectionModel cellSelectionModel = semesterTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(semesterTable.getSelectedRow() > -1){
		        	tool.setSelectedTableRowValue(semesterTable.getSelectedRow());		        	
		        }
	    	}
	    });
		JScrollPane scroll = new JScrollPane(semesterTable);
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
		
		JButton addButton = new JButton("Add Semester");
		addButton.setBackground(Color.GREEN);		
		addButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSemester(tool);
			}
		});
		addButton.setBounds(50,400,175,30);
		tool.getPanel().add(addButton);		
		
		final JButton updateButton = new JButton("Edit Semester");
		updateButton.setBackground(Color.GREEN);		
		updateButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					editSemester(tool);		
				}else{
					JOptionPane.showMessageDialog(updateButton, "Please you should select one row only");
				}
			}
		});
		updateButton.setBounds(230,400,185,30);
		tool.getPanel().add(updateButton);
		
		final JButton deleteButton = new JButton("Delete");
		deleteButton.setBackground(Color.GREEN);		
		deleteButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tool.getSelectedTableRowValue()!=-1){
					try{
						Vector semesters=tool.getSemesters();
						semesters.remove(tool.getSelectedTableRowValue());
						CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Semesters.csv"));
						Iterator iterator=semesters.iterator();
						while(iterator.hasNext()){
							String[] record=(String[])iterator.next();
							writer.writeNext(record);
						}			
						writer.close();
						tool.setSemesters(semesters);
						tool.setSelectedTableRowValue(-1);
						ManageSemesters.viewSemester(tool);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(deleteButton, "Please you should select one row only");
				}		
			}
		});
		deleteButton.setBounds(420,400,100,30);
		tool.getPanel().add(deleteButton);
		
		tool.getPanel().repaint();
	}
}
