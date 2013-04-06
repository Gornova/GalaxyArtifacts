package it.galaxyArtifacts.generate.interfaces;

import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.model.Connections;

public interface Connectable {

	/**
	 * Create connection between entities, using adjacent matrix in Connections
	 * 
	 * @see Connections
	 */
	public void connect(EntityManager em, Connections c);

}
