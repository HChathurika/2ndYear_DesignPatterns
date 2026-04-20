package com.example.chatapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientController implements ChatClient {
    private final String username;
    private final ChatMediator mediator;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientBox;

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    public void showStage() {
        Stage stage = new Stage();
        stage.setTitle(username);

        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setPrefHeight(250);

        messageField = new TextField();
        messageField.setPromptText("Type message");

        recipientBox = new ComboBox<>();
        for (String name : mediator.getClientNames()) {
            if (!name.equals(username)) {
                recipientBox.getItems().add(name);
            }
        }

        if (!recipientBox.getItems().isEmpty()) {
            recipientBox.setValue(recipientBox.getItems().get(0));
        }

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        VBox root = new VBox(10, chatArea, recipientBox, messageField, sendButton);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 350);
        stage.setScene(scene);
        stage.show();
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        String recipient = recipientBox.getValue();

        if (!message.isEmpty() && recipient != null) {
            mediator.sendMessage(message, username, recipient);
            messageField.clear();
        }
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void receiveMessage(String message) {
        chatArea.appendText(message + "\n");
    }
}