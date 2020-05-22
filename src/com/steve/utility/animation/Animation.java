package com.steve.utility.animation;

import com.steve.utility.ImageLoader;

import java.awt.image.BufferedImage;

public class Animation {
    private final BufferedImage[] imgs;
    private BufferedImage current;
    private int frame = 0, rate = 10, length = -1, time = 0;

    public Animation(int SIZE) {
        length = SIZE;
        imgs = new BufferedImage[SIZE];
    }

    public void addImg(BufferedImage img) {
        for (int i = 0; i < imgs.length; i++)
            if (imgs[i] == null) {
                imgs[i] = img;
                return;
            }
    }

    public void tick() {
        time++;
        if (time % rate == 0) {
            if (frame >= length - 1)
                frame = 0;
            else
                frame++;
            current = imgs[frame];
        }
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public BufferedImage getImg() {
        return current;
    }

    public void SetFrame(int frame) {
        if (frame > imgs.length - 1) {
            System.out.println("sup nigga");
            return;
        }
        current = imgs[frame];
    }

    public static Animation fishAnimation() {
        Animation animation = new Animation(3);
        animation.addImg(ImageLoader.getImgByID("DOWN_fish_f1"));
        animation.addImg(ImageLoader.getImgByID("DOWN_fish_f2"));
        animation.addImg(ImageLoader.getImgByID("DOWN_fish_f3"));
        return animation;
    }

    public static Animation manAnimation() {
        Animation animation = new Animation(3);
        animation.addImg(ImageLoader.getImgByID("man_standing"));
        animation.addImg(ImageLoader.getImgByID("man_walking_f1"));
        animation.addImg(ImageLoader.getImgByID("man_walking_f2"));
        return animation;
    }
    public static Animation treeAnimation() {
        Animation animation = new Animation(4);
        animation.addImg(ImageLoader.getImgByID("tree_f1"));
        animation.addImg(ImageLoader.getImgByID("tree_f2"));
        animation.addImg(ImageLoader.getImgByID("tree_f3"));
        animation.addImg(ImageLoader.getImgByID("tree_f2"));

        return animation;
    }
}