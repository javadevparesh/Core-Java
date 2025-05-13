package StaticConcept;

public class StudentMain {

	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setAge(12);
		student1.setName("Ram");
		student1.setId(123);

		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();

		Student.getCount();
		System.out.println(Utils.max(1, 22));
		Utils.trimAndUppercase("the text");

		int c = sum(1, 2);
		System.out.println(c);

	}

	/* 
	 * - 'static' can be applied to variables, methods, blocks and nested classes
	 * - Static method can't use 'non-static data members' OR call 'non-static methods' directly.
	 * - 'this' and 'super' cannot be used in 'static' context. 
	 * - On whatever we use 'static' will become part of a class
	 */
	
	public static int sum(int a, int b) {
		return a + b;
	}
}

/* 
 * - Non-static field cannot be referenced from a static context 
 * - Before any instance is created, static variables gets initialized
 * - 'static' blocks are used for static initialization, which we need to setup task one-time.
 * 
 */

class Student {

	public static int count = 0;

	static {
		System.out.println("Hello");
	}

	private int id;
	private String name;
	public int age;

	public Student() {
		count++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void getCount() {
		System.out.println("Total students: " + count);
	}
}

class Utils {

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	public static int min(int a, int b) {
		if (a < b) {
			return a;
		}
		return b;
	}

	public static String trimAndUppercase(String str) {

		if (str != null) {
			return str.trim().toUpperCase();
		} else {
			return "";
		}
	}

}
