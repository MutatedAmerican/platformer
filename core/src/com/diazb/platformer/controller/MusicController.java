package com.diazb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

public class MusicController {
    public static Music music;

    protected HashMap<String, Sound> sound;

    public static void initializeMusicController(){
        music = Gdx.audio.newMusic(Gdx.files.internal("music/backgroundsong.mp3"));
        //Sound sound = Gdx.audio.newSound(Gdx.files.internal("music/jumpsound.mp3"));
    }

    public static void play(){
        music.play();
        // sets the volume to half the maximum volume
        music.setVolume(0.5f);
        // will repeat playback until music.stop() is called
        music.setLooping(true);
    }


}
