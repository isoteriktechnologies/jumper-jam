package com.isoterik.jumper_jam.scenes;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.isoterik.jumper_jam.GlobalSettings;
import com.isoterik.racken.GameObject;
import com.isoterik.racken.Scene;
import com.isoterik.racken._2d.components.renderer.TiledMapRenderer;

public class GameScene extends Scene {
    private GameObject gameManager;

    public GameScene() {
        gameManager = GameObject.newInstance("GameManager");
        addGameObject(gameManager);

        TiledMap tiledMap = racken.assets.getAsset("level1.tmx", TiledMap.class);
        TiledMapRenderer tiledMapRenderer = new TiledMapRenderer(tiledMap, 1f/GlobalSettings.PIXELS_PER_UNIT);
        gameManager.addComponent(tiledMapRenderer);

        mainCamera.setup(new FitViewport(gameWorldUnits.getWorldWidth(), gameWorldUnits.getWorldHeight()));
    }
}
