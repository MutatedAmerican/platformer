package com.diazb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Player {
    //create x and y position of the character on screen
    public Vector2 position;
    //create storage to put java.sprite-sheet
    public Spritesheet spritesheet;
    //store in width of sprite sheet
    public int width;
    //store in height of sprite sheet
    public int height;
    //create the time of change frame of animation
    private float stateTime;
    //create storage for animations
    private HashMap<String, Animation> animations;

    //generate constructor for player
    public Player() {
        //origin at the screen [(0,0) is bottom left]
        position= new Vector2(8, 8);
        //store in animations
        animations= new HashMap<String, Animation>();
        //store in number of pixels as width
        width= 70;
        //store in number of pixels as height
        height= 100;
        //store sprite-sheet.java in variable to use
        spritesheet= new Spritesheet("img/aliens.png", width, height);
        //store in animations
        animations.put("walk", spritesheet.createAnimation(31, 32, .1f));
        animations.put("swim", spritesheet.createAnimation(29, 30, .1f));
        animations.put("jump", spritesheet.createAnimation(27, 28, .1f));
        animations.put("hurt", spritesheet.createAnimation(26, 26, .1f));
        animations.put("duck", spritesheet.createAnimation(25, 25, .1f));
        animations.put("climb", spritesheet.createAnimation(23, 24, .1f));
        animations.put("stand", spritesheet.createAnimation(22, 22, .1f));
        //flip animation
        animations.put("walkFlip", spritesheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("swimFlip", spritesheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("jumpFlip", spritesheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("hurtFlip", spritesheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("duckFlip", spritesheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("climbFlip", spritesheet.flipAnimation(animations.get("climb"), true, false));
        animations.put("standFlip", spritesheet.flipAnimation(animations.get("stand"), true, false));
        //game time; counter of the game
        stateTime= 0f;
    }
    //draw character
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get("walk").getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));
    }
    //update properties on the character constantly
    public void update(float deltaTime){
        stateTime+= deltaTime;
        //select direction of character
        position.x+= deltaTime;

    }
}
