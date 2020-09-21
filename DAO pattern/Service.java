public class Service {
	//This class contains the business logic so all the programming logics are written here

	private Dao dao;

	public Service(Dao dao) {
		this.dao = dao;
	}

	public void addStudent(Student student) {
		this.dao.addStudent(student);
	}
}