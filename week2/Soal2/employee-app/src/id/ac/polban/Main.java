package id.ac.polban;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {

    public static void main(String[] args) {

        Department it = new Department("IT");
        EmploymentType fullTime = new EmploymentType("Full-Time");

        Employee emp1 = new Employee(1, "Nafis", it, fullTime, 5000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);

        service.raiseSalary(1, 10);

        System.out.println("Nama: " + emp1.getName());
        System.out.println("Gaji Baru: " + emp1.getSalary());
        System.out.println("Total Employee: " + Employee.getTotalEmployee());
    }
}