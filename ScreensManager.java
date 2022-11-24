package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.politecnicomalaga.sp2.view.ConfigScreen;
import com.politecnicomalaga.sp2.view.CreditsScreen;
import com.politecnicomalaga.sp2.view.GameOverScreen;
import com.politecnicomalaga.sp2.view.GameScreen;
import com.politecnicomalaga.sp2.view.SplashScreen;

public class ScreensManager
{
    private static ScreensManager singleton;

    private Screen activeScreen;

    public enum SCREENS {
        GAME_SCREEN, GAMEOVER_SCREEN, SPLASH_SCREEN, CREDITS_SCREEN, SETTINGS_SCREEN
    }


    public Screen getScreen(Game aGame, SCREENS screenToGet)
    {
        Screen newScreen;
        switch(screenToGet)
        {
            //Create Enum: GAME_SCREEN GAMEOVER_SCREEN, SPLASH_SCREEN, CREDITS_SCREEN
            case GAME_SCREEN: newScreen = new GameScreen(aGame);
            return newScreen;

            case GAMEOVER_SCREEN: newScreen = new GameOverScreen(aGame);
                return newScreen;


            case SPLASH_SCREEN: newScreen = new SplashScreen(aGame);
                return newScreen;


            case CREDITS_SCREEN: newScreen = new CreditsScreen(aGame);
                return newScreen;

            case SETTINGS_SCREEN: newScreen = new ConfigScreen(aGame);
                return newScreen;
            default:newScreen = new SplashScreen(aGame);
                return newScreen;

        }

    }

    public static ScreensManager getSingleton()
    {
        if(singleton == null)
        {
            singleton = new ScreensManager();
        }
        return singleton;
    }




}