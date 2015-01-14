package com.diazb.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.diazb.platformer.model.Level;
import com.diazb.platformer.model.Player;
import com.diazb.platformer.model.Sprite;

public class LevelController {
    //create new variables to display map
    public static final float UNIT_SCALE= 1/70f;
    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static World gameWorld;
    private static Array <Body> worldBodies;
    public static Batch spriteBatch;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        //store in world
        level= new Level("map/level0-1.tmx");
        //render up tiles on the map
        renderer= new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);
        //apply gravity to the game
        gameWorld= new World(new Vector2(0, 0), true);
        //
        worldBodies= new Array<Body>();
        //display shapes
        debugRenderer= new Box2DDebugRenderer();
        //enable to group draw 2-D sprites on the screen at once
        spriteBatch = renderer.getSpriteBatch();
}
    public static void draw(){
        //call on sprite batch to start drawing, then end
        spriteBatch.begin();
        //use sprite batch object to draw the player
        PlayerController.player.draw(spriteBatch);
        spriteBatch.end();
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update(){
        renderer.setView(CameraController.camera);
        renderer.render();
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1);
    }

    private static void updateWorldBodies(){
        //constantly update and empty out content in array; such as coins
        worldBodies.clear();
        //get all bodies in array and paste it
        gameWorld.getBodies(worldBodies);

        for(Body body: worldBodies){
            //get player's data
            Sprite spriteBody= (Sprite)body.getUserData();
            //access to its body position
            spriteBody.position= body.getPosition();
        }
    }
}