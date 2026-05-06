package com.example.pixelart.command;

import com.example.pixelart.editor.PixelEditor;

public class MoveCursorDownCommand implements Command {
    private PixelEditor editor;
    public MoveCursorDownCommand(PixelEditor editor) { this.editor = editor; }
    public void execute() { editor.moveDown(); }
}