package it.galaxyArtifacts;

import it.galaxyArtifacts.command.CommandManager;
import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.gui.GuiManager;
import it.galaxyArtifacts.gui.twl.BasicTWLGameState;
import it.galaxyArtifacts.gui.twl.RootPane;
import it.galaxyArtifacts.util.EntityManagerFactory;
import it.galaxyArtifacts.util.GuiFactory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Game State, render graphics, gui and update logic
 */
public class GameState extends BasicTWLGameState {

	public EntityManager manager;
	public GuiManager gui;
	public CommandManager com;
	public static int turn = 1;

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		manager = EntityManagerFactory.buildGalaxyTest();
		com = new CommandManager();
		gui = GuiFactory.buildEmpty(manager, com);
		// TODO: problem with twl pipeline?
		// container
		// .setMouseCursor(new Image("res/gui/leftarrownormal.png"), 0, 0);
	}

	@Override
	protected RootPane createRootPane() {
		RootPane rp = super.createRootPane();
		return gui.createRootPane(rp);
	}

	@Override
	protected void layoutRootPane() {
		gui.layoutRootPane();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		manager.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// manager.update(container);
		gui.update(container);
	}

	@Override
	public int getID() {
		return 0;
	}

}
