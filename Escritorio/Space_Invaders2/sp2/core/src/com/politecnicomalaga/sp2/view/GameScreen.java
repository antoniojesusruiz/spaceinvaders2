package com.politecnicomalaga.sp2.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.model.Battalion;
import com.politecnicomalaga.sp2.model.PlayerSpaceShip;

/**
 * Clase GameScreen. Donde jugamos el juego y tenemos la batalla principal
 * GameScreen Class. Where we play the game and we have the main battle
 * Created by Andrés Alcaraz Rey on 5/11/2022.
 *
 */
public class GameScreen implements Screen {

    private Stage stage;
    private Game game;
    private PlayerSpaceShip heroShip;


    public GameScreen(Game aGame) {
        game = aGame;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        //We add the battalion, "the empire"

        Battalion empire = new Battalion(stage);

        //We add the main player
        heroShip = new PlayerSpaceShip();
        //Agregamos la nave principal al escenario
        stage.addActor(heroShip);

        //Se que en esta parte se trata de mover a la nave

        heroShip.addListener(new InputListener() {

            public void clicked(InputEvent event, float x, float y, int pointer, int button) {
                //return true;
                Gdx.app.log("INFO","Se ha arrastrado la nave");
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

            //Permite mover la nave segun la posicion del raton en tiempo real
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                heroShip.setX(event.getStageX());

            }
        });
        heroShip.setTouchable(Touchable.enabled);

    }

    //Muestra un mensaje por la terminal)?
    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");

    }

    //Renderiza el escenario
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }


    //Ajusta el tamaño del escenario
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
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
