package com.diazb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {

    //store image on the screen
    public Texture spriteSheet;
    //cut up the sprite sheet
    public TextureRegion[] spriteFrames;
    //create animation of player by sprite sheet
    public Animation animation;

    public Spritesheet(String pathToFile, int width, int height) {

        //path to get texture to store the player images
        spriteSheet= new Texture(Gdx.files.internal(pathToFile));
        //splits the sprite sheets into width and height
        TextureRegion[][] spriteSheetFrames= TextureRegion.split(spriteSheet, width, height);
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

    }

    public Animation createAnimation(){
        //create new array to store in animation frames
        TextureRegion[] animationFrames= new TextureRegion[2];
        //store in sprite animation sheet inside animationFrames
        animationFrames[0]= spriteFrames[23];
        animationFrames[1]= spriteFrames[24];
        return animation;
    }
}
