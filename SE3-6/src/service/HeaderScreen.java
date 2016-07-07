package service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import menu.MenuScreen;
import tasks.Forecast;
import tasks.Import;
import tasks.ManageSemesters;
import tasks.ManageStudents;
import tasks.Managecourses;
import tasks.Managedegreeplans;
import tasks.Managefaculties;
import tasks.Reports;
import tasks.Schedule;

public class HeaderScreen {
	public void getHeaderMenuScreen(final Tool tool){
		if(tool!=null && tool.getUserType()!=null){
			tool.getPanel().removeAll();
			final JLabel label=new JLabel("Welcome "+tool.getUserType());
			label.setFont(new Font("Courier New", Font.ITALIC, 24));
			label.setForeground(Color.WHITE);
			label.setBounds(175,50,250,20);
			tool.getPanel().add(label);
			
			JButton logout = new JButton("Logout");
			logout.setBackground(Color.GREEN);		
			logout.setFont(new Font("Courier New", Font.PLAIN, 18));
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//tool.setPanel(new JPanel());
//					tool.setStudents(null);
//					tool.setSubjects(null);
//					tool.setUserType(null);
//					Tool tools=new Tool();
					tool.setUserType("");
					getLoginScreen(tool.getPanel(),tool);			
				}
			});
			logout.setBounds(450,20,125,25);
			tool.getPanel().add(logout);
			
			if(tool!=null && tool.getUserType()!=null && (tool.getUserType().equalsIgnoreCase("Admin") || tool.getUserType().equalsIgnoreCase("director"))){
				
				final JButton courseButton = new JButton("Course");
				courseButton.setBounds(20, 75, 75, 30);
				courseButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Managecourses.viewCourse(tool);			     		
			         }
				});	    
			    tool.getPanel().add(courseButton);
				
			    final JButton degreePlanButton = new JButton("Degree Plan");
			    degreePlanButton.setBounds(100, 75, 110, 30);
			    degreePlanButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Managedegreeplans.viewDegreePlan(tool);
			         }
				});	    
			    tool.getPanel().add(degreePlanButton);
			    
			    final JButton facultyButton = new JButton("Faculty");
			    facultyButton.setBounds(215, 75, 75, 30);
			    facultyButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		Managefaculties.viewFaculty(tool);
			         }
				});	    
			    tool.getPanel().add(facultyButton);
			    
			    final JButton studentButton = new JButton("Student");
			    studentButton.setBounds(295, 75, 100, 30);
			    studentButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 ManageStudents.viewStudents(tool);		     		
			         }
				});	    
			    tool.getPanel().add(studentButton);
			    
			    final JButton semesterButton = new JButton("Semester");
			    semesterButton.setBounds(400, 75, 100, 30);
			    semesterButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 ManageSemesters.viewSemester(tool);		     		
			         }
				});	    
			    tool.getPanel().add(semesterButton);
			    
			    final JButton importDataButton = new JButton("Import Data");
			    importDataButton.setBounds(505, 75, 100, 30);
			    importDataButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Import.allFilesImport(tool);
			         }
				});	    
			    tool.getPanel().add(importDataButton);
			    
			    if(tool.getUserType().equalsIgnoreCase("director")){
				    JButton scheduleButton = new JButton("Schedule");
					scheduleButton.setFont(new Font("Courier New", Font.PLAIN, 16));
					scheduleButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Schedule.schedules(tool);	
						}
					});
					scheduleButton.setBounds(20, 110, 120, 30);
					tool.getPanel().add(scheduleButton);
			    }
				final JButton reportButton = new JButton("Report");
			    reportButton.setBounds(505, 110, 100, 30);
			    reportButton.setFont(new Font("Courier New", Font.PLAIN, 16));
			    reportButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Reports.generateReports(tool);
			     		
			         }
				});	    
			    tool.getPanel().add(reportButton);
		    
			    
				/*String courseLabels[] = {"Course", "View", "Add", "Update", "Delete"};
			    final JComboBox courseComboBox = new JComboBox(courseLabels);
			    courseComboBox.setMaximumRowCount(4);
			    courseComboBox.setSelectedIndex(0);
			    courseComboBox.setBounds(50, 75, 75, 30);
			    courseComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(courseComboBox.getSelectedIndex() != -1) {                     
			        		if(courseComboBox.getItemAt(courseComboBox.getSelectedIndex()).equals("Course")){
			        			JOptionPane.showMessageDialog(courseComboBox, "Please select correct option !!!");
				     		}
			     			if(courseComboBox.getItemAt(courseComboBox.getSelectedIndex()).equals("View")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     			if(courseComboBox.getItemAt(courseComboBox.getSelectedIndex()).equals("Add")){
			     				Managecourses managecourses=new Managecourses();
			     				managecourses.addCourse(tool);
			     			}
			     			if(courseComboBox.getItemAt(courseComboBox.getSelectedIndex()).equals("Update")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     			if(courseComboBox.getItemAt(courseComboBox.getSelectedIndex()).equals("Delete")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     		}
			         }
				});	    
			    tool.getPanel().add(courseComboBox);
			    
			    String degreePlanLabels[] = {"Degree Plan", "View", "Add", "Update", "Delete"};
			    final JComboBox degreePlanComboBox = new JComboBox(degreePlanLabels);
			    degreePlanComboBox.setMaximumRowCount(4);
			    degreePlanComboBox.setSelectedIndex(0);
			    degreePlanComboBox.setBounds(130, 75, 75, 30);
			    degreePlanComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(degreePlanComboBox.getSelectedIndex() != -1) {                     
			        		if(degreePlanComboBox.getItemAt(degreePlanComboBox.getSelectedIndex()).equals("Degree Plan")){
			        			JOptionPane.showMessageDialog(courseComboBox, "Please select correct option !!!");
				     		}
			     			if(degreePlanComboBox.getItemAt(degreePlanComboBox.getSelectedIndex()).equals("View")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     			if(degreePlanComboBox.getItemAt(degreePlanComboBox.getSelectedIndex()).equals("Add")){
			     				Managedegreeplans.addDegree(tool);
			     			}
			     			if(degreePlanComboBox.getItemAt(degreePlanComboBox.getSelectedIndex()).equals("Update")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     			if(degreePlanComboBox.getItemAt(degreePlanComboBox.getSelectedIndex()).equals("Delete")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     		}
			         }
				});	    
			    tool.getPanel().add(degreePlanComboBox);
				
				String facultyLabels[] = {"Faculty", "View", "Add", "Update", "Delete"};
				final JComboBox facultyComboBox = new JComboBox(facultyLabels);
				facultyComboBox.setMaximumRowCount(4);
				facultyComboBox.setSelectedIndex(0);
				facultyComboBox.setBounds(215, 75, 75, 30);
				facultyComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(facultyComboBox.getSelectedIndex() != -1) {                     
			        		if(facultyComboBox.getItemAt(facultyComboBox.getSelectedIndex()).equals("Faculty")){
			        			JOptionPane.showMessageDialog(facultyComboBox, "Please select correct option !!!");
				     		}
			     			if(facultyComboBox.getItemAt(facultyComboBox.getSelectedIndex()).equals("View")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     			if(facultyComboBox.getItemAt(facultyComboBox.getSelectedIndex()).equals("Add")){
			     				Managefaculties.addFaculty(tool);
			     			}
			     			if(facultyComboBox.getItemAt(facultyComboBox.getSelectedIndex()).equals("Update")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     			if(facultyComboBox.getItemAt(facultyComboBox.getSelectedIndex()).equals("Delete")){
			     				JOptionPane.showMessageDialog(courseComboBox, "Coming Soon !!!");
			     			}
			     		}
			         }
				});	    
			    tool.getPanel().add(facultyComboBox);
			    
			    String studentLabels[] = {"Student", "View", "Add", "Update", "Delete"};
				final JComboBox studentComboBox = new JComboBox(studentLabels);
				studentComboBox.setMaximumRowCount(4);
				studentComboBox.setSelectedIndex(0);
				studentComboBox.setBounds(295, 75, 75, 30);
				studentComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(studentComboBox.getSelectedIndex() != -1) {                     
			        		if(studentComboBox.getItemAt(studentComboBox.getSelectedIndex()).equals("Student")){
			        			JOptionPane.showMessageDialog(studentComboBox, "Please select correct option !!!");
				     		}
			     			if(studentComboBox.getItemAt(studentComboBox.getSelectedIndex()).equals("View")){
			     				ManageStudents.viewStudents(tool);
			     			}
			     			if(studentComboBox.getItemAt(studentComboBox.getSelectedIndex()).equals("Add")){
			     				ManageStudents.addStudent(tool);
			     			}
			     			if(studentComboBox.getItemAt(studentComboBox.getSelectedIndex()).equals("Update")){
			     				JOptionPane.showMessageDialog(studentComboBox, "Coming Soon !!!");
			     			}
			     			if(studentComboBox.getItemAt(studentComboBox.getSelectedIndex()).equals("Delete")){
			     				JOptionPane.showMessageDialog(studentComboBox, "Coming Soon !!!");
			     			}
			     		}
			         }
				});	    
			    tool.getPanel().add(studentComboBox);
			    
			    String roomLabels[] = {"Room", "View", "Add", "Update", "Delete"};
				final JComboBox roomComboBox = new JComboBox(roomLabels);
				roomComboBox.setMaximumRowCount(4);
				roomComboBox.setSelectedIndex(0);
				roomComboBox.setBounds(375, 75, 75, 30);
				roomComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(roomComboBox.getSelectedIndex() != -1) {                     
			        		if(roomComboBox.getItemAt(roomComboBox.getSelectedIndex()).equals("Room")){
			        			JOptionPane.showMessageDialog(roomComboBox, "Please select correct option !!!");
				     		}
			     			if(roomComboBox.getItemAt(roomComboBox.getSelectedIndex()).equals("View")){
			     				JOptionPane.showMessageDialog(studentComboBox, "Coming Soon !!!");
			     			}
			     			if(roomComboBox.getItemAt(roomComboBox.getSelectedIndex()).equals("Add")){
			     				JOptionPane.showMessageDialog(studentComboBox, "Coming Soon !!!");
			     			}
			     			if(roomComboBox.getItemAt(roomComboBox.getSelectedIndex()).equals("Update")){
			     				JOptionPane.showMessageDialog(studentComboBox, "Coming Soon !!!");
			     			}
			     			if(roomComboBox.getItemAt(roomComboBox.getSelectedIndex()).equals("Delete")){
			     				JOptionPane.showMessageDialog(studentComboBox, "Coming Soon !!!");
			     			}
			     		}
			         }
				});	    
			    tool.getPanel().add(roomComboBox);
			    
			    String importDataLabels[] = {"Import Data", "Student Import", "Course Import"};
				final JComboBox importDataComboBox = new JComboBox(importDataLabels);
				importDataComboBox.setMaximumRowCount(4);
				importDataComboBox.setSelectedIndex(0);
				importDataComboBox.setBounds(455, 75, 90, 30);
				importDataComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(importDataComboBox.getSelectedIndex() != -1) {                     
			        		if(importDataComboBox.getItemAt(importDataComboBox.getSelectedIndex()).equals("Import Data")){
			        			JOptionPane.showMessageDialog(importDataComboBox, "Please select correct option !!!");
				     		}
			     			if(importDataComboBox.getItemAt(importDataComboBox.getSelectedIndex()).equals("Student Import")){
			     				Import.studentImport(tool);
			     			}
			     			if(importDataComboBox.getItemAt(importDataComboBox.getSelectedIndex()).equals("Course Import")){
			     				Import.courseImport(tool);
			     			}
			     		}
			         }
				});	    
			    tool.getPanel().add(importDataComboBox);*/
			}else{
				
				JButton forecastButton = new JButton("Forecast");
				forecastButton.setFont(new Font("Courier New", Font.PLAIN, 16));
				forecastButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Forecast.addForecast(tool);	
					}
				});
				forecastButton.setBounds(100,90,125,30);
				tool.getPanel().add(forecastButton);
				
				JButton scheduleButton = new JButton("Schedule");
				scheduleButton.setFont(new Font("Courier New", Font.PLAIN, 16));
				scheduleButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Schedule.schedules(tool);	
					}
				});
				scheduleButton.setBounds(230, 90, 125, 30);
				tool.getPanel().add(scheduleButton);
			    
				final JButton reportButton = new JButton("Report");
			    reportButton.setBounds(360, 90, 115, 30);
			    reportButton.setFont(new Font("Courier New", Font.PLAIN, 16));
			    reportButton.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Reports.generateReports(tool);
			     		
			         }
				});	    
			    tool.getPanel().add(reportButton);
			    
			    /*String roomLabels[] = {"Sections", "Update"};
				final JComboBox roomComboBox = new JComboBox(roomLabels);
				roomComboBox.setMaximumRowCount(4);
				roomComboBox.setSelectedIndex(0);
				roomComboBox.setBounds(345, 75, 75, 30);
				roomComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(roomComboBox.getSelectedIndex() != -1) {                     
			        		if(roomComboBox.getItemAt(roomComboBox.getSelectedIndex()).equals("Sections")){
			        			JOptionPane.showMessageDialog(roomComboBox, "Please select correct option !!!");
				     		}
			     			if(roomComboBox.getItemAt(roomComboBox.getSelectedIndex()).equals("Update")){
			     				JOptionPane.showMessageDialog(roomComboBox, "Coming Soon !!!");
			     			}			     			
			     		}
			         }
				});	    
			    tool.getPanel().add(roomComboBox);
			    
			    String importDataLabels[] = {"Reports", "Schedule Report", "Student Report"};
				final JComboBox importDataComboBox = new JComboBox(importDataLabels);
				importDataComboBox.setMaximumRowCount(4);
				importDataComboBox.setSelectedIndex(0);
				importDataComboBox.setBounds(430, 75, 100, 30);
				importDataComboBox.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 if(importDataComboBox.getSelectedIndex() != -1) {                     
			        		if(importDataComboBox.getItemAt(importDataComboBox.getSelectedIndex()).equals("Reports")){
			        			JOptionPane.showMessageDialog(importDataComboBox, "Please select correct option !!!");
				     		}
			     			if(importDataComboBox.getItemAt(importDataComboBox.getSelectedIndex()).equals("Schedule Report")){
			     				Reports.generateReports(tool);
			     			}
			     			if(importDataComboBox.getItemAt(importDataComboBox.getSelectedIndex()).equals("Student Report")){
			     				Reports.generateStudentReports(tool);
			     			}
			     		}
			         }
				});	    
			    tool.getPanel().add(importDataComboBox);*/
			}
		}
	}
	
	public void getLoginScreen(final JPanel panel,final Tool tool){
		panel.removeAll();
		final JLabel label=new JLabel("Oklahoma Christian University");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(75,75,500,20);				
		panel.add(label);
		
		JLabel userNameLabel = new JLabel("User Name");
		userNameLabel.setBounds(125, 150, 100, 20);
		userNameLabel.setForeground(Color.WHITE);
		panel.add(userNameLabel);
		
		final JTextField textField = new JTextField();
		textField.setBounds(225, 148, 225, 25);
		panel.add(textField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(125, 210, 100, 20);
		passwordLabel.setForeground(Color.WHITE);
		panel.add(passwordLabel);
		
		final JPasswordField password= new JPasswordField();
		password.setBounds(225, 208, 225, 25);		
		panel.add(password);
		
		final JButton loginButton = new JButton("Login");
		loginButton.setBackground(Color.GREEN);		
		loginButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()==null || textField.getText().trim().length()==0){
					JOptionPane.showMessageDialog(loginButton, "Please enter user name");
				}else if(password.getText()==null || password.getText().trim().length()==0){
					JOptionPane.showMessageDialog(loginButton, "Please enter password");
				}else if((textField.getText().trim().equalsIgnoreCase("admin") && password.getText().trim().equalsIgnoreCase("admin"))){
					tool.setUserType("Admin");
					ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
				    Vector courses=readWriteCSVFile.readCoursesData(System.getProperty("user.dir")+"\\src\\Courses.csv");		
					tool.setCourses(courses);
					Vector faculties=readWriteCSVFile.readFacultyData(System.getProperty("user.dir")+"\\src\\Faculty.csv");		
					tool.setFaculty(faculties);	
					Vector degrees=readWriteCSVFile.readDegreeData(System.getProperty("user.dir")+"\\src\\Degrees.csv");		
					tool.setDegrees(degrees);
					Vector degreePlans=readWriteCSVFile.readDegreePlanData(System.getProperty("user.dir")+"\\src\\DegreePlan.csv");		
					tool.setDegreePlan(degreePlans);
					Vector semesters=readWriteCSVFile.readSemesterData(System.getProperty("user.dir")+"\\src\\Semesters.csv");		
					tool.setSemesters(semesters);
					Vector studentCourses=readWriteCSVFile.readStudentsCourses(System.getProperty("user.dir")+"\\src\\StudentDegree.csv");		
					tool.setStudentsCoursesVector(studentCourses);
					Vector studentDegrees=readWriteCSVFile.readStudentsDegrees(System.getProperty("user.dir")+"\\src\\StudentCourses.csv");		
					tool.setSemesters(studentDegrees);
					tool.setPanel(panel);
					new MenuScreen().initialize(tool);												
				}else if((textField.getText().trim().equalsIgnoreCase("director") && password.getText().trim().equalsIgnoreCase("director"))){
					tool.setUserType("Director");
					ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
					Vector courses=readWriteCSVFile.readCoursesData(System.getProperty("user.dir")+"\\src\\Courses.csv");		
					tool.setCourses(courses);
					Vector faculties=readWriteCSVFile.readFacultyData(System.getProperty("user.dir")+"\\src\\Faculty.csv");		
					tool.setFaculty(faculties);	
					Vector degrees=readWriteCSVFile.readDegreeData(System.getProperty("user.dir")+"\\src\\Degrees.csv");		
					tool.setDegrees(degrees);
					Vector degreePlans=readWriteCSVFile.readDegreePlanData(System.getProperty("user.dir")+"\\src\\DegreePlan.csv");		
					tool.setDegreePlan(degreePlans);
					Vector semesters=readWriteCSVFile.readSemesterData(System.getProperty("user.dir")+"\\src\\Semesters.csv");		
					tool.setSemesters(semesters);
					Vector studentCourses=readWriteCSVFile.readStudentsCourses(System.getProperty("user.dir")+"\\src\\StudentDegree.csv");		
					tool.setStudentsCoursesVector(studentCourses);
					Vector studentDegrees=readWriteCSVFile.readStudentsDegrees(System.getProperty("user.dir")+"\\src\\StudentCourses.csv");		
					tool.setSemesters(studentDegrees);
					tool.setPanel(panel);
					new MenuScreen().initialize(tool);												
				}else{
					JOptionPane.showMessageDialog(loginButton, "Enter user name and password correct !!!");
				}
			}
		});
		loginButton.setBounds(225, 275, 125, 30);	
		panel.add(loginButton);		
		panel.repaint();
	}
}
