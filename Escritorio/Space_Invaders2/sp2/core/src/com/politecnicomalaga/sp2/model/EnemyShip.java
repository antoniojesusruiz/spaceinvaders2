package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class EnemyShip extends Actor {

    private Animation<TextureRegion> skin;
    //ESTE STRING ES PROVISIONAL, CUANDO TENGAMOS EL ASSETMANAGER LISTO,TENEMOS QUE CAMBIARLO
    private String ATLAS;

    public EnemyShip() {
        super();
        //DIFERENTES OPCIONES PARA VER CUAL FUNCIONA

        //TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/enemy.pack"));
        //TextureAtlas atlas = new TextureAtlas(ATLAS);
        //TextureAtlas atlas= new TextureAtlas(Gdx.files.internal("sp2.png"));
        TextureAtlas atlas= new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions("enemy"), Animation.PlayMode.LOOP);

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        //batch.draw(currentFrame, this.getX(), this.getY());
        //LA ANCHURA Y EL ALTO HAY QUE PONERLO CON LAS CONSTANTES QUE TIENE QUE HACER GUILLE
        batch.draw(currentFrame,this.getX(),this.getY(),SettingsManager.ENEMIES_SIZE, SettingsManager.ENEMIES_SIZE);
    }
    public void dispose(){
        if(this!=null){
            this.dispose();
        }
    }
}
