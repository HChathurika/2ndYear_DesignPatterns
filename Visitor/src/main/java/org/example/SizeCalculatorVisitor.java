package org.example;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(MyFile file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // No size added directly for directory
    }

    public double getTotalSize() {
        return totalSize;
    }
}