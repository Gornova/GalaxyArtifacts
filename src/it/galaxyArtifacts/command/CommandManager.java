package it.galaxyArtifacts.command;

import it.galaxyArtifacts.command.interfaces.Command;
import it.galaxyArtifacts.model.Galaxy;
import it.galaxyArtifacts.player.PlayerManager;
import it.galaxyArtifacts.util.PlayerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.util.Log;

public class CommandManager {

	public List<Command> commands = new ArrayList<Command>();

	public PlayerManager player;

	public CommandManager(Galaxy g) {
		player = PlayerFactory.buildTestManager(g);
	}

	public CommandManager add(Command c) {
		commands.add(c);
		return this;
	}

	public CommandManager addAll(List<Command> c) {
		commands.addAll(c);
		return this;
	}

	public CommandManager execute() {
		Log.info("Gather commands from players");
		player.execute(this);
		Log.info("Execute commands");
		for (Iterator<Command> iterator = commands.iterator(); iterator
				.hasNext();) {
			Command com = (Command) iterator.next();
			if (!com.isCompleted()) {
				com.execute();
			} else {
				iterator.remove();
			}
		}
		return this;
	}
}
