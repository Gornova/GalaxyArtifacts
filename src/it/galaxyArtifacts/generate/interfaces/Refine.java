package it.galaxyArtifacts.generate.interfaces;

import it.galaxyArtifacts.model.Connections;

public interface Refine {

	/**
	 * Refine connection in adjacent matrix
	 * 
	 * @see Connections
	 */
	public Connections refine(Connections c);

}
