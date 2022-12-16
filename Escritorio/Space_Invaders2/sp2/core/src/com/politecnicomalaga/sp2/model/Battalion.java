package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;

import java.util.ArrayList;

public class Battalion extends Actor {

    //DECLARACIONES
    private Array<Squadron> batallon;
    Stage stage;



    //(CONSTANTES DEL GUILLE)







    /*public Battalion(Stage baseStage) {
        //Initiate the arraylist
        batallon = new Array<Squadron>();


        //We have to create all the squadrons
        for (int i = 0; i< SettingsManager.SQUADRON_PER_BATALLON; i++) {
            Squadron newSquad = new Squadron(baseStage);
        }
    }*/

    //CONSTRUCTORES


    public Battalion(Stage baseStage){
        stage= baseStage;
       int alto= SettingsManager.SCREEN_HEIGHT;
       int ancho=SettingsManager.SCREEN_WIDTH;

        float distanciaEntreEscuadrones = (alto/2)/SettingsManager.SQUADRON_PER_BATALLON;

        //lista de escuadrones
        batallon= new Array<>();

        //Crear escuadrones
        float distancia=Gdx.graphics.getHeight()- SettingsManager.ENEMIES_SIZE;
        for (int i=0; i<SettingsManager.SQUADRON_PER_BATALLON;i++){
            Squadron escuadron = new Squadron(baseStage,alto-distanciaEntreEscuadrones*(i+1));
            escuadron.setY(distancia);
            distancia-= SettingsManager.ENEMIES_SIZE;
            batallon.add(escuadron);
           // baseStage.addActor(escuadron);
        }
    }

    public void pintarse (SpriteBatch sb){
        for (Squadron sq : batallon){
            sq.pintarse(sb);
        }
    }

    public void dispose(){
        for (Squadron sq : batallon){
            sq.dispose();
        }
    }

    //Saber nº de naves que han sobrevivido
    public int NavesRestantes(){
        int restantes=0;
        for (Squadron sq : batallon){
            restantes+=sq.numNaves();
        }
        return restantes;
    }

    public boolean destruido(){
        boolean estado=false;

        if (NavesRestantes()==0){
            estado=true;
        }

        return estado;
    }

    public Array<Squadron> getBatallon() {
        return batallon;
    }
}
