package it.galaxyArtifacts.command;

import it.galaxyArtifacts.command.interfaces.Command;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.util.Log;

public class CommandManager {

	public List<Command> commands = new ArrayList<Command>();

	public CommandManager() {
	}

	public CommandManager add(Command c) {
		commands.add(c);
		return this;
	}

	public CommandManager execute() {
		Log.info("Execute commands");
		for (Command com : commands) {
			com.execute();
		}
		return this;
	}

}
