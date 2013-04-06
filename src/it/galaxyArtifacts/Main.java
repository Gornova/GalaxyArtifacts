package it.galaxyArtifacts;

import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.gui.GuiManager;
import it.galaxyArtifacts.util.EntityManagerFactory;
import it.galaxyArtifacts.util.GuiFactory;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {

	public EntityManager manager;
	public GuiManager gui;

	public Main(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		manager = EntityManagerFactory.buildGalaxyTest();
		gui = GuiFactory.buildEmpty(this);
		container
				.setMouseCursor(new Image("res/gui/leftarrownormal.png"), 0, 0);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		manager.render(container, g);
		gui.render(container, g);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		gui.update(container);
	}

	public static void main(String[] args) throws SlickException {
		Main game = new Main("Galaxy Artifacts - Sprint 1");
		AppGameContainer container = new AppGameContainer(game);
		container.setDisplayMode(1024, 768, false);
		container.setAlwaysRender(true);
		container.setTargetFrameRate(40);
		container.start();
	}
}
