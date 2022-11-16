package com.politecnicomalaga.sp2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
	static float fGameTime;

	
	@Override
	public void create () {
		GdxSpaceInvaders2.fGameTime = 0f;
		batch = new SpriteBatch();
		screen= new GameScreen(this);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		screen.render(Gdx.graphics.getDeltaTime());
		batch.end();
		GdxSpaceInvaders2.fGameTime += Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public static float getGameTime() {
		return fGameTime;
	}
}
