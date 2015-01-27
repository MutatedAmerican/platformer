package com.diazb.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.diazb.platformer.controller.LevelController;

public class Bodies {

    public static void createBody(MapObject mapObject){
        String bodyType =mapObject.getProperties().get("type").toString();

        if(bodyType.equalsIgnoreCase("solid")){
            //create solid body in level
            RectangleMapObject rectangleObject= (RectangleMapObject) mapObject;
            BodyDef bodyDefintion= new BodyDef();
            bodyDefintion.type= BodyDef.BodyType.StaticBody;
            bodyDefintion.position.set(rectangleObject.getRectangle().x* LevelController.UNIT_SCALE,
                    rectangleObject.getRectangle().y* LevelController.UNIT_SCALE);

            //
            Body physicsBody= LevelController.gameWorld.createBody(bodyDefintion);
            PolygonShape rectangleShape= new PolygonShape();
            rectangleShape.setAsBox(rectangleObject.getRectangle().width* LevelController.UNIT_SCALE/2f,
                    rectangleObject.getRectangle().height* LevelController.UNIT_SCALE/2f,
                    new Vector2(rectangleObject.getRectangle().width* LevelController.UNIT_SCALE/2f,
                            rectangleObject.getRectangle().height* LevelController.UNIT_SCALE/2f), 0f);

            //
            FixtureDef fixturedefiniton= new FixtureDef();
            fixturedefiniton.shape= rectangleShape;

            //
            physicsBody.createFixture(fixturedefiniton);
            rectangleShape.dispose();
        }

        else if(bodyType.equalsIgnoreCase("slope")){
            //create solid body in level
            PolygonMapObject polygonObject= (PolygonMapObject) mapObject;
            BodyDef bodydefintion= new BodyDef();
            bodydefintion.type= BodyDef.BodyType.StaticBody;
            bodydefintion.position.set(polygonObject.getPolygon().getX()* LevelController.UNIT_SCALE,
                   polygonObject.getPolygon().getY()* LevelController.UNIT_SCALE);

            //
            Body physicsBody= LevelController.gameWorld.createBody(bodydefintion);
            PolygonShape polygonShape= new PolygonShape();
            float[] transformedVertices= new float[polygonObject.getPolygon().getVertices().length];

            //
           for(int index= 0; index < transformedVertices.length; index++){
                transformedVertices[index]= polygonObject.getPolygon().getVertices()[index] * LevelController.UNIT_SCALE;
            }

            //
            polygonShape.set(transformedVertices);

            //
            FixtureDef fixtureDefiniton= new FixtureDef();
            fixtureDefiniton.shape= polygonShape;

            //
            physicsBody.createFixture(fixtureDefiniton);
            polygonShape.dispose();
        }
    }

}
