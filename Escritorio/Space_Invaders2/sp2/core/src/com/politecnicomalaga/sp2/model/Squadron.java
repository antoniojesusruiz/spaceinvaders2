package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Squadron {

    //ATRIBUTOS

    protected Array<EnemyShip> tropas;
    protected boolean right;

    //(CONSTANTES DEL GUILLE)
    int CONSTANTEnumNAVES;



    public Squadron(Stage baseStage) {
        //Initiate the arraylist

        tropas = new Array<EnemyShip>();


        //We have to create all the squadrons

        for (int i=0;i<8;i++) {
            EnemyShip newEnemy = new EnemyShip();
            baseStage.addActor(newEnemy);
        }
    }

    //CONSTRUCTORES

    public Squadron(int widthScreen, float vertPosition){
        EnemyShip alien;
        float distanceBTWships= widthScreen/(CONSTANTEnumNAVES+1);
        right=true;
        for (int i=0;i<CONSTANTEnumNAVES;i++){
            alien = new EnemyShip();
            alien.setBounds((i+1)*distanceBTWships,vertPosition,"AnchoGuille","altoGuille");
            tropas.add(alien);
        }
    }

    //PINTARSE

    public void pintarse (SpriteBatch sb){
        for (EnemyShip et : tropas){
---------------------//ESPERAR A QUE HAGAN EL MÉTODO PARA PINTARSE--------------------
            et.pintarse(sb);
        }
    }

    //MOVERSE
    public void moverse(){
        for (EnemyShip et : tropas){
---------------------//ESPERAR A QUE HAGAN EL MÉTODO PARA MOVERSE--------------------
            et.moverse();
        }
    }

    //DISPOSE

    public void dispose(){
        for (EnemyShip et : tropas){
            ---------------------//ESPERAR A QUE HAGAN EL MÉTODO DISPOSE--------------
            et.dispose();
        }
    }

    //numNaves

    public int numNaves(){
        return tropas.size;
    }

    //COLISIÓN

    //(HACE FALTA LA CLASE "objetoVolador"
    public boolean colision (????){

    }

    //DISPARAR

    //HACE FALTA LA CLASE "DisparoEnemigo"
    public DisparoAlien disparo(){
        DisparoEnemigo tirito = null;
        EnemyShip naveDisparando;
        int pos;

        if (!tropas.isEmpty()){
            pos = (int) (Math.random()*(tropas.size-1));

            naveDisparando= tropas.get(pos);

            tirito = new
        }
    }


}
