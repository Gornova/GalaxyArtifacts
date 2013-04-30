package it.galaxyArtifacts.gui;

import it.galaxyArtifacts.core.Entity;
import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.core.interfaces.Updatable;
import it.galaxyArtifacts.entities.StarEntity;
import it.galaxyArtifacts.gui.twl.RootPane;
import it.galaxyArtifacts.util.GuiFactory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import de.matthiasmann.twl.Widget;

//TODO: remove use, factory?
public class GuiManager implements Updatable {

	private Widget statusBar;
	private Widget planetInfo;
	private StarEntity selectedStar;

	private EntityManager em;
	private RootPane rp;

	public GuiManager(EntityManager em) {
		this.em = em;
	}

	public void layoutRootPane() {
		statusBar.setPosition(0, 0);
		statusBar.setSize(200, 30);
	}

	public RootPane createRootPane(RootPane rp) {
		this.rp = rp;
		rp.setTheme("");
		statusBar = GuiFactory.createTurnBar();
		rp.add(statusBar);
		return rp;
	}

	public void update(GameContainer container) {
		checkSelectedStar(container.getInput());
	}

	private void checkSelectedStar(Input input) {
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			int mx = input.getAbsoluteMouseX() / Entity.TILE_SIZE;
			int my = input.getAbsoluteMouseY() / Entity.TILE_SIZE;
			selectedStar = em.findStarEntity(mx, my);
			if (selectedStar != null && planetInfo == null) {
				planetInfo = GuiFactory.createPlanetInfo(selectedStar.star);
				rp.add(planetInfo);
				planetInfo.setPosition(selectedStar.cx, selectedStar.cy);
				planetInfo.adjustSize();
			}
		}
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
			selectedStar = null;
			rp.removeChild(planetInfo);
			planetInfo = null;
		}
	}

}
