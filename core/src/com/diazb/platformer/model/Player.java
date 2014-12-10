package com.diazb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    //create x and y position of the character on screen
    public Vector2 position;
    //create animation of player by sprite sheet
    public Animation animation;
    //create storage to put java.sprite-sheet
    public Spritesheet spritesheet;
    //store in width of sprite sheet
    public int width;
    //store in height of sprite sheet
    public int height;
    //create the time of change frame of animation
    private float stateTime;

    //generate constructor for player
    public Player() {
        //origin at the screen [(0,0) is bottom left]
        position= new Vector2(8, 8);
        //store in number of pixels as width
        width= 70;
        //store in number of pixels as height
        height= 100;
        //store sprite-sheet.java in variable to use
        spritesheet= new Spritesheet("img/aliens.png", width, height);
        //store in animation inside variable
        animation= spritesheet.createAnimation();
        //game time; counter of the game
        stateTime= 0f;
    }

    //draw character
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));
    }
    //update properties on the character constantly
    public void update(float deltaTime){
        stateTime+= deltaTime;
        position.y+= deltaTime;
    }
}
