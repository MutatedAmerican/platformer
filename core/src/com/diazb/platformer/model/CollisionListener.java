package com.diazb.platformer.model;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.diazb.platformer.controller.PlayerController;

public class CollisionListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        //determine the shape of contact
        Fixture fixtureA= contact.getFixtureA();
        Fixture fixtureB= contact.getFixtureB();

        //determine which sensor is true
        boolean sensorA= fixtureA.isSensor();
        boolean sensorB= fixtureB.isSensor();

        //check which sensor is the sensor
        if(sensorA || sensorB){
            PlayerController.grounded= true;
        }
    }

    @Override
    public void endContact(Contact contact) {
        //end the contact
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
