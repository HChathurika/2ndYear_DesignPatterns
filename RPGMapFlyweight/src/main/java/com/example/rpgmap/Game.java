package com.example.rpgmap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

    private static final int TILE_SIZE = 50;
    private static final int ROWS = 10;
    private static final int COLS = 10;

    @Override
    public void start(Stage stage) {
        TileFactory tileFactory = new BasicTileFactory();
        MapGenerator mapGenerator = new MapGenerator(tileFactory);
        GameMap gameMap = mapGenerator.generateMap(ROWS, COLS);

        Canvas canvas = new Canvas(COLS * TILE_SIZE, ROWS * TILE_SIZE);

        TileGraphicFactory tileGraphicFactory = new TileGraphicFactory();
        MapRenderer mapRenderer = new MapRenderer(tileGraphicFactory, TILE_SIZE);
        mapRenderer.render(gameMap, canvas.getGraphicsContext2D());

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        stage.setTitle("RPG Map Generator - Flyweight Pattern");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}