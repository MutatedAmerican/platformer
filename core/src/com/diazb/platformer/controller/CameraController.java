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
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0);
        //able to render the map once the camera is on the move
        camera.update();
        
    }

    public static Vector3 clamp(float min, float max){
        inputCamera.zoom = MathUtils.clamp(inputCamera.zoom, 0.1f, 100/inputCamera.viewportWidth);

        float effectiveViewportWidth = inputCamera.viewportWidth * inputCamera.zoom;
        float effectiveViewportHeight = inputCamera.viewportHeight * inputCamera.zoom;

        float positionx = MathUtils.clamp(inputCamera.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
        float positiony = MathUtils.clamp(inputCamera.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
        return new Vector3(float positionx, float positiony, 0f);
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
