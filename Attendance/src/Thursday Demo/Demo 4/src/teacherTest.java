
public class teacherTest {
	public static void main(String[] args) {

		ProgrammingTeacher obj = new ProgrammingTeacher();

		System.out.println(obj.teacherName);
		System.out.println(obj.designation);
		System.out.println(obj.subject);
		System.out.println(obj.department);
		System.out.println(obj.university);

		obj.does();
		obj.sectionDetails();
		obj.action();
	}
}
