package com.diazb.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.diazb.platformer.controller.LevelController;

public class Enemy extends Sprite{

    //generate constructor for player
    public Enemy(Vector2 position, int width,int height, String sheetPath) {
        //call in parent function
        super(position, width, height, sheetPath);
        //store in animations
        animations.put("block", spritesheet.createAnimation(0, 1, .1f));

        //set body definition in game world and set position
        BodyDef bodyDefinition= new BodyDef();
        bodyDefinition.type= BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
        //create body in game world
        physicsBody= LevelController.gameWorld.createBody(bodyDefinition);
        //create shape in game world
        physicsBody.setUserData(this);
        //create polygon shape
        PolygonShape rectangleShape= new PolygonShape();
        //set height
        rectangleShape.setAsBox(this.width/2f, this.height/2f, new Vector2(this.width/2f, this.height/2f), 0f);
        //create new fixture definition
        FixtureDef fixtureDefinition= new FixtureDef();
        //attach shape to out body
        fixtureDefinition.shape= rectangleShape;
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
