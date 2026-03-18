package org.example;

public class MyFile implements FileSystemElement {
    private String name;
    private double size;
    private String extension;

    public MyFile(String name, double size, String extension) {
        this.name = name;
        this.size = size;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}