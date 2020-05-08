package com.steve.worldgen.tiles;

import com.steve.worldgen.Tile;
import com.steve.utility.ImageLoader;

public class TileGrass extends Tile {

    public TileGrass(int x, int y) {
        super(x, y, ImageLoader.getImgByID("Tile_Grass"));
    }
}
