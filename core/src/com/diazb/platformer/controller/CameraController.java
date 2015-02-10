package com.diazb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class CameraController {

    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static float widthScale;
    public static float heightScale;

    public static float mapHeight;
    public static float mapWidth;

    public static void initializeController(){

        //get the height and width of the screen and store them into variables
        float width= Gdx.graphics.getWidth();
        float height= Gdx.graphics.getHeight();
        //create camera's length and height variables
        //modify code to change aspect ratio
        camera= new OrthographicCamera(14f, 26f * (height/width));
        //set the position of the camera on the level
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f, 0f);
        //
        inputCamera= new OrthographicCamera(14f, 26f * (height/ width));
        inputCamera.position.set(inputCamera.viewportWidth/ 2f,  inputCamera.viewportHeight/ 2f, 0);
        inputCamera.update();
    }

    public static void update(){
        //
        camera.position.set(clamp());
        //able to render the map once the camera is on the move
        camera.update();

    }

    public static Vector3 clamp(){
        mapWidth=60f;
        mapHeight=15f;

        //minHeight;
        //maxHeight;

        //minWidth;
        //maxWidth;

        //float ViewportWidth = camera.viewportWidth * camera;
        //float ViewportHeight = camera.viewportHeight * camera;

        //float positionx = MathUtils.clamp(camera.position.x, ViewportWidth / 2f, 100 - ViewportWidth / 2f);
        //float positiony = MathUtils.clamp(camera.position.y, ViewportHeight / 2f, 100 - ViewportHeight / 2f);
        //return new Vector3(positionx, positiony, 0f);
    }

    public static void resize(int width, int height){
        //call on camera object and set viewportWidth and viewportHeight
        camera.viewportWidth= 14f;
        camera.viewportHeight= 14f * height/width;
        //update camera
        camera.update();

        //
        inputCamera.viewportWidth= 14f;
        inputCamera.viewportHeight= 14f * height / width;
        inputCamera.position.set(inputCamera.viewportWidth/ 2f, inputCamera.viewportHeight/ 2f, 0);
        inputCamera.update();

        //how many pixels make up a unit, width wise
        widthScale= width/ inputCamera.viewportWidth* LevelController.UNIT_SCALE;
        heightScale=height/ inputCamera.viewportWidth* LevelController.UNIT_SCALE;
    }
}
