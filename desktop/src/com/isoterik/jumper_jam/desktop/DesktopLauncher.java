package com.isoterik.jumper_jam.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.isoterik.jumper_jam.GlobalSettings;
import com.isoterik.jumper_jam.JumperJam;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		int preferredWidth = GlobalSettings.WORLD_WIDTH;
		int preferredHeight = GlobalSettings.WORLD_HEIGHT;
		int width = preferredWidth;
		int height = preferredHeight;

		Dimension size = Toolkit. getDefaultToolkit().getScreenSize();
		if (size.width < preferredWidth)
			width = size.width;

		if (size.height < preferredHeight)
			height = size.height;

		config.setWindowedMode(width, height);

		new Lwjgl3Application(new JumperJam(), config);
	}
}
