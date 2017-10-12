package designpattern.j2ee.transferobject;

import java.util.ArrayList;
import java.util.List;

public class StudentBO
{
	List<StudentVO> students;
	
	public StudentBO()
	{
		students = new ArrayList<StudentVO>();
		StudentVO student1 = new StudentVO("Robert",0);
		StudentVO student2 = new StudentVO("John",1);
		students.add(student1);
		students.add(student2);
	}
	
	public void deleteStuden(StudentVO student)
	{
		students.remove(student.getRoolNo());
		System.out.println("Student:Roll No " + student.getRoolNo() + ",deleted from datbase");
	}
	
	public List<StudentVO> getAllStudents()
	{
		return students;
	}
	
	public StudentVO getStudent(int rollNo)
	{
		return students.get(rollNo);
	}
	
	public void updateStudent(StudentVO student)
	{
		students.get(student.getRoolNo()).setName(student.getName());
		System.out.println("Student:Roll No " + student.getRoolNo() + ",updated in the database");
	}
}
