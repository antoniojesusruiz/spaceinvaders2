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
import com.politecnicomalaga.sp2.GdxSpaceInvaders2;
import com.politecnicomalaga.sp2.managers.AssetsManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.LanguageManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.managers.SoundsManager;

public class ConfigScreen implements Screen{
    private Stage configStage;
    private Game game;
    Texture FONDO = new Texture(AssetsManager.CONFIG_IMAGE);
    public ConfigScreen(final Game configGame){
        game=configGame;

        configStage= new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(configStage);

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));

        Skin skin = new Skin (Gdx.files.internal("uiskin.json"),atlas);

        Label title = new Label(LanguageManager.getSingleton().getString(LanguageManager.SETTING_LABEL),skin);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()-title.getHeight()*2);
        title.setWidth(Gdx.graphics.getWidth());

        //Añadiendo a la pantalla:
        configStage.addActor(title);

        //BOTONES CON TEXTO:

        //Boton para lenguaje español. cuidado con la variable spanish_BUTTON
        TextButton buttonSpanish= new TextButton(LanguageManager.getSingleton().getString(LanguageManager.SPANISH_LABEL),skin);
        buttonSpanish.setWidth(Gdx.graphics.getWidth()/2);
        buttonSpanish.setPosition(Gdx.graphics.getWidth()/2-buttonSpanish.getWidth()/2,Gdx.graphics.getHeight()/2-buttonSpanish.getHeight()*4);

        //Boton para lengua inglés. cuidado con la variable english_BUTTON
        TextButton buttonEnglish= new TextButton(LanguageManager.getSingleton().getString(LanguageManager.ENGLISH_LABEL),skin);
        buttonEnglish.setWidth(Gdx.graphics.getWidth()/2);
        buttonEnglish.setPosition(Gdx.graphics.getWidth()/2-buttonEnglish.getWidth()/2,Gdx.graphics.getHeight()/2-buttonEnglish.getHeight()*6);

        //Boton para volver al menu
        TextButton buttonExit= new TextButton(LanguageManager.getSingleton().getString(LanguageManager.EXIT_LABEL),skin);
        buttonExit.setWidth(Gdx.graphics.getWidth()/2);
        buttonExit.setPosition(Gdx.graphics.getWidth()/2-buttonExit.getWidth()/2,Gdx.graphics.getHeight()/2-buttonExit.getHeight()*8);




        //ACTIONLISTENER PARA EL botón SPANISH(hace falta todavía el languageManager)

        buttonSpanish.addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int puntero, int boton){
                LanguageManager.getSingleton().setActionLenguaje(LanguageManager.Lang.SPANISH);
                SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.BUTTON);
            }

            public boolean touchDown(InputEvent event, float x, float y, int puntero, int boton){
                return true;
            }
        });
        //los botones son actores también
        configStage.addActor(buttonSpanish);



        //ACTIONLISTENER PARA EL botón ENGLISH(hace falta todavía el languageManager)

        buttonEnglish.addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int pointer, int button){
               LanguageManager.getSingleton().setActionLenguaje(LanguageManager.Lang.ENGLISH);
               SoundsManager.getSingleton().playSound(SoundsManager.TypeSound.BUTTON);
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }
        });
        //los botones son actores también
        configStage.addActor(buttonEnglish);


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
        configStage.addActor(buttonExit);
    }










    @Override
    public void show() {
        Gdx.app.log("ConfigScreen","show");

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        configStage.act();
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(FONDO,0,0, SettingsManager.SCREEN_WIDTH,SettingsManager.SCREEN_HEIGHT);
        batch.end();
        configStage.draw();
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
