package com.politecnicomalaga.sp2.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.politecnicomalaga.sp2.view.GameScreen;

public class ScreensManager
{
    private enum SCREENS {
        GAME_SCREEN, GAMEOVER_SCREEN, SPLASH_SCREEN, CREDITS_SCREEN
    }


    public void getScreen(Game aGame, SCREENS screenToGet)
    {
        Screen newScreen;
        switch(screenToGet)
        {
            //Create Enum: GAME_SCREEN GAMEOVER_SCREEN, SPLASH_SCREEN, CREDITS_SCREEN
            case GAME_SCREEN: newScreen = new GameScreen(aGame);
            break;

            case GAMEOVER_SCREEN: newScreen = new GameOverScreen(aGame);
            break;

            case SPLASH_SCREEN: newScreen = new SplashScreen(aGame);
            break;

            case CREDITS_SCREEN: newScreen = new CreditsScreen(aGame);
            break;
        }
        return ;
    }


}
