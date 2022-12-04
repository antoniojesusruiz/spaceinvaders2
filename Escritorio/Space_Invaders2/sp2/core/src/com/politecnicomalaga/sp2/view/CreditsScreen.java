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

        TextButton exitButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.EXIT_LABEL),skin);
        exitButton.setWidth(Gdx.graphics.getWidth()/2);
        exitButton.setPosition(Gdx.graphics.getWidth()/2-exitButton.getWidth()/2,Gdx.graphics.getHeight()-exitButton.getHeight()*4);



        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //Cuando el botón se suelte...
                //Le decimos al juego que coja y asigne una screen nueva, en concreto
                //una GameScreen
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.SPLASH_SCREEN));
                SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.BUTTON);
            }


            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }
        });


//El botón también es un actor.
        stage.addActor(exitButton);

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
