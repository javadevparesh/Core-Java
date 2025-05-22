package InterviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class DepartmentWiseCount {
    public static void main(String[] args) {
        List<Employees> employees = Arrays.asList(
            new Employees("Alice", "Female", "HR"),
            new Employees("Bob", "Male", "IT"),
            new Employees("Charlie", "Male", "HR"),
            new Employees("David", "Male", "IT"),
            new Employees("Eve", "Female", "Finance"),
            new Employees("Fiona", "Female", "HR")
        );

        Map<String, Map<String, Long>> departmentWiseCount = employees.stream()
            .collect(Collectors.groupingBy(Employees::getDepartment,
                    Collectors.groupingBy(Employees::getGender, Collectors.counting())));

        System.out.println(departmentWiseCount);
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

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }
}



