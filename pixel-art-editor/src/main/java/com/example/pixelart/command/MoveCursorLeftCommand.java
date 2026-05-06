package com.example.pixelart.command;

import com.example.pixelart.editor.PixelEditor;

public class MoveCursorLeftCommand implements Command {
    private PixelEditor editor;
    public MoveCursorLeftCommand(PixelEditor editor) { this.editor = editor; }
    public void execute() { editor.moveLeft(); }
}