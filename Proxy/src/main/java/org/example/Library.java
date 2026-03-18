package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, DocumentInterface> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addUnprotectedDocument(String id, LocalDate creationDate, String content) {
        Document document = new Document(id, creationDate, content);
        documents.put(id, document);
    }

    public void addProtectedDocument(String id, LocalDate creationDate, String content) {
        Document realDocument = new Document(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }

    public void listDocuments() {
        for (DocumentInterface document : documents.values()) {
            System.out.println("Document ID: " + document.getId()
                    + ", Creation Date: " + document.getCreationDate());
        }
    }
}