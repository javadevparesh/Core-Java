package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentWiseCount {
    public static void main(String[] args) {
        List<Employees> employees = Arrays.asList(
            new Employees("Alice", "Female", "HR"),
            new Employees("Bob", "Male", "IT"),
            new Employees("Charlie", "Male", "HR"),
            new Employees("David", "Male", "IT"),
            new Employees("Eve", "Female", "Finance"),
            new Employees("Fiona", "Female", "HR"),
            new Employees("Mohini", "Female", "Marketing")
        );

        Map<String, Map<String, Long>> departmentWiseCount = employees.stream()
            .collect(Collectors.groupingBy(Employees::getDepartment,
                    Collectors.groupingBy(Employees::getGender, Collectors.counting())));

        System.out.println("Count: " + departmentWiseCount);
        
        
        
	        Map<String, List<String>> deptToNames = employees.stream()
	        		.collect(Collectors.groupingBy(
	        			Employees::getDepartment,	// Since Grouping by dept, Department Will become key
	        			Collectors.mapping(Employees::getName,
	        					Collectors.toList())
	        		));
        
        Set<String> keySet = deptToNames.keySet();
        for(String key : keySet) {
        	System.out.println(key + " : " + deptToNames.get(key));
        }
        
        // Without mapping (more boilerplate code)
        Map<String, List<String>> deptToNames2 = new HashMap<>();
        for (Employees emp : employees){
        	deptToNames2
        	.computeIfAbsent(emp.getDepartment(), j -> new ArrayList<>())	// emp.getDepartment() might return "HR" (Which is key as per computeIfAbsent())
        	.add(emp.getName());	// Adds the value for a key				// Java calls the lambda: j -> new ArrayList<>()
        }																	// So j == "HR"
        
    }
}

class Employees {
    String name;
    String gender;
    String department;

    public Employees(String name, String gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }
    
    public String getName() {
		return name;
	}
    
    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }
}



