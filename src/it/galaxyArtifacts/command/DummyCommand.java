package it.galaxyArtifacts.command;

import it.galaxyArtifacts.command.interfaces.Command;

public class DummyCommand implements Command {

	@Override
	public void execute() {
		System.out.println("dummy execute");
	}

}
