package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.politecnicomalaga.sp2.managers.*;


public class PlayerShot extends Actor {

    private Texture skin;
    private Rectangle body;
    private EnemyShip enemy;

    public PlayerShot(PlayerSpaceShip shotOwner) {
        super();
        setBounds(0,0, SettingsManager.SHOT_WIDTH, SettingsManager.SHOT_HEIGHT);
        // Toma las posiciones de la nave principal y un poco de altura para no aparecer en el
        // mismo sitio.
        setX(shotOwner.getX()+SettingsManager.MIDPLAYER_SIZE-(SettingsManager.MIDSHOT_WIDTH));
        setY(shotOwner.getY()+SettingsManager.PLAYER_SIZE);
       // TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        //skin = new TextureRegion(atlas.findRegion("disparo_aliado")).getTexture();
         skin= new Texture(Gdx.files.internal("images/disparo_aliado.png"));
         body = new Rectangle(0, 0, SettingsManager.SHOT_WIDTH, SettingsManager.SHOT_HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(skin, this.getX(), this.getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        // Se mueve verticalmente
        this.setY(this.getY()+3);
        body.setY((this.getY()));
        if (collides()) {
            this.dispose();
            enemy.dispose();
        }
    }

    public void dispose() {
        if (this!=null) {
            this.dispose();
        }
    }

    public boolean collides() {
        return body.overlaps(enemy.getBody());
    }
}
