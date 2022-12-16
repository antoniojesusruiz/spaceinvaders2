package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SoundsManager;

public class CreditsScreen implements Screen {

    private Stage stage;
    private Game game;

    Texture credits = new Texture(AssetsManager.CREDITS_IMAGE);

    public CreditsScreen(final Game aGame) {
        game = aGame;

        stage = new Stage(new ScreenViewport());

        Gdx.input.setInputProcessor(stage);

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));

        Skin skin = new Skin (Gdx.files.internal("uiskin.json"),atlas);

// botones con texto

        //Boton para volver al menu
        TextButton buttonExit= new TextButton(LanguageManager.getSingleton().getString(LanguageManager.EXIT_LABEL),skin);
        buttonExit.setWidth(Gdx.graphics.getWidth()/2);
        buttonExit.setPosition(Gdx.graphics.getWidth()/2-buttonExit.getWidth()/2,Gdx.graphics.getHeight()/2-buttonExit.getHeight()*12);



        //ACTIONLISTENER PARA EL botón EXIT(hace falta todavía el languageManager)

        buttonExit.addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int pointer, int button){
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.SPLASH_SCREEN));
                SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.BUTTON);
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }
        });
        //los botones son actores también
        stage.addActor(buttonExit);

    }




    @Override
    public void show() {
        Gdx.app.log("CreditsSceeen","show");

    }



    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(credits,0,0);
        batch.end();
        stage.draw();

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
        stage.dispose();
    }
    }
