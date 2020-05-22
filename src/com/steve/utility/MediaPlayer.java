package com.steve.utility;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayList;

public class MediaPlayer {
    public static ArrayList<MediaPlayer> MusicList;
    private static boolean done = false;

    private AudioClip c;
    private String ID;

    public MediaPlayer() {
        if (done)
            return;
        MusicList = new ArrayList<>();
        load();
        done = true;
    }

    private void load() {
        new MediaPlayer("Hit_Hurt3", "/Sounds/Hit_Hurt3.mp3");
        //new MediaPlayer("Randomize8", "/Sounds/Randomize8.mp3");
    }

    public MediaPlayer(String ID, String path) {
        try {
            System.out.print("Loading File: " + path + "...");
            c = Applet.newAudioClip(MediaPlayer.class.getResource(path));
            this.ID = ID;
            System.out.println("was loaded successfully!");
            MusicList.add(this);
        } catch (Exception e) {
            System.err.println("failed");
            e.printStackTrace();
        }
    }

    public static void PlayByID(String ID) {
        try {
            new Thread() {
                public void run() {
                    for (int i = 0; i < MusicList.size(); i++)
                        if (MusicList.get(i).getID() == ID)
                            MusicList.get(i).getPlayer().play();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getID() {
        return this.ID;
    }

    private AudioClip getPlayer() {
        return c;
    }
}
