package com.example.pixelart.command;

import com.example.pixelart.editor.PixelEditor;

public class MoveCursorRightCommand implements Command {
    private PixelEditor editor;
    public MoveCursorRightCommand(PixelEditor editor) { this.editor = editor; }
    public void execute() { editor.moveRight(); }
}