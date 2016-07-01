package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ReadWriteCSVFile {

	public HashMap readStudentData(){
		HashMap studentDataMap=new HashMap();
		try{
			CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\StudentCourses.csv"));
			List<String[]> allStudentCoursesData=reader.readAll();
			for(String[] studentcourse : allStudentCoursesData){
				if(studentcourse!=null && studentcourse.length>=4){
					if(studentDataMap.containsKey(studentcourse[0].trim())){
						ArrayList studentCourseList=(ArrayList)studentDataMap.get(studentcourse[0].trim());
						if(studentCourseList!=null && studentCourseList.size()!=0){
							studentcourse[0]="";
							studentCourseList.add(studentcourse);
							studentDataMap.put(studentcourse[0].trim(), studentCourseList);
						}
					}else{
						ArrayList studentCourseList=new ArrayList();
						studentCourseList.add(studentcourse);
						studentDataMap.put(studentcourse[0].trim(), studentCourseList);
					}
					
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return studentDataMap;
	}
	
	public HashMap getStudentDegrees(){
		HashMap hashMap=new HashMap();
		try{
			CSVReader inputReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\StudentDegree.csv"));
			List<String[]> allStudentsData=inputReader.readAll();
			if(allStudentsData!=null && allStudentsData.size()!=0){
				for(String[] student : allStudentsData){
					if(student!=null && student.length>=2 && student[0]!=null && student[1]!=null){
						hashMap.put(student[0].trim(), student[1].trim());
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return hashMap;
	}
	
	public Vector readWriteCoursesData(String filePath){
		Vector courses=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalCoursesList=reader.readAll();
			int pointer=0;
			CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Courses.csv",true));
			for(String[] course : totalCoursesList){
				if(pointer!=0){
					writer.writeNext(course);
					courses.add(course);
				}
				pointer++;
			}								
			writer.close();								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return courses;
	}
	
	public Vector readCoursesData(String filePath){
		Vector courses=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalCoursesList=reader.readAll();
			int pointer=0;
			for(String[] course : totalCoursesList){
				if(pointer!=0){
					courses.add(course);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return courses;
	}
	
	public HashMap getStudentCourses(){
		HashMap studentCourseMap=new HashMap();
		try{
			CSVReader inputReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\StudentCourses.csv"));
			List<String[]> allStudentCoursesData=inputReader.readAll();
			for(String[] studentcourse : allStudentCoursesData){
				if(studentcourse!=null && studentcourse.length>=5 && studentcourse[0]!=null && studentcourse[2]!=null){
					if(studentCourseMap.containsKey(studentcourse[0].trim())){
						ArrayList studentCourseList=(ArrayList)studentCourseMap.get(studentcourse[0].trim());
						if(studentCourseList!=null && studentCourseList.size()!=0){
							studentCourseList.add(studentcourse[1].trim());
							studentCourseMap.put(studentcourse[0].trim(), studentCourseList);
						}
					}else{
						ArrayList studentCourseList=new ArrayList();
						studentCourseList.add(studentcourse[1].trim());
						studentCourseMap.put(studentcourse[0].trim(), studentCourseList);
					}
					
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return studentCourseMap;
	}
	
	public Vector readWriteFacultyData(String filePath){
		Vector facultyVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalFacultyList=reader.readAll();
			int pointer=0;
			CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Faculty.csv",true));
			for(String[] faculty : totalFacultyList){
				if(pointer!=0){
					writer.writeNext(faculty);
					facultyVector.add(faculty);
				}
				pointer++;
			}								
			writer.close();								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return facultyVector;
	}
	
	public Vector readFacultyData(String filePath){
		Vector facultyVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalFacultyList=reader.readAll();
			int pointer=0;
			for(String[] faculty : totalFacultyList){
				if(pointer!=0){
					facultyVector.add(faculty);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return facultyVector;
	}
	
	public Vector readWriteDegreeData(String filePath){
		Vector degreeVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalDegreesList=reader.readAll();
			int pointer=0;
			CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Degrees.csv",true));
			for(String[] degree : totalDegreesList){
				if(pointer!=0){
					writer.writeNext(degree);
					degreeVector.add(degree);
				}
				pointer++;
			}								
			writer.close();								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return degreeVector;
	}
	
	public Vector readDegreeData(String filePath){
		Vector degreeVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalDegreesList=reader.readAll();
			int pointer=0;
			for(String[] degree : totalDegreesList){
				if(pointer!=0){
					degreeVector.add(degree);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return degreeVector;
	}
	
	public Vector readWriteDegreePlanData(String filePath){
		Vector degreePlanVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalDegreePlanList=reader.readAll();
			int pointer=0;
			CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\DegreePlan.csv",true));
			for(String[] degreePlan : totalDegreePlanList){
				if(pointer!=0){
					writer.writeNext(degreePlan);
					degreePlanVector.add(degreePlan);
				}
				pointer++;
			}								
			writer.close();								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return degreePlanVector;
	}
	
	public Vector readDegreePlanData(String filePath){
		Vector degreePlanVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalDegreePlanList=reader.readAll();
			int pointer=0;
			for(String[] degreePlan : totalDegreePlanList){
				if(pointer!=0){
					degreePlanVector.add(degreePlan);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return degreePlanVector;
	}
	
	public HashMap getDegreePlan(){
		HashMap DegreeCourseMap=new HashMap();
		try{
			CSVReader inputReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\DegreePlan.csv"));
			List<String[]> degreeCourseData=inputReader.readAll();
			for(String[] degreeCourse : degreeCourseData){
				if(degreeCourse!=null && degreeCourse.length>=5 && degreeCourse[0]!=null && degreeCourse[2]!=null){
					if(DegreeCourseMap.containsKey(degreeCourse[0].trim())){
						ArrayList degreeCourseList=(ArrayList)DegreeCourseMap.get(degreeCourse[0].trim());
						if(degreeCourseList!=null && degreeCourseList.size()!=0){
							degreeCourseList.add(degreeCourse);
							DegreeCourseMap.put(degreeCourse[0].trim(), degreeCourseList);
						}
					}else{
						ArrayList degreeCourseList=new ArrayList();
						degreeCourseList.add(degreeCourse);
						DegreeCourseMap.put(degreeCourse[0].trim(), degreeCourseList);
					}
					
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return DegreeCourseMap;
	}
	
	public HashMap getCoursesFaculty(){
		HashMap hashMap=new HashMap();
		try{
			CSVReader inputReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\Courses.csv"));
			List<String[]> allCoursesData=inputReader.readAll();
			for(String[] courseData : allCoursesData){
				if(courseData!=null && courseData.length>=10){
					hashMap.put(courseData[0].trim(),courseData);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return hashMap;
	}
	
	public Vector readWriteSemesterData(String filePath){
		Vector semesterVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalSemesterList=reader.readAll();
			int pointer=0;
			CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\Semesters.csv",true));
			for(String[] semester : totalSemesterList){
				if(pointer!=0){
					writer.writeNext(semester);
					semesterVector.add(semester);
				}
				pointer++;
			}								
			writer.close();								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return semesterVector;
	}
	
	public Vector readSemesterData(String filePath){
		Vector semesterVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalSemesterList=reader.readAll();
			int pointer=0;
			for(String[] semester : totalSemesterList){
				if(pointer!=0){
					semesterVector.add(semester);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return semesterVector;
	}
	
	public HashMap getSemesters(){
		HashMap semesterMap=new HashMap();
		try{
			CSVReader inputReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\Semesters.csv"));
			List<String[]> allSemesterData=inputReader.readAll();
			for(String[] semesterData : allSemesterData){
				if(semesterData!=null && semesterData.length>=3){
					semesterMap.put(semesterData[0].trim(),semesterData);
				}
			}			
		}catch (Exception e){
			e.printStackTrace();
		}
		return semesterMap;
	}
	
	public Vector readWriteStudentsCourses(String filePath){
		Vector studentCourseVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalStudentCourseList=reader.readAll();
			int pointer=0;
			CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\StudentCourses.csv",true));
			for(String[] studentCourse : totalStudentCourseList){
				if(pointer!=0){
					writer.writeNext(studentCourse);
					studentCourseVector.add(studentCourse);
				}
				pointer++;
			}								
			writer.close();								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return studentCourseVector;
	}
	
	public Vector readStudentsCourses(String filePath){
		Vector studentCourseVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalStudentCourseList=reader.readAll();
			int pointer=0;
			for(String[] studentCourse : totalStudentCourseList){
				if(pointer!=0){
					studentCourseVector.add(studentCourse);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return studentCourseVector;
	}
	
	public Vector readWriteStudentsDegrees(String filePath){
		Vector studentDegreeVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalStudentDegreeList=reader.readAll();
			int pointer=0;
			CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\StudentDegree.csv",true));
			for(String[] studentDegree : totalStudentDegreeList){
				if(pointer!=0){
					writer.writeNext(studentDegree);
					studentDegreeVector.add(studentDegree);
				}
				pointer++;
			}								
			writer.close();								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return studentDegreeVector;
	}
	
	public Vector readStudentsDegrees(String filePath){
		Vector studentDegreeVector=new Vector();		
		try{
			CSVReader reader = new CSVReader(new FileReader(filePath));
			List<String[]> totalStudentDegreeList=reader.readAll();
			int pointer=0;
			for(String[] studentDegree : totalStudentDegreeList){
				if(pointer!=0){
					studentDegreeVector.add(studentDegree);
				}
				pointer++;
			}								
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return studentDegreeVector;
	}
	
	public Vector schedule(){
		Vector schedule=new Vector();		
		try{
			HashMap studentDegree=getStudentDegrees();
			HashMap studentCourse=getStudentCourses();
			HashMap degreeCourse=getDegreePlan();
			HashMap courseFaculty=getCoursesFaculty();
			HashMap studentsReadedSubjects=new HashMap();
			HashMap graduateStudent=new HashMap();
			for (Object key : studentCourse.keySet()) {
				if(((ArrayList)studentCourse.get(key)).size()==1){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==2){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==3){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==4){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==5){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==6){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==7){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==8){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
				if(((ArrayList)studentCourse.get(key)).size()==9){
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}else{
					studentsReadedSubjects.put(key.toString(), (ArrayList)studentCourse.get(key));
				}
			}
			for (Object key : studentsReadedSubjects.keySet()) {
				String degreeName=(String)studentDegree.get(key.toString());
				ArrayList coureses=(ArrayList)degreeCourse.get(degreeName);
				ArrayList studentCourses=(ArrayList)studentsReadedSubjects.get(key.toString());
				int required=0,required1=0,required2=0;
				int firstStudyCourses=0,secondStudyCourse=0,thirdStudyCourse=0;
				ArrayList studentCoursesWillStudy=new ArrayList();
				if(coureses!=null){
					for(int i=0;i<coureses.size();i++){
						String[] degreePlan=(String[])coureses.get(i);
						if(i==0){
							required=Integer.parseInt(degreePlan[2])/3;								
						}
						if(i==1){
							required1=Integer.parseInt(degreePlan[2])/3;
						}
						if(i==2){
							required2=Integer.parseInt(degreePlan[2])/3;
						}
					}
					for(int i=0;i<coureses.size();i++){
						String[] degreePlan=(String[])coureses.get(i);
						if(i==0){
							String[] courses=degreePlan[4].split(",");
							for(int index=0;index<courses.length;index++){
								if(studentCourses.contains(courses[index].trim())){
									firstStudyCourses++;
								}
							}
							if(required>firstStudyCourses){
								int counter=required-firstStudyCourses;
								for(int index=0;index<courses.length;index++){
									if(!studentCourses.contains(courses[index].trim())){
										if(counter!=0){
											studentCoursesWillStudy.add(courses[index].trim());
											counter--;
										}
									}
								}
							}
						}
						if(i==1){
							String[] courses=degreePlan[4].split(",");
							for(int index=0;index<courses.length;index++){
								if(studentCourses.contains(courses[index].trim())){
									secondStudyCourse++;
								}
							}
							if(required1>secondStudyCourse){
								int counter=required1-secondStudyCourse;
								for(int index=0;index<courses.length;index++){
									if(!studentCourses.contains(courses[index].trim())){
										if(counter!=0){
											studentCoursesWillStudy.add(courses[index].trim());
											counter--;
										}
									}
								}
							}
						}
						if(i==2){
							String[] courses=degreePlan[4].split(",");
							for(int index=0;index<courses.length;index++){
								if(studentCourses.contains(courses[index].trim())){
									thirdStudyCourse++;
								}
							}
							if(required2>thirdStudyCourse){
								int counter=required2-thirdStudyCourse;
								for(int index=0;index<courses.length;index++){
									if(!studentCourses.contains(courses[index].trim())){
										if(counter!=0){
											studentCoursesWillStudy.add(courses[index].trim());
											counter--;
										}
									}
								}
							}
						}
					}
					if(studentCoursesWillStudy!=null && studentCoursesWillStudy.size()<=4){
						graduateStudent.put(key.toString(), studentCoursesWillStudy);
					}
				}
			}
			HashMap schedulingStudents=new HashMap();
			if(graduateStudent!=null && graduateStudent.size()!=0){
				HashMap semesterMap=getSemesters();
				for (Object key : graduateStudent.keySet()) {
					ArrayList studentCoursesWillStudy =(ArrayList)graduateStudent.get(key.toString());
					for(int i=0;i<studentCoursesWillStudy.size();i++){
						String[] courseSchedule=new String[5];
						String courseCode=(String)studentCoursesWillStudy.get(i);
						if(schedulingStudents.containsKey(courseCode)){
							String[] tempSchedule=(String[])schedulingStudents.get(courseCode);
							tempSchedule[4]=""+((Integer.parseInt(tempSchedule[4])+1));
							schedulingStudents.put(courseCode,tempSchedule);
						}else{
							String[] course=(String[])courseFaculty.get(courseCode);
							String[] semester=(String[])semesterMap.get("2016SU");
							courseSchedule[1]=courseCode+" "+course[1];
							courseSchedule[0]="2016SU";
							courseSchedule[4]="1";
							courseSchedule[3]=semester[1]+" - "+semester[2];
							if(course[9].indexOf(",")!=-1){
								courseSchedule[2]=course[9].split(",")[0];
							}else{
								courseSchedule[2]=course[9];
							}
							schedulingStudents.put(courseCode,courseSchedule);
						}
					}
				}					
			}
			for (Object key : schedulingStudents.keySet()) {
				String[] finalSchedule=(String[])schedulingStudents.get(key.toString());
				schedule.add(finalSchedule);
			}	
			System.out.println(schedule+"  slkhgskghlsdhglahdgdsagdsagdasgdsj");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return schedule;
	}
	
}
