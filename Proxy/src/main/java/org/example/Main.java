package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addUnprotectedDocument(
                "DOC1",
                LocalDate.of(2026, 3, 18),
                "This is a public document."
        );

        library.addProtectedDocument(
                "DOC2",
                LocalDate.of(2026, 3, 18),
                "This is a protected secret document."
        );

        library.addProtectedDocument(
                "DOC3",
                LocalDate.of(2026, 3, 18),
                "Another protected document."
        );

        User alice = new User("alice");
        User bob = new User("bob");

        AccessControlService accessControlService = AccessControlService.getInstance();
        accessControlService.grantAccess("alice", "DOC2");

        System.out.println("All documents in library:");
        library.listDocuments();

        System.out.println("\n--- Access tests ---");

        try {
            DocumentInterface doc1 = library.getDocument("DOC1");
            System.out.println("Alice reads DOC1: " + doc1.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            DocumentInterface doc2 = library.getDocument("DOC2");
            System.out.println("Alice reads DOC2: " + doc2.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            DocumentInterface doc2 = library.getDocument("DOC2");
            System.out.println("Bob reads DOC2: " + doc2.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            DocumentInterface doc3 = library.getDocument("DOC3");
            System.out.println("Alice reads DOC3: " + doc3.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}