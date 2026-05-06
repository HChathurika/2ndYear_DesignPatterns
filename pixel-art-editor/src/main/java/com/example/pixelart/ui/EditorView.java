package com.example.pixelart.ui;

import com.example.pixelart.editor.PixelEditor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class EditorView extends VBox {

    private static final int CELL_SIZE = 40;
    private Canvas canvas;

    public EditorView(PixelEditor editor) {
        canvas = new Canvas(8 * CELL_SIZE, 8 * CELL_SIZE);
        draw(editor);
        getChildren().add(canvas);
    }

    public void draw(PixelEditor editor) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (editor.getGrid()[i][j] == 1) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }

                gc.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.setStroke(Color.GRAY);
                gc.strokeRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Cursor
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeRect(editor.getCursorCol() * CELL_SIZE,
                editor.getCursorRow() * CELL_SIZE,
                CELL_SIZE, CELL_SIZE);
    }
}