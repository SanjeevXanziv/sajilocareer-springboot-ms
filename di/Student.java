public class Student {
	private BaseFile baseFile;

	public Student(BaseFile baseFile) {
		this.baseFile = baseFile;
	}

	public void test() {
		this.baseFile.test();
	}

	//Runtime polymorphism
	public static void main(String[] args) {
		Student student = new Student(new Third());

		student.test();
	}
}