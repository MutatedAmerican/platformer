package com.diazb.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
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

        else if(bodyType.equalsIgnoreCase("ground")){
            //create solid body in level
            PolylineMapObject polylineObject= (PolylineMapObject) mapObject;
            BodyDef bodydefintion= new BodyDef();
            bodydefintion.type= BodyDef.BodyType.StaticBody;
            bodydefintion.position.set(polylineObject.getPolyline().getX()* LevelController.UNIT_SCALE,
                   polylineObject.getPolyline().getY()* LevelController.UNIT_SCALE);

            //
            Body physicsBody= LevelController.gameWorld.createBody(bodydefintion);
            ChainShape chainShape = new ChainShape();
            float[] transformedVertices= new float[polylineObject.getPolyline().getVertices().length];

            //
           for(int index= 0; index < transformedVertices.length; index++){
                transformedVertices[index]= polylineObject.getPolyline().getVertices()[index] * LevelController.UNIT_SCALE;
            }

            //
            chainShape.createChain(transformedVertices);

            //
            FixtureDef fixtureDefiniton= new FixtureDef();
            fixtureDefiniton.shape= chainShape;
            fixtureDefiniton.friction= 1f;

            //
            physicsBody.createFixture(fixtureDefiniton);
            chainShape.dispose();
        }

        else if (bodyType.equalsIgnoreCase("block")){

            RectangleMapObject blockObject= (RectangleMapObject) mapObject;
            BodyDef bodyDefintion= new BodyDef();
            bodyDefintion.type= BodyDef.BodyType.DynamicBody;
            bodyDefintion.position.set(blockObject.getRectangle().x* LevelController.UNIT_SCALE,
                    blockObject.getRectangle().y* LevelController.UNIT_SCALE);

            //
            Body physicsBody= LevelController.gameWorld.createBody(bodyDefintion);
            PolygonShape blockShape= new PolygonShape();
            blockShape.setAsBox(blockObject.getRectangle().width* LevelController.UNIT_SCALE/2f,
                    blockObject.getRectangle().height* LevelController.UNIT_SCALE/2f,
                    new Vector2(blockObject.getRectangle().width* LevelController.UNIT_SCALE/2f,
                            blockObject.getRectangle().height* LevelController.UNIT_SCALE/2f), 0f);

            //
            FixtureDef fixturedefiniton= new FixtureDef();
            fixturedefiniton.shape= blockShape;

            //
            physicsBody.createFixture(fixturedefiniton);
            blockShape.dispose();
        }
    }

}
