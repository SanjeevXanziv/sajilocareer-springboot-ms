import java.util.*;

public class Controller {
	private Service service;

	public Controller(Service service) {
		this.service = service;
	}

	public void addStudent(Student student) {
		this.service.addStudent(student);
	}

	public void menu() {
		System.out.println("*** Welcome to Student Enrollment System ***");
		System.out.println("1. Add Student");
		System.out.println("5. Exit");
	}

	public Student makeStudentObject() {
		Scanner scan = new Scanner(System.in); // Input lina lai ready state ma baseko ho
		System.out.println("Enter student id: "); 
		int id = scan.nextInt(); 

		System.out.println("Enter student name: "); 
		Scanner scanName = new Scanner(System.in); // Input lina lai ready state ma baseko ho
		String name = scanName.nextLine(); 

		System.out.println("Enter student address: "); 
		Scanner scanAdd = new Scanner(System.in); // Input lina lai ready state ma baseko ho
		String address = scanAdd.nextLine(); 

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAddress(address);

		return student;
	}

	public static void main(String[] args) {
		Controller controller = new Controller(new Service(new Dao()));
		controller.menu();
		Scanner scan = new Scanner(System.in); // Input lina lai ready state ma baseko ho
		System.out.println("Enter your choice: "); 
		int a = scan.nextInt(); // input state

		while(a != 5) {
			if (a == 1) {
				controller.addStudent(controller.makeStudentObject());
			}

			Scanner scanNext = new Scanner(System.in); // Input lina lai ready state ma baseko ho
			System.out.println("Enter your choice: "); 
			a = scanNext.nextInt();
		}

		System.out.println("Thank you for using our system");
	}
}