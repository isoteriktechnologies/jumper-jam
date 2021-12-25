package com.isoterik.jumper_jam.components;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.isoterik.jumper_jam.GlobalSettings;
import com.isoterik.racken.Component;
import com.isoterik.racken.GameCamera;
import com.isoterik.racken.GameObject;

public class CameraController extends Component {
    private GameCamera camera;
    private GameObject player;
    private float maxY;
    private Interpolation interpolation;

    @Override
    public void start() {
        camera = scene.getMainCamera();
        player = scene.findGameObject(GlobalSettings.PLAYER_TAG);

        GameObject levelTop = scene.findGameObject(GlobalSettings.LEVEL_TOP_TAG);
        if (levelTop != null)
            maxY = levelTop.transform.position.y;

        interpolation = Interpolation.linear;
    }

    @Override
    public void update(float deltaTime) {
        if (player == null)
            return;

        // Vertically center the camera on the player

//        Vector3 playerSize = player.transform.size;
//        Vector3 playerPosition = player.transform.position;
//        Vector3 cameraPosition = camera.getCamera().position;
//
//        float minY = scene.getGameWorldUnits().getWorldHeight()/2f;
//
//        float newCameraY = playerPosition.y + (playerSize.y * .5f);
//        float lerp = 0.2f;
//        cameraPosition.y += (newCameraY) * lerp * deltaTime;
//        cameraPosition.y = MathUtils.clamp(cameraPosition.y, minY, maxY - minY);
    }
}











