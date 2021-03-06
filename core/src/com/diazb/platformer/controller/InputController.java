package com.diazb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.diazb.platformer.model.InputControl;
import com.diazb.platformer.model.Spritesheet;
import java.util.ArrayList;

public class InputController {
    private static Spritesheet spriteSheet;
    private static ArrayList<InputControl> inputControls;
    private static InputControl left;
    private static InputControl right;
    private static InputControl jump;
    private static InputControl duck;

    public static void initializeController() {
        spriteSheet = new Spritesheet("img/touch-controls.png", 80, 80);
        inputControls = new ArrayList<InputControl>();
        left = new InputControl(new Vector2(0, 1), spriteSheet.spriteFrames[0], "left");
        right = new InputControl(new Vector2(2, 1), spriteSheet.spriteFrames[1], "right");
        jump = new InputControl(new Vector2(1, 2), spriteSheet.spriteFrames[2], "jump");
        duck = new InputControl(new Vector2(1, 0), spriteSheet.spriteFrames[3], "duck");
        inputControls.add(left);
        inputControls.add(right);
        inputControls.add(jump);
        inputControls.add(duck);
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        for (InputControl inputControl : inputControls) {
            inputControl.draw(spriteBatch);
        }
        left.draw(spriteBatch);
        right.draw(spriteBatch);
        jump.draw(spriteBatch);
        duck.draw(spriteBatch);
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter() {
        return new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                for (InputControl inputControl : inputControls) {
                    if (inputControl.getBoundingBox().contains(screenX, screenY)) {
                        if (inputControl.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "left";
                        } else if (inputControl.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "right";
                        }
                        else if (inputControl.action.equalsIgnoreCase("jump")) {
                            PlayerController.specialAction = "jump";
                            MusicController.sound.play();
                        }
                        else if (inputControl.action.equalsIgnoreCase("duck")) {
                            PlayerController.specialAction = "duck";
                        }
                    }
                }

                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                for (InputControl inputControl : inputControls) {
                    if (inputControl.getBoundingBox().contains(screenX, screenY)) {
                        if (inputControl.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "";
                        } else if (inputControl.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "";
                        }
                        else if (inputControl.action.equalsIgnoreCase("jump")) {
                            PlayerController.specialAction = "";
                        }
                        else if (inputControl.action.equalsIgnoreCase("duck")) {
                            PlayerController.specialAction = "";
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean keyDown(int keycode) {
                if (keycode== Input.Keys.RIGHT){
                    PlayerController.movementAction= "right";
                }
                else if (keycode== Input.Keys.LEFT){
                    PlayerController.movementAction= "left";
                }
                else if (keycode== Input.Keys.UP){
                    PlayerController.specialAction= "jump";
                    MusicController.sound.play();
                }
                else if (keycode== Input.Keys.DOWN){
                    PlayerController.specialAction= "duck";
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if (keycode== Input.Keys.RIGHT){
                    PlayerController.movementAction= "";
                }
                else if (keycode== Input.Keys.LEFT){
                    PlayerController.movementAction= "";
                }
                else if (keycode== Input.Keys.UP){
                    PlayerController.specialAction= "";
                }
                else if (keycode== Input.Keys.DOWN){
                    PlayerController.specialAction= "";
                }
                return true;
            }
        };
    }
}