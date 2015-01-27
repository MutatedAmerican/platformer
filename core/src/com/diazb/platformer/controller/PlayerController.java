package com.diazb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.diazb.platformer.model.Player;

public class PlayerController {
    //create new variables to display map
    public static Player player;
    public static String movementAction;
    public static String specialAction;
    //
    private static final float VELOCITY= 1f;
    //
    private static final float VELOCITY2= -1f;
    //
    private static final float MAX_VELOCITY= 5f;
    //
    private static final float JUMP_VELOCITY= 1f;

    public static void initializeController(){
        //render the player
        player= new Player(new Vector2(8, 8), 70, 100, "img/aliens.png");
        movementAction= "";
        specialAction= "";
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
        if(movementAction.equalsIgnoreCase("right")){
            //
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
        }

        //
        if(movementAction.equalsIgnoreCase("left")){
            //
            player.physicsBody.applyLinearImpulse(VELOCITY2, 0f, position.x, position.y, true);
        }

        //
        if(movementAction.equalsIgnoreCase("jump")){
            //
            player.physicsBody.applyLinearImpulse(0f, JUMP_VELOCITY, position.x, position.y, true);
        }

        //
        /*if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            //
            player.physicsBody.applyLinearImpulse(VELOCITY2, 0f, position.x, position.y, true);
        }*/
    }
}
