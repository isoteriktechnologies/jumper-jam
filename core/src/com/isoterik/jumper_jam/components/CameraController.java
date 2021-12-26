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

    private void getDependencies() {
        if (camera == null)
            camera = scene.getMainCamera();

        if (player == null)
            player = findGameObject(GlobalSettings.PLAYER_TAG);

        if (maxY == 0) {
            GameObject levelTop = findGameObject(GlobalSettings.LEVEL_TOP_TAG);
            if (levelTop != null)
                maxY = levelTop.transform.position.y;
        }

        if (interpolation == null)
            interpolation = Interpolation.linear;
    }

    @Override
    public void update(float deltaTime) {
        getDependencies();

        if (player == null)
            return;

        // Vertically center the camera on the player

        Vector3 playerSize = player.transform.size;
        Vector3 playerPosition = player.transform.position;
        Vector3 cameraPosition = camera.getCamera().position;

        float minY = scene.getGameWorldUnits().getWorldHeight()/2f;
        float oldCameraY = cameraPosition.y;
        float newCameraY = playerPosition.y + (playerSize.y * .5f);
        cameraPosition.y += interpolation.apply(newCameraY - oldCameraY) * deltaTime;
        cameraPosition.y = MathUtils.clamp(cameraPosition.y, minY, maxY - minY);
    }
}











