package com.diazb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.diazb.platformer.controller.LevelController;
import com.diazb.platformer.view.GameScreen;

import java.util.HashMap;

public class Player {
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
    private float stateTime;
    //create storage for animations
    private HashMap<String, Animation> animations;

    //generate constructor for player
    public Player(int width,int height) {
        //origin at the screen [(0,0) is bottom left]
        position= new Vector2(8, 8);
        //initialize animations variable
        animations= new HashMap<String, Animation>();
        //store in number of pixels as width
       this.width= width* (1/70f);
        //store in number of pixels as height
        this.height= height* (1/70f);
        //store sprite-sheet.java in variable to use
        spritesheet= new Spritesheet("img/aliens.png", width, height);
        //store in animations
        animations.put("walk", spritesheet.createAnimation(31, 32, .1f));
        animations.put("swim", spritesheet.createAnimation(29, 30, .1f));
        animations.put("start", spritesheet.createAnimation(28, 28, .1f));
        animations.put("jump", spritesheet.createAnimation(27, 27, .1f));
        animations.put("hurt", spritesheet.createAnimation(26, 26, .1f));
        animations.put("duck", spritesheet.createAnimation(25, 25, .1f));
        animations.put("climb", spritesheet.createAnimation(23, 24, .1f));
        animations.put("stand", spritesheet.createAnimation(22, 22, .1f));
        //flip animation
        animations.put("walkFlip", spritesheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("swimFlip", spritesheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("startFlip", spritesheet.flipAnimation(animations.get("start"), true, false));
        animations.put("jumpFlip", spritesheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("hurtFlip", spritesheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("duckFlip", spritesheet.flipAnimation(animations.get("duck"), true, false));
        //store in animation type
        currentAnimation= "walk";
        //game time; counter of the game
        stateTime= 0f;

        //set body definition in game world and set position
        BodyDef bodyDefinition= new BodyDef();
        bodyDefinition.type= BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        //create body in game world
        Body playerBody= LevelController.gameWorld.createBody(bodyDefinition);
        //create shape in game world
        playerBody.setUserData(this);
        //create polygon shape
        PolygonShape rectangleShape= new PolygonShape();
        //set height
        rectangleShape.setAsBox(this.width/2f, this.height/2f, new Vector2(this.width/2f, this.height/2f), 0f);
        //create new fixture definition
        FixtureDef fixturedefinition= new FixtureDef();
        //attach shape to out body
        fixturedefinition.shape= rectangleShape;
        //apply shape to player body
        playerBody.createFixture(fixturedefinition);
        //deletes the shape
        rectangleShape.dispose();
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
