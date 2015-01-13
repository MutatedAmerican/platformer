package com.diazb.platformer.view;
//package and import classes
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.diazb.platformer.controller.CameraController;
import com.diazb.platformer.controller.LevelController;
import com.diazb.platformer.controller.PlayerController;
import com.diazb.platformer.model.Player;

public class GameScreen implements Screen{

    public GameScreen() {
        //initalize LevelController
        LevelController.initializeController();
        //initalize CameraController
        CameraController.initializeController();
        //initalize PlayerController
        PlayerController.initializeController();
    }

    @Override
    public void render(float delta) {
        //set the color of the clear
        Gdx.gl.glClearColor(0.81f, 0.98f, 1f, 1f);
        //clear the screen
        Gdx.gl.glClear(GL20. GL_COLOR_BUFFER_BIT);
        //update CameraController
        CameraController.update();
        //update LevelController
        LevelController.update();
        //update PlayerController
        PlayerController.update(delta);
        //draw LevelController
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        //resize CameraController
        CameraController.resize(width, height);
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
