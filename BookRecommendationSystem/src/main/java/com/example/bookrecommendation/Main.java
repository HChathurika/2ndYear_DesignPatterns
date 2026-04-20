package com.example.bookrecommendation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Recommendation> recommendations = new ArrayList<>();

    public static void main(String[] args) {
        loadSampleData();
        menu();
    }

    private static void loadSampleData() {
        Recommendation kids = new Recommendation("Kids");
        kids.addBook(new Book("J.K. Rowling", "Harry Potter", "Fantasy", 1997));
        kids.addBook(new Book("Roald Dahl", "Matilda", "Children", 1988));

        Recommendation teens = new Recommendation("Teens");
        teens.addBook(new Book("Suzanne Collins", "The Hunger Games", "Dystopian", 2008));
        teens.addBook(new Book("John Green", "The Fault in Our Stars", "Romance", 2012));

        recommendations.add(kids);
        recommendations.add(teens);
    }

    private static void menu() {
        while (true) {
            System.out.println("=== Book Recommendation System ===");
            System.out.println("1. View recommendations");
            System.out.println("2. Clone and modify recommendation");
            System.out.println("3. Create new recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewRecommendations();
                    break;
                case 2:
                    cloneRecommendation();
                    break;
                case 3:
                    createRecommendation();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    private static void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.\n");
            return;
        }

        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("Recommendation " + (i + 1));
            recommendations.get(i).displayRecommendation();
        }
    }

    private static void cloneRecommendation() {
        viewRecommendations();

        System.out.print("Enter recommendation number to clone: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid recommendation number.\n");
            return;
        }

        Recommendation cloned = recommendations.get(index).clone();

        System.out.print("Enter new target audience: ");
        cloned.setTargetAudience(scanner.nextLine());

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Save cloned recommendation");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                Book book = createBookFromInput();
                cloned.addBook(book);
            } else if (choice == 2) {
                cloned.displayRecommendation();
                System.out.print("Enter book number to remove: ");
                int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                cloned.removeBook(removeIndex);
            } else if (choice == 3) {
                recommendations.add(cloned);
                System.out.println("Cloned recommendation saved.\n");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private static void createRecommendation() {
        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine();

        Recommendation recommendation = new Recommendation(audience);

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Save recommendation");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                Book book = createBookFromInput();
                recommendation.addBook(book);
            } else if (choice == 2) {
                recommendations.add(recommendation);
                System.out.println("New recommendation saved.\n");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private static Book createBookFromInput() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter publication year: ");
        int year = Integer.parseInt(scanner.nextLine());

        return new Book(author, title, genre, year);
    }
}