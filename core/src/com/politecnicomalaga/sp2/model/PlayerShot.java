package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class PlayerShot extends Actor {

    private Texture skin;
    private PlayerSpaceShip shotOwner;

    public PlayerShot() {
        super();
        setBounds(0,0, SettingsManager.SHOT_WIDTH, SettingsManager.SHOT_HEIGHT);
        setX(shotOwner.getX());
        setY(shotOwner.getY());
    }
}
