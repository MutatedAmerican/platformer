package com.diazb.platformer.controller;

import com.diazb.platformer.model.Player;

public class PlayerController {
    //create new variables to display map
    public static Player player;

    public static void initializeController(){
        //render the player
        player= new Player(70, 100);
    }

    public static void update(float deltaTime){
        //update character position constantly
        player.update(deltaTime);
    }
}
