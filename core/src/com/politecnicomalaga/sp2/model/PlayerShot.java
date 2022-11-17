package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class PlayerShot extends Actor {

    private Texture skin;

    public PlayerShot(PlayerSpaceShip shotOwner) {
        super();
        setBounds(0,0, SettingsManager.SHOT_WIDTH, SettingsManager.SHOT_HEIGHT);
        setX(shotOwner.getX());
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        setY(shotOwner.getY()+SettingsManager.MIDPLAYER_SIZE+10);
        skin = new TextureRegion(atlas.findRegion("disparo_aliado")).getTexture();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(skin, this.getX(), this.getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.setY(this.getY()+1);
    }
}
