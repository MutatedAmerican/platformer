package com.diazb.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.diazb.platformer.controller.LevelController;

public class Player extends Sprite{

    //generate constructor for player
    public Player(Vector2 position, int width,int height, String sheetPath) {
        //call in parent function
        super(position, width, height, sheetPath);
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

        //set body definition in game world and set position
        BodyDef bodyDefinition= new BodyDef();
        bodyDefinition.type= BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
        //create body in game world
        physicsBody= LevelController.gameWorld.createBody(bodyDefinition);
        //create shape in game world
        physicsBody.setUserData(this);
        //
        physicsBody.setFixedRotation(true);
        //create polygon shape
        PolygonShape rectangleShape= new PolygonShape();
        //set height
        rectangleShape.setAsBox(this.width/2f, this.height/2f, new Vector2(this.width/2f, this.height/2f), 0f);
        //create new fixture definition
        FixtureDef fixtureDefinition= new FixtureDef();
        //attach shape to out body
        fixtureDefinition.shape= rectangleShape;
        //
        fixtureDefinition.density=1f;
        //apply shape to player body
        physicsBody.createFixture(fixtureDefinition);
        //deletes the shape
        rectangleShape.dispose();
    }
    //draw character
    public void draw(Batch spriteBatch){
        super.draw(spriteBatch);
    }
    //update properties on the character constantly
    public void update(float deltaTime){
        super.update(deltaTime);
    }
}
