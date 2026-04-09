package com.example.rpgmap;

public class BasicTileFactory implements TileFactory {

    @Override
    public Tile createTile(TileType type) {
        return new Tile(type);
    }
}