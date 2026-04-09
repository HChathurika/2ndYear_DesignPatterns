package com.example.rpgmap;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {

    private final Map<TileType, Image> sharedImages = new HashMap<>();

    public Image getImage(TileType type) {
        if (!sharedImages.containsKey(type)) {
            sharedImages.put(type, loadImage(type));
        }
        return sharedImages.get(type);
    }

    private Image loadImage(TileType type) {
        String path;

        switch (type) {
            case GRASS:
                path = "/images/grass.jpg";
                break;
            case WATER:
                path = "/images/water.jpg";
                break;
            case SAND:
                path = "/images/sand.jpg";
                break;
            case FOREST:
                path = "/images/forest.jpg";
                break;
            default:
                throw new IllegalArgumentException("Unknown tile type: " + type);
        }

        InputStream stream = getClass().getResourceAsStream(path);

        if (stream == null) {
            throw new RuntimeException("Image not found: " + path);
        }

        return new Image(stream);
    }
}