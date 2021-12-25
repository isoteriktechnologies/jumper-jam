package com.isoterik.jumper_jam;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.isoterik.jumper_jam.scenes.GameScene;
import com.isoterik.racken.GameDriver;
import com.isoterik.racken.Scene;
import com.isoterik.racken._2d.scenes.transition.SceneTransitions;

public class JumperJam extends GameDriver {
	@Override
	protected Scene initGame() {
		enqueueAssets();
		racken.assets.loadAssetsNow();

		racken.defaultSettings.VIEWPORT_WIDTH  = GlobalSettings.VIEWPORT_WIDTH;
		racken.defaultSettings.VIEWPORT_HEIGHT = GlobalSettings.VIEWPORT_HEIGHT;
		racken.defaultSettings.PIXELS_PER_UNIT = GlobalSettings.PIXELS_PER_UNIT;

		splashTransition = SceneTransitions.fade(1f);
		return new GameScene();
	}

	private void enqueueAssets() {
		racken.assets.enqueueAsset("level1.tmx", TiledMap.class);
	}
}