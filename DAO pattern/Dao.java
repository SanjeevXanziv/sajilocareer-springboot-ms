import java.util.*;

public class Dao {
	private List<Student> studentList = new ArrayList<>();

	//This method is used for adding student to the array list
	public void addStudent(Student student) {
		this.studentList.add(student);
	}

	// this method is used to return all the students
	public List<Student> getAllStudent() {
		return this.studentList;
	}
}