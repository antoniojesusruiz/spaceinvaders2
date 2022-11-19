package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;

public class GameOverScreen implements Screen {
    private Stage GameOverStage;
    private Game game;

    public GameOverScreen(final Game configGame){
        game=configGame;

        GameOverStage= new Stage(new ScreenViewport());

        Gdx.input.setInputProcessor(GameOverStage);

        Label title = new Label(LanguageManager.getSingleton().getString(LanguageManager.GAMEOVER_LABEL), AssetsManager.getTextSkin(),"black");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()-title.getHeight()*2);
        title.setWidth(Gdx.graphics.getWidth());

        //Añadiendo a la pantalla:
        GameOverStage.addActor(title);

        //BOTONES CON TEXTO:


        //Boton para volver al menu
        TextButton buttonExit= new TextButton(LanguageManager.getSingleton().getString(LanguageManager.EXIT_LABEL),AssetsManager.getTextSkin());
        buttonExit.setWidth(Gdx.graphics.getWidth()/2);
        buttonExit.setPosition(Gdx.graphics.getWidth()/2-buttonExit.getWidth()/2,Gdx.graphics.getHeight()/2-buttonExit.getHeight()*4);


        TextButton buttonPlay= new TextButton(LanguageManager.getSingleton().getString(LanguageManager.EXIT_LABEL),AssetsManager.getTextSkin());
        buttonPlay.setWidth(Gdx.graphics.getWidth()/2);
        buttonPlay.setPosition(Gdx.graphics.getWidth()/2-buttonPlay.getWidth()/2,Gdx.graphics.getHeight()/2-buttonPlay.getHeight()*4);


        //Boton para volver a jugar
        buttonPlay.addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int pointer, int button){
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.GAME_SCREEN));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }
        });

        GameOverStage.addActor(buttonPlay);



        //listener del booton menu

        buttonExit.addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int pointer, int button){
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.SPLASH_SCREEN));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }
        });

        GameOverStage.addActor(buttonExit);

    }










    @Override
    public void show() {
        Gdx.app.log("ConfigScreen","show");

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GameOverStage.act();
        GameOverStage.draw();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        configStage.dispose();
    }
}
