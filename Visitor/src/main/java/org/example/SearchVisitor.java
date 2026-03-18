package org.example;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String targetExtension;
    private List<MyFile> foundFiles;

    public SearchVisitor(String targetExtension) {
        this.targetExtension = targetExtension;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(MyFile file) {
        if (file.getExtension().equalsIgnoreCase(targetExtension)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Nothing to do for directory
    }

    public List<MyFile> getFoundFiles() {
        return foundFiles;
    }
}