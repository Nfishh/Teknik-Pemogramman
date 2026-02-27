public class Employee extends Sortable {

    private String name;
    private double salary;
    private int hireYear;

    public Employee(String name, double salary, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.hireYear = hireYear;
    }

    public void raiseSalary(double percent) {
        salary *= 1 + percent / 100;
    }

    public int hireYear() {
        return hireYear;
    }

    public void print() {
        System.out.println(name + " | Salary: " + salary);
    }

    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b;

        if (this.salary < eb.salary) return -1;
        if (this.salary > eb.salary) return 1;
        return 0;
    }
}