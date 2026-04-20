package com.example.chatapp;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomMediator implements ChatMediator {
    private final List<ChatClient> clients = new ArrayList<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.add(client);
    }

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        for (ChatClient client : clients) {
            if (client.getUsername().equals(recipient)) {
                client.receiveMessage("From " + sender + ": " + message);
                break;
            }
        }

        for (ChatClient client : clients) {
            if (client.getUsername().equals(sender)) {
                client.receiveMessage("To " + recipient + ": " + message);
                break;
            }
        }
    }

    @Override
    public List<String> getClientNames() {
        List<String> names = new ArrayList<>();
        for (ChatClient client : clients) {
            names.add(client.getUsername());
        }
        return names;
    }
}