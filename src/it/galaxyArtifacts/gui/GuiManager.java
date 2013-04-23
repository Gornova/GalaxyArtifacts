package it.galaxyArtifacts.gui;

import it.galaxyArtifacts.gui.twl.RootPane;
import it.galaxyArtifacts.util.GuiFactory;
import de.matthiasmann.twl.Widget;

//TODO: remove use, factory?
public class GuiManager {

	private Widget statusBar;

	public GuiManager() {
	}

	public void layoutRootPane() {
		statusBar.setPosition(0, 0);
		statusBar.setSize(200, 30);
		// statusBar.adjustSize();
		// statusBar.setSize(1024, 30);
	}

	public RootPane createRootPane(RootPane rp) {
		rp.setTheme("");
		statusBar = GuiFactory.createTurnBar();
		rp.add(statusBar);
		return rp;
	}

	//
	// private void randomGenerationCommand(GameContainer container) {
	// if (container.getInput().isKeyPressed(Input.KEY_SPACE)) {
	// em = EntityManagerFactory.buildGalaxyTest();
	// main.manager = em;
	// clear();
	// }
	// }

	//
	// private void checkSelectedStar(Input input) {
	// if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
	// int mx = input.getAbsoluteMouseX() / Entity.TILE_SIZE;
	// int my = input.getAbsoluteMouseY() / Entity.TILE_SIZE;
	// System.out.println(mx + "," + my);
	// selectedStar = em.findStarEntity(mx, my);
	// if (selectedStar != null) {
	// if (currentSelection != null) {
	// remove(currentSelection);
	// currentSelection = null;
	// }
	// currentSelection = new SelectionElement(selectedStar.cx,
	// selectedStar.cy, true, selectedStar.star);
	// add(currentSelection);
	// Log.debug("Selected star with id " + selectedStar.id
	// + " , name " + selectedStar.star.name);
	//
	// }
	// }
	// if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
	// selectedStar = null;
	// remove(currentSelection);
	// currentSelection = null;
	// }
	//
	// }
}
