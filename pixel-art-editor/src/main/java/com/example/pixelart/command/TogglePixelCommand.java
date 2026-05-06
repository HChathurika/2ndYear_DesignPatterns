package com.example.pixelart.command;

import com.example.pixelart.editor.PixelEditor;

public class TogglePixelCommand implements Command {
    private PixelEditor editor;
    public TogglePixelCommand(PixelEditor editor) { this.editor = editor; }
    public void execute() { editor.togglePixel(); }
}