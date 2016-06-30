package service;

import java.util.HashMap;
import java.util.Vector;

import javax.swing.JPanel;

public class Tool {
	private String userType;
	private JPanel panel;
	private HashMap studentsCourses;
	private JPanel subPanel;
	private JPanel subPanel1;
	private Vector courses;
	private Vector semesters;
	private Vector faculty;
	private Vector degreePlan;
	private Vector degrees;
	private Vector studentsCoursesVector;
	private int selectedTableRowValue;
	private Vector schedule;
	private String degreeCode;
	
	public String getDegreeCode() {
		return degreeCode;
	}
	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	public Vector getSchedule() {
		return schedule;
	}
	public void setSchedule(Vector schedule) {
		this.schedule = schedule;
	}
	public int getSelectedTableRowValue() {
		return selectedTableRowValue;
	}
	public void setSelectedTableRowValue(int selectedTableRowValue) {
		this.selectedTableRowValue = selectedTableRowValue;
	}
	public Vector getStudentsCoursesVector() {
		return studentsCoursesVector;
	}
	public void setStudentsCoursesVector(Vector studentsCoursesVector) {
		this.studentsCoursesVector = studentsCoursesVector;
	}
	public Vector getDegrees() {
		return degrees;
	}
	public void setDegrees(Vector degrees) {
		this.degrees = degrees;
	}
	public HashMap getStudentsCourses() {
		return studentsCourses;
	}
	public void setStudentsCourses(HashMap studentsCourses) {
		this.studentsCourses = studentsCourses;
	}
	public Vector getSemesters() {
		return semesters;
	}
	public void setSemesters(Vector semesters) {
		this.semesters = semesters;
	}
	public Vector getFaculty() {
		return faculty;
	}
	public void setFaculty(Vector faculty) {
		this.faculty = faculty;
	}
	public Vector getDegreePlan() {
		return degreePlan;
	}
	public void setDegreePlan(Vector degreePlan) {
		this.degreePlan = degreePlan;
	}
	public Vector getCourses() {
		return courses;
	}
	public void setCourses(Vector courses) {
		this.courses = courses;
	}
	public JPanel getSubPanel1() {
		return subPanel1;
	}
	public void setSubPanel1(JPanel subPanel1) {
		this.subPanel1 = subPanel1;
	}
	public JPanel getSubPanel() {
		return subPanel;
	}
	public void setSubPanel(JPanel subPanel) {
		this.subPanel = subPanel;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}	
}
