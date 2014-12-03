package com.diazb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    //create x and y position on screen
    public Vector2 position;
    //store image on the screen
    public Texture spriteSheet;

    //generate constructor for player
    public Player() {
        //origin at the screen [(0,0) is bottom left]
        position= new Vector2(0, 0);
        //path to get texture to store the player images
        spriteSheet= new Texture(Gdx.files.internal("img/aliens.png"));
    }
    //draw character
    public void draw(Batch spriteBatch){
        spriteBatch.draw(spriteSheet, 0, 0, 70, 100);
    }
    //update properties on the character constantly
    public void update(float deltaTime){

    }
}
