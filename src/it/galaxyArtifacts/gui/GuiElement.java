package it.galaxyArtifacts.gui;

import it.galaxyArtifacts.core.interfaces.Renderable;
import it.galaxyArtifacts.core.interfaces.Updatable;

public abstract class GuiElement implements Renderable, Updatable {

	protected float x;
	protected float y;
	protected boolean visible;

	public GuiElement(float x, float y) {
		this.x = x;
		this.y = y;
	}

}
