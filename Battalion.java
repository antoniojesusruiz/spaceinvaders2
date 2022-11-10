package com.politecnicomalaga.sp2.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class Battalion {

    //DECLARACIONES
    private Array<Squadron> batallon;


     //(CONSTANTES DEL GUILLE)

   protected static int CONSTANTEnumESCUADRONES;
    protected static int CONSTANTEaltoEscuadron=0;
    protected static int CONSTANTEanchoEscuadron=0;





    public Battalion(Stage baseStage) {
        //Initiate the arraylist
        batallon = new Array<Squadron>();


        //We have to create all the squadrons
        for (int i=0;i<4;i++) {
            Squadron newSquad = new Squadron(baseStage);
        }
    }

    //CONSTRUCTORES

    public void Batallon(int ancho, int alto){
        ancho= CONSTANTEanchoEscuadron;
        alto= CONSTANTEaltoEscuadron;

        float distanciaEntreEscuadrones = (alto/2)/CONSTANTEnumESCUADRONES;

        //lista de escuadrones
        batallon= new Array<>();

        //Crear escuadrones

        for (int i=0; i<CONSTANTEnumESCUADRONES;i++){
            Squadron escuadron = new Squadron(ancho,alto-distanciaEntreEscuadrones*(i+1));
            batallon.add(escuadron);
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
}
