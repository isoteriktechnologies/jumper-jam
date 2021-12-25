package com.isoterik.jumper_jam.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.isoterik.jumper_jam.GlobalSettings;
import com.isoterik.jumper_jam.components.CameraController;
import com.isoterik.racken.GameObject;
import com.isoterik.racken.Scene;
import com.isoterik.racken._2d.components.renderer.TiledMapRenderer;

public class GameScene extends Scene {
    private TiledMapRenderer tiledMapRenderer;

    private GameObject gameManager;

    public GameScene() {
        gameManager = GameObject.newInstance("GameManager");
        gameManager.addComponent(new CameraController());
        addGameObject(gameManager);

        TiledMap tiledMap = racken.assets.getAsset("level1.tmx", TiledMap.class);
        tiledMapRenderer = new TiledMapRenderer(tiledMap, 1f/GlobalSettings.PIXELS_PER_UNIT);
        gameManager.addComponent(tiledMapRenderer);

        mainCamera.setup(new FitViewport(gameWorldUnits.getWorldWidth(), gameWorldUnits.getWorldHeight()));

        init();
    }

    private void init() {
        Array<TiledMapTileMapObject> tileObjects = tiledMapRenderer.getTileObjects();
        for (TiledMapTileMapObject tileObject : tileObjects) {
            MapProperties properties = tileObject.getProperties();
            float width = gameWorldUnits.toWorldUnit((float)properties.get("width"));
            float height = gameWorldUnits.toWorldUnit((float)properties.get("height"));
            float x = gameWorldUnits.toWorldUnit((float)properties.get("x"));
            float y = gameWorldUnits.toWorldUnit((float)properties.get("y"));

            tileObject.getTextureRegion().getTexture().setFilter(Texture.TextureFilter.Linear,
                    Texture.TextureFilter.Linear);
            GameObject gameObject = newSpriteObject(tileObject.getTextureRegion());
            gameObject.transform.setSize(width, height);
            gameObject.transform.setPosition(x, y);
            addGameObject(gameObject);
        }

        Array<RectangleMapObject> rectangleObjects = tiledMapRenderer.getRectangleObjects();
        for (RectangleMapObject rectangleObject : rectangleObjects) {
            MapProperties properties = rectangleObject.getProperties();
            float width = gameWorldUnits.toWorldUnit((float)properties.get("width"));
            float height = gameWorldUnits.toWorldUnit((float)properties.get("height"));
            float x = gameWorldUnits.toWorldUnit((float)properties.get("x"));
            float y = gameWorldUnits.toWorldUnit((float)properties.get("y"));

            GameObject rect = GameObject.newInstance(properties.get("name", String.class));
            rect.transform.setSize(width, height);
            rect.transform.setPosition(x, y);
            addGameObject(rect);
        }
    }
}















