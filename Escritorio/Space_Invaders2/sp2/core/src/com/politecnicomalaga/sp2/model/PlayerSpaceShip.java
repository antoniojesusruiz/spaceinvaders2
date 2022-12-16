package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.view.GameScreen;
import com.politecnicomalaga.sp2.managers.SoundsManager;

import java.util.Set;

public class PlayerSpaceShip extends Actor {

    private Animation<TextureRegion> skin;
    private Array<PlayerShot> disparosActivos =new Array<PlayerShot>(); //disparos que estan dentro de la pantalla
    private Array<PlayerShot> recamara =new Array<PlayerShot>();; //disparos que estan fuera de la pantalla
    private float timeToFire;
    private Stage stage;
    private Rectangle body;
    private boolean muerto;

    public PlayerSpaceShip(Stage stage) {
        super();
        timeToFire=0.0f;
        setBounds(0,0, SettingsManager.PLAYER_SIZE, SettingsManager.PLAYER_SIZE);
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        setX(SettingsManager.SCREEN_WIDTH/2);
        setY(SettingsManager.MIDPLAYER_SIZE);
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions(AssetsManager.ATLAS_PLAYER), Animation.PlayMode.LOOP);
        this.stage=stage;
        body = null;
        muerto = false;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        batch.draw(currentFrame, this.getX(), this.getY());
    }
    // COMENZAMOS A IMPLEMENTAR EL NUEVO CODIGO
    //creo dos array, uno de disparos activos, y otro de los que salen de la pantalla

    @Override
    public void act(float delta) {

        if (muerto) {
            this.remove();
        }
        super.act(delta);
        this.calculateBodyRectangle();
       // PlayerShot bala= new PlayerShot(this);
        timeToFire+= delta;
        /*if(timeToFire>5){
            stage.addActor(bala);
            //bala.act(delta);
            timeToFire=0;
        }*/


        PlayerShot bala;
        if(disparosActivos.size!=0){
            if(disparosActivos.get(0).getY()>SettingsManager.SCREEN_HEIGHT){
                descartar(disparosActivos.get(0));
                disparosActivos.removeIndex(0);
            }
        }
       if(timeToFire>SettingsManager.FIRE_RATE_PLAYER){
            if(recamara.isEmpty()){
                bala= new PlayerShot(this);
                stage.addActor(bala);
                disparosActivos.add(bala);
            }else{
                bala= recamara.get(0);
                recamara.removeIndex(0);
                bala.setY(this.getY()+SettingsManager.PLAYER_SIZE);
                bala.setX(this.getX()+SettingsManager.MIDPLAYER_SIZE-SettingsManager.MIDSHOT_WIDTH);
                //stage.addActor(bala);
                disparosActivos.add(bala);
            }
            SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.SHOT);
            timeToFire=0;
        }
    }
    public void descartar(PlayerShot bala){
        recamara.add(bala);
    }

    //FIN DE LA IMPLEMENTACION

    public void dispose() {
        if (this!=null) {
            this.dispose();
        }
    }

    public Array<PlayerShot> getDisparosActivos() {
        return disparosActivos;
    }

    public void calculateBodyRectangle() {
        body = new Rectangle(getX(), getY(),SettingsManager.PLAYER_SIZE, SettingsManager.PLAYER_SIZE);
    }

    public boolean calculateCollisions (EnemyShot en) {
        boolean result= false;
        Rectangle enBody= en.getHitBox();
        if(enBody!=null && body!=null){
            result=body.overlaps(enBody);
            if(result){
                //se destruye
                this.muerto=true;
            }
        }
        return result;
    }

    public boolean isMuerto() {
        return muerto;
    }
}
