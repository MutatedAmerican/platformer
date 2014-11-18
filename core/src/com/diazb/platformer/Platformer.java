package com.diazb.platformer;

import com.badlogic.gdx.Game;
import com.diazb.platformer.view.GameScreen;

public class Platformer extends Game {
    
    @Override
    public void create() {
        //set screen and display level
        setScreen(new GameScreen());
    }
}
