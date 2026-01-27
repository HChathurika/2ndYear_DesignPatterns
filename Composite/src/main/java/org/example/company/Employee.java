
package org.example.company;


public class Employee extends OrgComponent {
    private final double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public String toXml(int indent) {
        return indent(indent) +
                "<employee name=\"" + escapeXml(name) + "\" salary=\"" + salary + "\" />\n";
    }
}
