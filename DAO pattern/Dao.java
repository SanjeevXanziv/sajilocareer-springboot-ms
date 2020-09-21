import java.util.*;

public class Dao {
	private List<Student> studentList = new ArrayList<>();

	public void addStudent(Student student) {
		this.studentList.add(student);
	}
}