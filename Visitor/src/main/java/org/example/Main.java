package org.example;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory images = new Directory("images");

        MyFile file1 = new MyFile("report", 2.5, "txt");
        MyFile file2 = new MyFile("notes", 1.2, "txt");
        MyFile file3 = new MyFile("photo", 5.0, "jpg");
        MyFile file4 = new MyFile("diagram", 3.3, "png");

        documents.addElement(file1);
        documents.addElement(file2);

        images.addElement(file3);
        images.addElement(file4);

        root.addElement(documents);
        root.addElement(images);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor("txt");
        root.accept(searchVisitor);

        System.out.println("\nFiles with .txt extension:");
        for (MyFile file : searchVisitor.getFoundFiles()) {
            System.out.println(file.getName() + "." + file.getExtension() + " - " + file.getSize() + " MB");
        }
    }
}