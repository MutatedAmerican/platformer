package com.diazb.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;

    public Level(String mapPath){
        //load up level map from my asset folder
        map = new TmxMapLoader().load(mapPath);
    }

    public MapLayer getMapLayer(String layerName){
        //get layer inside in level
        return map.getLayers().get(layerName);
    }

    public MapObjects getMapObjects(MapLayer mapLayer){
        //get objects found in level
        return mapLayer.getObjects();
    }
}
