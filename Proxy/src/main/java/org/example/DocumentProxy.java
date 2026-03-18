package org.example;

import java.time.LocalDate;

public class DocumentProxy implements DocumentInterface {
    private final Document realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        }
        throw new AccessDeniedException("Access denied for user: " + user.getUsername()
                + " to document: " + realDocument.getId());
    }
}