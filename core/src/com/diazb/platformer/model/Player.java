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
    //store image on the screen
    public Texture spriteSheet;
    //cut up the sprite sheet
    public TextureRegion[] spriteFrames;
    //create animation of player by sprite sheet
    public Animation animation;
    //create the time of change frame of animation
    private float stateTime;

    //generate constructor for player
    public Player() {
        //origin at the screen [(0,0) is bottom left]
        position= new Vector2(8, 8);
        //path to get texture to store the player images
        spriteSheet= new Texture(Gdx.files.internal("img/aliens.png"));
        //splits the sprite sheets into width and height
        TextureRegion[][] spriteSheetFrames= TextureRegion.split(spriteSheet, 70, 100);
        //start at origin
        int counter=0;
        //at the origin, go through the sprite sheet rows
        for(int row= 0; row < spriteSheetFrames.length; row++){
            //at the origin, go through the sprite sheet column
            for(int column= 0; column < spriteSheetFrames[row].length; column++){
                //count how many aliens are in the sprite sheet
                counter++;
            }
        }
        //creates space for all aliens to store in memory
        spriteFrames= new TextureRegion[counter];
        //reset counter
        counter=0;
        //take in spriteSheetFrames and store it in a variable; like wild loop
        for(TextureRegion[] row: spriteSheetFrames){
            //take out each column from row and store it in a variable
            for(TextureRegion sprite: row){
                //access aliens on sprite sheet
                spriteFrames[counter++]= sprite;
            }
        }
        //create new array to store in animation frames
        TextureRegion[] animationFrames= new TextureRegion[2];
        //store in sprite animation sheet inside animationFrames
        animationFrames[0]= spriteFrames[23];
        animationFrames[1]= spriteFrames[24];
        //time take to change frame
        animation= new Animation(0.35f, animationFrames);

        //game time; counter of the game
        stateTime= 0f;
    }
    //draw character
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));
    }
    //update properties on the character constantly
    public void update(float deltaTime){
        stateTime+= deltaTime;
        position.y+= deltaTime;
    }
}
