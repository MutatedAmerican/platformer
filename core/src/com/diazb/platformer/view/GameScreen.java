package com.diazb.platformer.view;
//package and import classes

import com.badlogic.gdx.Screen;
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
        //create camera's length and height variables
        camera= new OrthographicCamera(14f, 14f);
    }

    @Override
    public void render(float delta) {
        //able to render the map once the camera is on the move
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        //W.i.P

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
