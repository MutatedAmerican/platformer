package com.diazb.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;

    public Level(String mapPath){
        //load up level map from my asset folder
        map = new TmxMapLoader().load(mapPath);
    }
}
