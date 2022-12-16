package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.managers.SoundsManager;

public class EnemyShip extends Actor {
    private Array<EnemyShot> disparosActivos=new Array<EnemyShot>();
    private Array<EnemyShot> recamara=new Array<EnemyShot>();
    private float timeToFire;
    private Stage stage;
    private Rectangle hitBox;
    private int maxTime;
    private boolean muerto;

    private Animation<TextureRegion> skin;
    //ESTE STRING ES PROVISIONAL, CUANDO TENGAMOS EL ASSETMANAGER LISTO,TENEMOS QUE CAMBIARLO
    private String ATLAS;

    public EnemyShip(Stage stage) {
        super();
        this.stage=stage;
        //DIFERENTES OPCIONES PARA VER CUAL FUNCIONA

        //TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/enemy.pack"));
        //TextureAtlas atlas = new TextureAtlas(ATLAS);
        //TextureAtlas atlas= new TextureAtlas(Gdx.files.internal("sp2.png"));
        TextureAtlas atlas= new TextureAtlas(Gdx.files.internal(AssetsManager.ATLAS_FILE));
        skin = new Animation<TextureRegion>(0.25f, atlas.findRegions(AssetsManager.ATLAS_ENEMY), Animation.PlayMode.LOOP);
        muerto=false;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        TextureRegion currentFrame = skin.getKeyFrame(GameManager.getSingleton().getGameTime(), true);
        //batch.draw(currentFrame, this.getX(), this.getY());
        //LA ANCHURA Y EL ALTO HAY QUE PONERLO CON LAS CONSTANTES QUE TIENE QUE HACER GUILLE
        batch.draw(currentFrame,this.getX(),this.getY(),SettingsManager.ENEMIES_SIZE, SettingsManager.ENEMIES_SIZE);
        hitBox= new Rectangle(this.getX(),this.getY(),SettingsManager.ENEMIES_SIZE,SettingsManager.ENEMIES_SIZE);
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void calculateBodyRectangle(){

        hitBox= new Rectangle(this.getX(),this.getY(),SettingsManager.ENEMIES_SIZE,SettingsManager.ENEMIES_SIZE);
    }

    public void dispose(){
        if(this!=null){
            this.dispose();
        }
    }

    @Override
    public void act(float delta) {

        super.act(delta);
        // PlayerShot bala= new PlayerShot(this);
        if(muerto){
            this.remove();
            this.dispose();
        }
        timeToFire+= delta;
        /*if(timeToFire>5){
            stage.addActor(bala);
            //bala.act(delta);
            timeToFire=0;
        }*/


        EnemyShot bala;
        if(disparosActivos.size!=0){
            if(disparosActivos.get(0).getX()>SettingsManager.SCREEN_WIDTH){
                descartar(disparosActivos.get(0));
                disparosActivos.removeIndex(0);
            }
        }
        if(Math.random()>0.999){
            if(recamara.isEmpty()){
                bala= new EnemyShot(this);
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
        calculateBodyRectangle();
    }
    public boolean calculateCollisions(PlayerShot hb){
        boolean result= false;
        Rectangle hitbox= hb.getBody();
        if(hbBody!=null && hitbox!=null){
            result=hitbox.overlaps(hbBody);
            if(result){
                //se destruye
                this.muerto=true;
            }
        }
        return result;
    }
    public void descartar(EnemyShot bala){
        recamara.add(bala);
    }
}
