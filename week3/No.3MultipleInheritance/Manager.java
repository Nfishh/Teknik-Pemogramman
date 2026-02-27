public class Manager extends Employee {

    public Manager(String name, double salary, int hireYear) {
        super(name, salary, hireYear);
    }

    @Override
    public void raiseSalary(double percent) {
        int currentYear = 2025;
        double bonus = 0.5 * (currentYear - hireYear());
        super.raiseSalary(percent + bonus);
    }
}