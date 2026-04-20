package com.example.chatapp;

public interface ChatClient {
    String getUsername();
    void receiveMessage(String message);
}