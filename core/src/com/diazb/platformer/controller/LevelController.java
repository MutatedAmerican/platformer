package com.diazb.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    //create new variables to display map
    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;
    public static World gameWorld;
    public static Batch spriteBatch;
    private static Box2DDebugRenderer debugRenderer;

    public static void initalizeController(){
        //load up level map from my asset folder
        map = new TmxMapLoader().load("map/level0-1.tmx");
        //render up tiles on the map
        renderer= new OrthogonalTiledMapRenderer(map, 1/70f);
        //apply gravity to the game
        gameWorld= new World(new Vector2(0, -10), true);
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
    }
}