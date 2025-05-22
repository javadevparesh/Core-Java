package InterviewQuestions;

import java.util.List;

// Count no of boys and girls department wise
public class FindCountOfBoysGirls {
	
	public static void main(String[] args) {
		
//		Student students = new Student("Paresh", null, 0, null);
		
        List<Student> students = List.of(
                new Student("John", "Doe", 15, "Male"),
                new Student("Jane", "Smith", 16, "Female"),
                new Student("Alice", "Brown", 17, "Female"),
                new Student("Bob", "Johnson", 15, "Male")
            );
        
        long maleStudents = students.stream().filter(student->student.getGender().equalsIgnoreCase("male")).count();
        long femaleStudents = students.stream().filter(student->student.getGender().equalsIgnoreCase("female")).count();
        
        System.out.println("No of male studenst: " + maleStudents);
        System.out.println("No of female students: " + femaleStudents);
	}
}

class Student{
	
	private String firstName;
	private String lastName;
	private int age;
	private String gender;

	public Student(String firstName, String lastName, int age, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ "]";
	}
}
