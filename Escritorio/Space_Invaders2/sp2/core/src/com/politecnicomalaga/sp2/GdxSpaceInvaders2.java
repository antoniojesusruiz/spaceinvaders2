package com.politecnicomalaga.sp2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.view.GameScreen;

public class GdxSpaceInvaders2 extends Game {
	GameScreen screen;
	SpriteBatch batch;
    OrthographicCamera camera;

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		screen= new GameScreen(this);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		screen.render(GameManager.getSingleton().getGameTime());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
