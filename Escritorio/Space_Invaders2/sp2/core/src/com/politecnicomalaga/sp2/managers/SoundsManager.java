package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundsManager {

    public enum TypeSound{BUTTON,EXPLOSION,SHOT};

    //Sonidos cargados en memoria
    private static Sound buttonSound;
    private static Sound explosionSound;
    private static Sound shotSound;

    private static SoundsManager singleton;
    //Asegura que solo haya una instancia de la clase
    public static SoundsManager getSingleton() {

        if (singleton == null) {
            singleton = new SoundsManager();
            buttonSound = Gdx.audio.newSound(Gdx.files.internal("sounds/button.ogg"));
            explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/damage1.wav"));
            shotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/shot.wav"));
        }
        return singleton;
    }

    //Metodo encargado de reproducir el sonido pasado por paramentro
    public void playSound(TypeSound typeSound){

        switch(typeSound){
            case BUTTON:
                buttonSound.play();
                break;
            case EXPLOSION:
                explosionSound.play();
                break;
            case SHOT:
                shotSound.play();
                break;
        }
    }

}
