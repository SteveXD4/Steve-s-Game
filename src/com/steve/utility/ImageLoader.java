package com.steve.utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImageLoader {
    private static ArrayList<ImageLoader> ImgList;
    private static boolean done = false;

    private BufferedImage img;
    private String ID;

    public ImageLoader() {
        if (done)
            return;
        ImgList = new ArrayList<>();
        load();
        done = true;
    }

    private ImageLoader(String ID, String path) {
        System.out.print("Loading File: " + path + "...");
        try {
            img = ImageIO.read(new FileInputStream(new File(path)));
            this.ID = ID;
            ImgList.add(this);
            System.out.println("was loaded successfully!");
        } catch (IOException e) {
            System.err.println("failed");
            e.printStackTrace();
        }
    }

    private void load() {
        new ImageLoader("DOWN_fish_f1", "res/Sprites/fish/down_fish_f1.png");
        new ImageLoader("DOWN_fish_f2", "res/Sprites/fish/down_fish_f2.png");
        new ImageLoader("DOWN_fish_f3", "res/Sprites/fish/down_fish_f3.png");
        new ImageLoader("man_standing", "res/Sprites/man/man_standing.png");
        new ImageLoader("man_walking_f1", "res/Sprites/man/man_walking_f1.png");
        new ImageLoader("man_walking_f2", "res/Sprites/man/man_walking_f2.png");
        {//tiles
            {//grass tile
                new ImageLoader("Tile_Grass_f1", "res/Sprites/tiles/ground/grass/Tile_grass_f1.png");
                new ImageLoader("Tile_Grass_f2", "res/Sprites/tiles/ground/grass/Tile_grass_f2.png");
            }
        }
        {//ores
            {//ore size 1
                new ImageLoader("iron_ore_s1_a1", "res/Sprites/tiles/ore/iron ore/size 1/iron_ore_s1_a1.png");
                new ImageLoader("iron_ore_s1_a2", "res/Sprites/tiles/ore/iron ore/size 1/iron_ore_s1_a2.png");
                new ImageLoader("iron_ore_s1_a3", "res/Sprites/tiles/ore/iron ore/size 1/iron_ore_s1_a3.png");
                new ImageLoader("iron_ore_s1_a4", "res/Sprites/tiles/ore/iron ore/size 1/iron_ore_s1_a4.png");
            }
            {//ore size 2
                new ImageLoader("iron_ore_s2_a1", "res/Sprites/tiles/ore/iron ore/size 2/iron_ore_s2_a1.png");
                new ImageLoader("iron_ore_s2_a2", "res/Sprites/tiles/ore/iron ore/size 2/iron_ore_s2_a2.png");
                new ImageLoader("iron_ore_s2_a3", "res/Sprites/tiles/ore/iron ore/size 2/iron_ore_s2_a3.png");
                new ImageLoader("iron_ore_s2_a4", "res/Sprites/tiles/ore/iron ore/size 2/iron_ore_s2_a4.png");
            }
            {//ore size 3
                new ImageLoader("iron_ore_s3_a1", "res/Sprites/tiles/ore/iron ore/size 3/iron_ore_s3_a1.png");
                new ImageLoader("iron_ore_s3_a2", "res/Sprites/tiles/ore/iron ore/size 3/iron_ore_s3_a2.png");
                new ImageLoader("iron_ore_s3_a3", "res/Sprites/tiles/ore/iron ore/size 3/iron_ore_s3_a3.png");
                new ImageLoader("iron_ore_s3_a4", "res/Sprites/tiles/ore/iron ore/size 3/iron_ore_s3_a4.png");
            }
            {//ore size 4
                new ImageLoader("iron_ore_s4_a1", "res/Sprites/tiles/ore/iron ore/size 4/iron_ore_s4_a1.png");
                new ImageLoader("iron_ore_s4_a2", "res/Sprites/tiles/ore/iron ore/size 4/iron_ore_s4_a2.png");
                new ImageLoader("iron_ore_s4_a3", "res/Sprites/tiles/ore/iron ore/size 4/iron_ore_s4_a3.png");
                new ImageLoader("iron_ore_s4_a4", "res/Sprites/tiles/ore/iron ore/size 4/iron_ore_s4_a4.png");
            }
        }
        {//items
            new ImageLoader("itemtemplate", "res/Sprites/items/itemtemplate.png");
        }
        {//temp
            new ImageLoader("inventory", "res/Inventory.png");
        }
        {//decoration
            new ImageLoader("tree_f1","res/sprites/decoration/trees/tree_f1.png");
            new ImageLoader("tree_f2","res/sprites/decoration/trees/tree_f2.png");
            new ImageLoader("tree_f3","res/sprites/decoration/trees/tree_f3.png");

        }

    }

    public static BufferedImage getImgByID(String ID) {
        for (int i = 0; i < ImgList.size(); i++) {
            if (ImgList.get(i).getID().equals(ID))
                return ImgList.get(i).getImg();
        }
        return null;
    }

    private String getID() {
        return this.ID;
    }

    private BufferedImage getImg() {
        return this.img;
    }
}
