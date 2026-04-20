package com.example.chatapp;

import java.util.List;

public interface ChatMediator {
    void registerClient(ChatClient client);
    void sendMessage(String message, String sender, String recipient);
    List<String> getClientNames();
}