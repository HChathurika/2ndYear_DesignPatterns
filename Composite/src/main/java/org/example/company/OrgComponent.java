package org.example.company;


import java.util.List;

public abstract class OrgComponent {
    protected String name;

    public OrgComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Composite methods (default: unsupported for leaf)
    public void add(OrgComponent component) {
        throw new UnsupportedOperationException("Cannot add to this component.");
    }

    public void remove(OrgComponent component) {
        throw new UnsupportedOperationException("Cannot remove from this component.");
    }

    public List<OrgComponent> getChildren() {
        throw new UnsupportedOperationException("No children for this component.");
    }

    // Common operations
    public abstract double getTotalSalary();
    public abstract String toXml(int indent);

    protected String indent(int indent) {
        return "  ".repeat(Math.max(0, indent));
    }

    // small helper for XML escaping
    protected String escapeXml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}
