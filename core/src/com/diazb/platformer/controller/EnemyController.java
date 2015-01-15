package com.diazb.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.diazb.platformer.model.Enemy;

public class EnemyController{
    //create new variables to display map
    public static Enemy enemy;

    public static void initializeController(){
        //render the player
        enemy= new Enemy(new Vector2(4, 8), 51, 58, "img/enemy-barnacle.png");
    }

    public static void update(float deltaTime){
        //update character position constantly
        enemy.update(deltaTime);
    }
 }
