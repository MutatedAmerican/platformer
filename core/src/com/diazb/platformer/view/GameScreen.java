package com.diazb.platformer.view;
//package and import classes

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen{
    //create new variables to display map
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        //load up level map from my asset folder
        map = new TmxMapLoader().load("map/level0-1.tmx");
        //render up tiles on the map
        renderer= new OrthogonalTiledMapRenderer(map, 1/70f);
        //get the height and width of the screen and store them into variables
        float width= Gdx.graphics.getWidth();
        float height= Gdx.graphics.getHeight();
        //create camera's length and height variables
        //modify code to change aspect ratio
        camera= new OrthographicCamera(14f, 26f * (height/width));
        //set the position of the camera on the level
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f, 0f);
    }

    @Override
    public void render(float delta) {
        //set the color of the clear
        Gdx.gl.glClearColor(0.81f, 0.98f, 1f, 1f);
        //clear the screen
        Gdx.gl.glClear(GL20. GL_COLOR_BUFFER_BIT);

        //able to render the map once the camera is on the move
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        //call on camera object and set viewportWidth and viewportHeight
        camera.viewportWidth= 14f;
        camera.viewportHeight= 14f * height/width;
        //update camera
        camera.update();
    }

    @Override
    public void show() {
        //W.i.P

    }

    @Override
    public void hide() {
        //W.i.P
    }

    @Override
    public void pause() {
        //W.i.P
    }

    @Override
    public void resume() {
        //W.i.P
    }

    @Override
    public void dispose() {
        //W.i.P
    }
}
