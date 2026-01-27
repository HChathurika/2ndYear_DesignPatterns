package org.example.company;


public class Main {
    public static void main(String[] args) {

        // Root of the organization (top department)
        Department organization = new Department("MyOrganization");

        // Departments
        Department it = new Department("IT");
        Department hr = new Department("HR");
        Department dev = new Department("Development");

        // Employees
        Employee alice = new Employee("Alice", 3500);
        Employee bob = new Employee("Bob", 4200);
        Employee clara = new Employee("Clara", 3000);
        Employee dino = new Employee("Dino", 5000);

        // Build structure using single-call add()
        organization.add(it);
        organization.add(hr);

        it.add(dev);          // IT contains Development sub-department
        it.add(alice);        // IT contains Alice
        dev.add(bob);         // Development contains Bob
        dev.add(dino);        // Development contains Dino
        hr.add(clara);        // HR contains Clara

        // 1) Print total salary with a single method call
        System.out.println("Total salary = " + organization.getTotalSalary());

        // 2) Remove with a single method call
        dev.remove(bob);

        System.out.println("Total salary after removing Bob = " + organization.getTotalSalary());

        // 3) Print whole structure in XML with a single method call
        System.out.println("\n--- XML Organization Structure ---");
        System.out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        System.out.print(organization.toXml(0));
    }
}
