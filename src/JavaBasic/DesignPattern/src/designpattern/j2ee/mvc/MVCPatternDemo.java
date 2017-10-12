package designpattern.j2ee.mvc;

public class MVCPatternDemo
{
	public static void main(String[] args)
	{
		Student model = retriveStudentFromDatabase();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model, view);
		controller.updateView();
		
		controller.setStudentName("John");
		controller.updateView();
	}
	
	public static Student retriveStudentFromDatabase()
	{
		Student student = new Student();
		student.setName("Robert");
		student.setrollNo("10");
		return student;
	}
}
