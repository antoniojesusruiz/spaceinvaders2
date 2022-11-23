package com.politecnicomalaga.sp2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.sp2.managers.GameManager;
import com.politecnicomalaga.sp2.managers.ScreensManager;
import com.politecnicomalaga.sp2.managers.SettingsManager;
import com.politecnicomalaga.sp2.view.ConfigScreen;
import com.politecnicomalaga.sp2.view.CreditsScreen;
import com.politecnicomalaga.sp2.view.GameOverScreen;
import com.politecnicomalaga.sp2.view.GameScreen;
import com.politecnicomalaga.sp2.view.SplashScreen;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class GdxSpaceInvaders2 extends Game {
	ScreensManager screensMgr;
	GameManager gameMgr;
	SpriteBatch batch;
	GameScreen gameSc;
    OrthographicCamera camera;
	Screen activeScr;
	static float fGameTime;

	
	@Override
	public void create () {
		GdxSpaceInvaders2.fGameTime = 0f;
		batch = new SpriteBatch();
		screensMgr = ScreensManager.getSingleton();
		gameMgr = GameManager.getSingleton();
		camera = new OrthographicCamera();
		gameSc = new GameScreen(this);

		activeScr = screensMgr.getScreen(this, ScreensManager.SCREENS.SPLASH_SCREEN);
		this.setScreen(activeScr);

		camera.setToOrtho(false, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		this.getScreen().render(Gdx.graphics.getDeltaTime());
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
