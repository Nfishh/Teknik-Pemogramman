public class TestEmployee {

    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Antonio", 2000000, 2015);
        staff[1] = new Manager("Maria", 2500000, 2010);
        staff[2] = new Employee("Isabel", 3000000, 2018);

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        System.out.println("Before Sorting:");
        for (Employee e : staff) {
            e.print();
        }

        Sortable.shell_sort(staff);

        System.out.println("\nAfter Sorting:");
        for (Employee e : staff) {
            e.print();
        }
    }
}