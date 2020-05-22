package com.steve.worldgen.tiles;

import com.steve.worldgen.Tile;
import com.steve.utility.ImageLoader;

import java.util.Random;

public class TileGrass extends Tile {

    public TileGrass(int x, int y) {
        super(x, y);
        if (new Random().nextBoolean())
            sprite = ImageLoader.getImgByID("Tile_Grass_f1");
            //if (sprite == null)
        else ImageLoader.getImgByID("Tile_Grass_f2");

    }
}
