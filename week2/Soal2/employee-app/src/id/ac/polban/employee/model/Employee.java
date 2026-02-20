package id.ac.polban.employee.model;

public class Employee {
    
        public Department getDepartment() {
        return department;
    }

    public EmploymentType getType() {
        return type;
    }

    private static int totalEmployee = 0;

    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;

    public Employee(int id, String name,
                    Department department,
                    EmploymentType type,
                    double salary) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;

        totalEmployee++;
    }

    public static int getTotalEmployee() {
        return totalEmployee;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}