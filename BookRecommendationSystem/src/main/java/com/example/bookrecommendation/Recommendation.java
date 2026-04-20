package com.example.bookrecommendation;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        } else {
            System.out.println("Invalid book index.");
        }
    }

    @Override
    public Recommendation clone() {
        Recommendation cloned = new Recommendation(this.targetAudience);
        for (Book book : this.books) {
            cloned.addBook(book.clone()); // deep copy
        }
        return cloned;
    }

    public void displayRecommendation() {
        System.out.println("Target Audience: " + targetAudience);
        if (books.isEmpty()) {
            System.out.println("No books in this recommendation.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
        System.out.println();
    }
}