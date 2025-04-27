package InterviewQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondHighestSalary {
	
	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		
		emp.add(new Employee("Paresh",22000));
		emp.add(new Employee("Vijay",25000));
		emp.add(new Employee("Chetan",32000));
		
		
		// Using streams
		List<Double> distinctSalaries = emp.stream().map(Employee::getSalary)
					.distinct()
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
		
		if(distinctSalaries.size()<2) {
			System.out.println("There is no second highest salary");
		}else {
			System.out.println("Secnd highest salary: " + distinctSalaries.get(1));
		}
	}
}

class Employee{
	
	private String name;
	private double Salary;
	
	public Employee() {
	}

	public Employee(String name, double salary) {
		this.name = name;
		Salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
}
