package ComparableComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorMultifiled {
	
	Student s = new Student();
	
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Satish",20));
		students.add(new Student("Amit",10));
		students.add(new Student("Vivek",21));
		students.add(new Student("Riken",12));
		students.add(new Student("Mahesh",8));
		students.add(new Student("Dinesh",25));
		students.add(new Student("Chaianya",11));
		students.add(new Student("Neha",20));
		students.add(new Student("Trupti",22));
		students.add(new Student("Sagar",7));
		
		System.out.println("Without sorting:");
		for(Student s : students) {
			System.out.println(s);
		}
		
		students.sort(Comparator.comparing(Student::getAge).thenComparing(Student::getName));
		
		System.out.println();
		System.out.println("Students afte comparing:");
		for(Student s : students) {
			System.out.println(s);
		}
	}
}

class Student{
	
	private String name;
	private int age;
	
	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
