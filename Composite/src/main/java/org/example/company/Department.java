
package org.example.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department extends OrgComponent {
    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrgComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrgComponent component) {
        children.remove(component);
    }

    @Override
    public List<OrgComponent> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public double getTotalSalary() {
        double sum = 0;
        for (OrgComponent c : children) {
            sum += c.getTotalSalary();
        }
        return sum;
    }

    @Override
    public String toXml(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(indent))
                .append("<department name=\"").append(escapeXml(name)).append("\">\n");

        for (OrgComponent c : children) {
            sb.append(c.toXml(indent + 1));
        }

        sb.append(indent(indent)).append("</department>\n");
        return sb.toString();
    }
}
