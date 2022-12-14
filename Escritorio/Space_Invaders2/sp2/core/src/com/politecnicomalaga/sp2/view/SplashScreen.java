package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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
import com.politecnicomalaga.sp2.GdxSpaceInvaders2;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.managers.SoundsManager;

/**
 * SplashScreen Class. It is showed when the game ends
 *
 *
 */
public class SplashScreen implements Screen {

    private Stage stage;
    private Game game;
    Music musica;
    Texture splash = new Texture(AssetsManager.SPLASH_IMAGE);
    public SplashScreen(final Game aGame) {

        game = aGame;

        stage = new Stage(new ScreenViewport());

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));

        Skin skin = new Skin (Gdx.files.internal("uiskin.json"),atlas);

        //Music and properties
        musica=Gdx.audio.newMusic(Gdx.files.internal("menutheme.ogg"));
        musica.setLooping(true);
        musica.setVolume(0.5f);
        musica.play();

//Esta orden se puede poner también en el show()
        Gdx.input.setInputProcessor(stage);

        Label title = new Label(LanguageManager.getSingleton().getString(LanguageManager.SPLASH_LABEL), skin);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()-title.getHeight()*2);
        title.setWidth(Gdx.graphics.getWidth());

//Añadimos la etiqueta a la pantalla.
        stage.addActor(title);

// botones con texto

        TextButton playButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.PLAY_LABEL),skin);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()-playButton.getHeight()*4);



        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        //Cuando el botón se suelte...
        //Le decimos al juego que coja y asigne una screen nueva, en concreto
        //una GameScreen
                musica.stop();
                musica.dispose();
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.GAME_SCREEN));
                SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.BUTTON);
            }


            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//Cuando el botón se pulsa no hacermos nada. Pero hay que implementarlo
                return true;
            }
        });


//El botón también es un actor.
        stage.addActor(playButton);


        TextButton settingsButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.SETTING_LABEL), skin);

        settingsButton.setWidth(Gdx.graphics.getWidth()/2);
        settingsButton.setPosition(Gdx.graphics.getWidth()/2-settingsButton.getWidth()/2,Gdx.graphics.getHeight()-settingsButton.getHeight()*8);



        settingsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.SETTINGS_SCREEN));
                SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.BUTTON);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//Cuando el botón se pulsa no hacermos nada. Pero hay que implementarlo
                return true;
            }
        });
//El botón también es un actor.
        stage.addActor(settingsButton);




        //BOTON PARA LOS CREDITOS


        TextButton creditsButton = new TextButton(LanguageManager.getSingleton().getString(LanguageManager.CREDITS_LABEL), skin);

        creditsButton.setWidth(Gdx.graphics.getWidth()/2);
        creditsButton.setPosition(Gdx.graphics.getWidth()/2-creditsButton.getWidth()/2,Gdx.graphics.getHeight()-creditsButton.getHeight()*6);



        creditsButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(ScreensManager.getSingleton().getScreen(game, ScreensManager.SCREENS.CREDITS_SCREEN));
                SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.BUTTON);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }
        });
//El botón también es un actor.
        stage.addActor(creditsButton);

    }

    @Override
    public void show() {
        Gdx.app.log("SplashScreen","show");

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(splash,0,0, SettingsManager.SCREEN_WIDTH,SettingsManager.SCREEN_HEIGHT);
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
        musica.dispose();
        stage.dispose();
    }


}
