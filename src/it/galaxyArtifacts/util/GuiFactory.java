package it.galaxyArtifacts.util;

import it.galaxyArtifacts.Main;
import it.galaxyArtifacts.gui.GuiManager;

public class GuiFactory {

	private GuiFactory() {
	}

	public static GuiManager buildEmpty(Main main) {
		GuiManager g = new GuiManager(main);
		return g;
	}

}
