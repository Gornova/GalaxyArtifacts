package it.galaxyArtifacts.gui;

import it.galaxyArtifacts.Main;
import it.galaxyArtifacts.core.Entity;
import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.core.interfaces.Renderable;
import it.galaxyArtifacts.core.interfaces.Updatable;
import it.galaxyArtifacts.entities.StarEntity;
import it.galaxyArtifacts.util.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class GuiManager implements Updatable, Renderable {

	public List<GuiElement> elements = new ArrayList<GuiElement>();
	private EntityManager em;
	private StarEntity selectedStar;
	private SelectionElement currentSelection;
	private Main main;

	public GuiManager(Main m) {
		this.main = m;
		this.em = m.manager;
	}

	public GuiManager add(GuiElement e) {
		if (!elements.contains(e)) {
			elements.add(e);
		}
		return this;
	}

	public GuiManager remove(GuiElement e) {
		if (elements.contains(e)) {
			elements.remove(e);
		}
		return this;
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		for (GuiElement e : elements) {
			if (e instanceof Renderable) {
				e.render(container, g);
			}
		}
	}

	@Override
	public void update(GameContainer container) {
		checkSelectedStar(container.getInput());
		randomGenerationCommand(container);
		for (GuiElement e : elements) {
			if (e instanceof Updatable) {
				e.update(container);
			}
		}
	}

	private void randomGenerationCommand(GameContainer container) {
		if (container.getInput().isKeyPressed(Input.KEY_SPACE)) {
			em = EntityManagerFactory.buildGalaxyTest();
			main.manager = em;
			clear();
		}
	}

	public void clear() {
		elements.clear();
	}

	private void checkSelectedStar(Input input) {
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			int mx = input.getAbsoluteMouseX() / Entity.TILE_SIZE;
			int my = input.getAbsoluteMouseY() / Entity.TILE_SIZE;
			System.out.println(mx + "," + my);
			selectedStar = em.findStarEntity(mx, my);
			if (selectedStar != null) {
				if (currentSelection != null) {
					remove(currentSelection);
					currentSelection = null;
				}
				currentSelection = new SelectionElement(selectedStar.cx,
						selectedStar.cy, true, selectedStar.star);
				add(currentSelection);
				Log.debug("Selected star with id " + selectedStar.id
						+ " , name " + selectedStar.star.name);

			}
		}
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
			selectedStar = null;
			remove(currentSelection);
			currentSelection = null;
		}

	}
}
