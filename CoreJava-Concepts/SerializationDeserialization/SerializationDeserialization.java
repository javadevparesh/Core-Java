package SerializationDeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDeserialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Student student = new Student(1, "Mrugesh", 22);
		
		serializeObject(student, "stdent.ser");
		
		System.out.println();
		File file = new File("student.ser");
		deserializeObject(file);
	}
	
	// Method to serialize object
	public static void serializeObject(Object obj, String string) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(string);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// Serializing an object
		oos.writeObject(obj);
		oos.close();
	}
	
	// Method to De-serialize object
	public static void deserializeObject(File file) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Student student = (Student) ois.readObject();
		ois.close();
		
		System.out.println("Reading object from the file...");
		System.out.println(student);
	}
}


// Student class
class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int age;
	
	public Student() {
	}

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}