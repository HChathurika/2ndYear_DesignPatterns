package com.example.rpgmap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class MapRenderer {

    private final TileGraphicFactory tileGraphicFactory;
    private final int tileSize;

    public MapRenderer(TileGraphicFactory tileGraphicFactory, int tileSize) {
        this.tileGraphicFactory = tileGraphicFactory;
        this.tileSize = tileSize;
    }

    public void render(GameMap gameMap, GraphicsContext gc) {
        for (int row = 0; row < gameMap.getRows(); row++) {
            for (int col = 0; col < gameMap.getCols(); col++) {
                Tile tile = gameMap.getTile(row, col);
                Image image = tileGraphicFactory.getImage(tile.getType());

                int x = col * tileSize;
                int y = row * tileSize;

                gc.drawImage(image, x, y, tileSize, tileSize);
                gc.setStroke(Color.BLACK);
                gc.strokeRect(x, y, tileSize, tileSize);
            }
        }
    }
}