package com.example.pixelart.command;

import com.example.pixelart.editor.PixelEditor;



public class GenerateCodeCommand implements Command {
    private PixelEditor editor;

    public GenerateCodeCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        System.out.println(editor.generateCode());
    }
}