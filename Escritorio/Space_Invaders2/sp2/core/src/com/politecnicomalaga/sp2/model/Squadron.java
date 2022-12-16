package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

public class Squadron extends Actor {

    //ATRIBUTOS

    protected Array<EnemyShip> tropas;
    protected boolean right;
    Stage stage;





//    public Squadron(Stage baseStage) {
//        //Initiate the arraylist
//        stage= baseStage;
//        tropas = new Array<EnemyShip>();
//
//
//        //We have to create all the squadrons
//
//        for (int i = 0; i< SettingsManager.ENEMIES_PER_SQUADRON; i++) {
//            EnemyShip newEnemy = new EnemyShip(stage);
//            baseStage.addActor(newEnemy);
//        }
//    }

    //CONSTRUCTORES

    public Squadron(Stage baseStage, float vertPosition){
        stage = baseStage;
        tropas= new Array<EnemyShip>();

        EnemyShip alien;

        float distanceBTWships=  SettingsManager.SCREEN_WIDTH/( SettingsManager.ENEMIES_PER_SQUADRON+1);

        right=true;

        for (int i=0;i< SettingsManager.ENEMIES_PER_SQUADRON;i++){

            alien = new EnemyShip(stage);

            alien.setBounds((i+1)*distanceBTWships,vertPosition,SettingsManager.SCREEN_WIDTH,SettingsManager.SCREEN_HEIGHT);

            tropas.add(alien);
            baseStage.addActor(alien);
        }
    }

    //PINTARSE

    public void pintarse (SpriteBatch sb){
        for (EnemyShip et : tropas){

            et.draw(sb, GameManager.getSingleton().getGameTime());
        }
    }

    //MOVERSE pal futuro
/*
*    public void moverse(){
        for (EnemyShip et : tropas){
---------------------//ESPERAR A QUE HAGAN EL MÉTODO PARA MOVERSE--------------------
            et.moverse();
        }
    }
* */

    //DISPOSE

    public void dispose(){
        for (EnemyShip et : tropas){
            et.dispose();
        }
    }

    //numNaves

    public int numNaves(){
        return tropas.size;
    }

    //COLISIÓN pal futuro

/*
*    //(HACE FALTA LA CLASE "objetoVolador"
    public boolean colision (????){

    }
*
* */

    //DISPARAR

    //HACE FALTA LA CLASE "DisparoEnemigo" pal futuro
//    public DisparoAlien disparo(){
//        DisparoEnemigo tirito = null;
//        EnemyShip naveDisparando;
//        int pos;
//
//        if (!tropas.isEmpty()){
//            pos = (int) (Math.random()*(tropas.size-1));
//
//            naveDisparando= tropas.get(pos);
//
//            tirito = new
//        }
//    }


    public Array<EnemyShip> getTropas() {
        return tropas;
    }
}
