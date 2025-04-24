package ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableComparator {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(1,"Jatin",20000, "Bomaby"));
		employees.add(new Employee(2,"Lalit",25000, "Pune"));
		employees.add(new Employee(3,"Vikas",21000, "Pune"));
		employees.add(new Employee(4,"Vimla",18000, "Delhi"));
		employees.add(new Employee(5,"Babu",50000, "Chennai"));
		employees.add(new Employee(6,"Chetan",42000, "Banglore"));
		employees.add(new Employee(7,"Vishwa",35000, "Pune"));
		employees.add(new Employee(8,"Lokesh",45000, "Thane"));
		employees.add(new Employee(9,"Umesh",15000, "Surat"));
		employees.add(new Employee(10,"Durga",20000, "Ahmedbad"));
		
		System.out.println("Employees without sorting:");
		for(Employee emp : employees) {
			System.out.println(emp);
		}
		System.out.println();
		
		System.out.println("Employee after sorting by comparable(salary):");
		Collections.sort(employees);
		for(Employee emp : employees) {
			System.out.println(emp);
		}
		System.out.println();
		
		System.out.println("Employee after sorting by comparator(name):");
		Collections.sort(employees, new EmployeeNameComparator());
		for(Employee emp : employees) {
			System.out.println(emp);
		}
	}
}

// Employee class with comparable implementation
class Employee implements Comparable<Employee>{
	
	private int id;
	private String name;
	private double salary;
	private String City;
	
	public Employee() {
	}

	public Employee(int id, String name, double salary, String city) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		City = city;
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

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}

	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", City=" + City + "]";
	}

	@Override
	public int compareTo(Employee emp) {
		if(this.salary > emp.salary) {
			return 1;
		}else if(this.salary<emp.salary) {
			return -1;
		}else {
			return 0;
		}
	}
}

// Comparator implementation (comparing employee by name)
class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
}