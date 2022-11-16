package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

import java.util.Set;

public class PlayerSpaceShip extends Actor {

    private Animation<TextureRegion> skin;

    public PlayerSpaceShip() {
        super();
        setBounds(0,0, SettingsManager.PLAYER_SIZE, SettingsManager.PLAYER_SIZE);
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        setX(SettingsManager.SCREEN_WIDTH/2);
        setY(SettingsManager.MIDPLAYER_SIZE);
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions("player"), Animation.PlayMode.LOOP);

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY());
    }

    public void dispose() {
        if (this!=null) {
            this.dispose();
        }
    }
}
