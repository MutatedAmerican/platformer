package com.diazb.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.diazb.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    //
    public Body physicsBody;
    //create x and y position of the character on screen
    public Vector2 position;
    //create storage to put java.sprite-sheet
    public Spritesheet spritesheet;
    //store in what is our current animation
    public String currentAnimation;
    //store in width of sprite sheet
    public float width;
    //store in height of sprite sheet
    public float height;
    //create the time of change frame of animation
    protected float stateTime;
    //create storage for animations
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width,int height, String sheetPath){
        //origin at the screen [(0,0) is bottom left]
        this.position= position;
        //initialize animations variable
        animations= new HashMap<String, Animation>();
        //store in number of pixels as width
        this.width= width* (LevelController.UNIT_SCALE);
        //store in number of pixels as height
        this.height= height* (LevelController.UNIT_SCALE);
        //store sprite-sheet.java in variable to use
        spritesheet= new Spritesheet(sheetPath, width, height);
        //store in animation type
        currentAnimation= "walk";
        //game time; counter of the game
        stateTime= 0f;
    }
     //draw character
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }
    //update properties on the character constantly
    public void update(float deltaTime){
        stateTime+= deltaTime;
    }
}
