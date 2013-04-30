package it.galaxyArtifacts.command;

import it.galaxyArtifacts.command.interfaces.Command;

public class DummyCommand implements Command {

	private boolean completed = false;

	@Override
	public void execute() {
		System.out.println("dummy execute");
		completed = true;
	}

	@Override
	public boolean isCompleted() {
		return completed;
	}

}
