package com.diazb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.diazb.platformer.model.InputControl;
import com.diazb.platformer.model.Spritesheet;

public class InputController {
        private static Spritesheet spriteSheet;
        private static InputControl left;
        private static InputControl right;

    public static void initializeController(){
        spriteSheet= new Spritesheet("img/touch-controls.png", 80, 80);
        left= new InputControl(new Vector2(0,4), spriteSheet.spriteFrames[0], "left");
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch){
        spriteBatch.begin();
        left.draw(spriteBatch);
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter(){
        return new InputAdapter(){
            @Override
                public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                PlayerController.movementAction= "right";
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                PlayerController.movementAction= "right";
                return true;
            }
        };
    }
}
