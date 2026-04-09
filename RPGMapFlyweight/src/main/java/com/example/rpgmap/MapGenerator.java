package com.example.rpgmap;

import java.util.Random;

public class MapGenerator {
    private final TileFactory tileFactory;
    private final Random random;

    public MapGenerator(TileFactory tileFactory) {
        this.tileFactory = tileFactory;
        this.random = new Random();
    }

    public GameMap generateMap(int rows, int cols) {
        GameMap gameMap = new GameMap(rows, cols);
        TileType[] tileTypes = TileType.values();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType randomType = tileTypes[random.nextInt(tileTypes.length)];
                Tile tile = tileFactory.createTile(randomType);
                gameMap.setTile(row, col, tile);
            }
        }

        return gameMap;
    }
}