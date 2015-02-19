package com.diazb.platformer.controller;

import com.diazb.platformer.Platformer;
import com.diazb.platformer.view.GameScreen;

public class GameController {
    public static Platformer platformer;

    public static void initializeController(Platformer platformerObject){
        platformer= platformerObject;
    }

    public static void setGameScreen(){
        platformer.setScreen(new GameScreen());
    }
}
