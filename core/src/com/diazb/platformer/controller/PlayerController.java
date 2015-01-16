package com.diazb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.diazb.platformer.model.Player;

public class PlayerController {
    //create new variables to display map
    public static Player player;
    //
    private static final float VELOCITY= 1f;
    //
    private static final float VELOCITY2= -1f;
    //
    private static final float MAX_VELOCITY= 5f;

    public static void initializeController(){
        //render the player
        player= new Player(new Vector2(8, 8), 70, 100, "img/aliens.png");
    }

    public static void update(float deltaTime){
        //
        handleInput();
        //update character position constantly
        player.update(deltaTime);
    }

    private static void handleInput(){
        //handle keyboard input
        Vector2 velocity= player.physicsBody.getLinearVelocity();
        Vector2 position= player.physicsBody.getPosition();

        //
        if(Math.abs(velocity.x)> MAX_VELOCITY){
            velocity.x= Math.signum(velocity.x)* MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        //
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            //
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
        }

        //
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            //
            player.physicsBody.applyLinearImpulse(VELOCITY2, 0f, position.x, position.y, true);
        }

        //
        /*if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            //
            player.physicsBody.applyLinearImpulse(VELOCITY2, 0f, position.x, position.y, true);
        }*/

        //
        /*if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            //
            player.physicsBody.applyLinearImpulse(VELOCITY2, 0f, position.x, position.y, true);
        }*/
    }
}
