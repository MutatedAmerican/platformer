package com.diazb.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.diazb.platformer.controller.CameraController;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.diazb.platformer.controller.GameController;

public class StartScreen implements Screen{
    private Texture texture= new Texture(Gdx.files.internal("img/pressstart.jpeg"));
    private Image image= new Image(texture);
    private Stage stage= new Stage();

    public StartScreen(){
        CameraController.initializeController();
    }

    @Override
    public void render(float delta) {
        //set the color of the clear
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        //clear the screen
        Gdx.gl.glClear(GL20. GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        if(Gdx.input.isTouched()){
            GameController.setGameScreen();
        }
    }

    @Override
    public void resize(int width, int height) {
        //resize CameraController
        CameraController.resize(width, height);
    }

    @Override
    public void show() {
        image.setOrigin(0,0);
        image.setWidth(Gdx.graphics.getWidth());
        image.setHeight(Gdx.graphics.getHeight());
        stage.addActor(image);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        texture.dispose();
        stage.dispose();
    }
}
