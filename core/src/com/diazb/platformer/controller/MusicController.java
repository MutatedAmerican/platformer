package com.diazb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

public class MusicController {
    public static Music music;

    protected static Sound sound;

    public static void initializeMusicController(){
        music = Gdx.audio.newMusic(Gdx.files.internal("music/backgroundsong.mp3"));
        sound = Gdx.audio.newSound(Gdx.files.internal("music/jumpsound.mp3"));
    }

    public static void play(String soundName){
        if (soundName.equalsIgnoreCase("music")){
            music.play();
            //sound.play(1.0f);
            // sets the volume to half the maximum volume
            music.setVolume(0.5f);
            // will repeat playback until music.stop() is called
            music.setLooping(true);
        }

        if (soundName.equalsIgnoreCase("sound")){
            sound.play(1.0f);
        }
    }


}
