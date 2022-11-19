package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.politecnicomalaga.sp2.view.ConfigScreen;
import com.politecnicomalaga.sp2.view.CreditsScreen;
import com.politecnicomalaga.sp2.view.GameOverScreen;
import com.politecnicomalaga.sp2.view.GameScreen;
import com.politecnicomalaga.sp2.view.SplashScreen;

public class AssetsManager {
    //Constantes
    public static final String NUMBERS_SPRITES = "numbers/digito";
    public static final String NUMBERS_EXT_SPRITES =".png";
    public static final String CREDITS_IMAGE="CreditosProvisional.png";
    public static final String ATLAS_FILE = "sp2.atlas";

    public enum skins {
        GAME_SCREEN, GAMEOVER_SCREEN, SPLASH_SCREEN, CREDITS_SCREEN, SETTINGS_SCREEN
    }


    public Skin getTextSkin(AssetsManager.skins skin)
    {
        Skin skinToSend;
        switch(skin)
        {
            //Create Enum: GAME_SCREEN GAMEOVER_SCREEN, SPLASH_SCREEN, CREDITS_SCREEN
            case GAME_SCREEN: skinToSend = new Skin(Gdx.files.internal("assets/"));
                return skinToSend;

            case GAMEOVER_SCREEN: skinToSend = new GameOverScreen(aGame);
                return skinToSend;


            case SPLASH_SCREEN: skinToSend = new SplashScreen(aGame);
                return skinToSend;


            case CREDITS_SCREEN: skinToSend = new CreditsScreen(aGame);
                return skinToSend;

            case SETTINGS_SCREEN: skinToSend = new ConfigScreen(aGame);
                return skinToSend;

        }
        return null;
    }
}
