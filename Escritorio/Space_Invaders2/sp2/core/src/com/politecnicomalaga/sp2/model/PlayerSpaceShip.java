package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

import java.util.Set;

public class PlayerSpaceShip extends Actor {

    private Animation<TextureRegion> skin;

    public PlayerSpaceShip() {
        super();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(SettingsManager.ATLAS_PATH));
        skin = new Animation<TextureRegion>(SettingsManager.ANIMATION_SPEED, atlas.findRegions(SettingsManager.PLAYER_PATH), Animation.PlayMode.LOOP);

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, SettingsManager.SCREEN_WIDTH/2, SettingsManager.SHIP_HEIGHT/2);
    }

    public void dispose() {
        if (this!=null) {
            this.dispose();
        }
    }
}
