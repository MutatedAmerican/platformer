package com.diazb.platformer;

import com.badlogic.gdx.Game;
import com.diazb.platformer.controller.GameController;
import com.diazb.platformer.view.GameScreen;
import com.diazb.platformer.view.StartScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        GameController.initializeController(this);
        //set screen and display level
        setScreen(new StartScreen());
    }
}
