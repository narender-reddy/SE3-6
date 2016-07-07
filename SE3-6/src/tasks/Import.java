package tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import menu.MenuScreen;
import service.HeaderScreen;
import service.ReadWriteCSVFile;
import service.Tool;

public class Import {
	static String filePaths="";
	static JFileChooser multipleFileChooser = new JFileChooser();
	public static void allFilesImport(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		final JLabel label=new JLabel("Import Files");
		label.setFont(new Font("Courier New", Font.ITALIC, 24));
		label.setForeground(Color.WHITE);
		label.setBounds(175,125,275,20);
		tool.getPanel().add(label);
		
		final JTextArea fileTextArea = new JTextArea("",25,40);
		fileTextArea.setBounds(50,150,450,130);
		tool.getPanel().add(fileTextArea);
		
		final JButton button = new JButton("Select All Import Files");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				//JFileChooser multipleFileChooser = new JFileChooser();				
				multipleFileChooser.setMultiSelectionEnabled(true);
				int value = multipleFileChooser.showOpenDialog(null);
				if(value==JFileChooser.APPROVE_OPTION){					 
					try{
						File[] file=multipleFileChooser.getSelectedFiles();
						for(int i=0;i<file.length;i++){  
							filePaths+=file[i].toString()+"\n";				              				              
						}
						fileTextArea.setText(filePaths);
						fileTextArea.setEditable(false);
					}catch (Exception ex){
						JOptionPane.showMessageDialog(button, "Please select test data files");
					}
				}
			}
		});
		button.setBounds(175,300,200,35);
		tool.getPanel().add(button);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.GREEN);		
		exitButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(85,350,100,30);
		tool.getPanel().add(exitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.GREEN);		
		cancelButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuScreen().initialize(tool);		
			}
		});
		cancelButton.setBounds(200,350,100,30);
		tool.getPanel().add(cancelButton);
		
		
		JButton addCourse = new JButton("Import Files");
		addCourse.setBackground(Color.GREEN);		
		addCourse.setFont(new Font("Courier New", Font.PLAIN, 18));
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadWriteCSVFile readWriteCSVFile=new ReadWriteCSVFile();
				try{
					File[] file=multipleFileChooser.getSelectedFiles();
					for(int i=0;i<file.length;i++){ 
						System.out.println(file[i].toString());
						if(file[i].toString().indexOf("TestDataCourses.csv")!=-1){
							try{
								Vector courses=readWriteCSVFile.readWriteCoursesData(file[i].toString());		
								tool.setCourses(courses);																
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						if(file[i].toString().indexOf("TestDataFaculty.csv")!=-1){
							try{
								Vector faculties=readWriteCSVFile.readWriteFacultyData(file[i].toString());		
								tool.setFaculty(faculties);
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						if(file[i].toString().indexOf("TestDataDegrees.csv")!=-1){
							try{
								Vector degrees=readWriteCSVFile.readWriteDegreeData(file[i].toString());		
								tool.setDegrees(degrees);
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						if(file[i].toString().indexOf("TestDataDegreePlanReq.csv")!=-1){
							try{
								Vector degreePlans=readWriteCSVFile.readWriteDegreePlanData(file[i].toString());		
								tool.setDegreePlan(degreePlans);
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						if(file[i].toString().indexOf("TestDataSemesters.csv")!=-1){
							try{
								Vector semesters=readWriteCSVFile.readWriteSemesterData(file[i].toString());		
								tool.setSemesters(semesters);
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						if(file[i].toString().indexOf("STC.DUMP.CSV")!=-1){
							try{
								Vector studentCourses=readWriteCSVFile.readWriteStudentsCourses(file[i].toString());		
								tool.setStudentsCoursesVector(studentCourses);
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						if(file[i].toString().indexOf("STU.DUMP.CSV")!=-1){
							try{
								Vector studentDegrees=readWriteCSVFile.readWriteStudentsDegrees(file[i].toString());		
								tool.setSemesters(studentDegrees);
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
					}
					HashMap studentMap=readWriteCSVFile.readStudentData();
					tool.setStudentsCourses(studentMap);
					tool.setSelectedTableRowValue(-1);
					Managecourses.viewCourse(tool);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(button, "Please select test data files");
				}
			}
		});
		addCourse.setBounds(305,350,200,30);
		tool.getPanel().add(addCourse);
		
		tool.getPanel().repaint();
	}
}
