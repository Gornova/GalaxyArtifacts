package it.galaxyArtifacts.util;

import it.galaxyArtifacts.core.EntityManager;
import it.galaxyArtifacts.gui.GuiManager;
import it.galaxyArtifacts.model.Planet;
import it.galaxyArtifacts.model.Star;
import de.matthiasmann.twl.BoxLayout;
import de.matthiasmann.twl.BoxLayout.Direction;
import de.matthiasmann.twl.Button;
import de.matthiasmann.twl.DialogLayout;
import de.matthiasmann.twl.DialogLayout.Group;
import de.matthiasmann.twl.Label;
import de.matthiasmann.twl.Widget;

public class GuiFactory {

	private GuiFactory() {
	}

	public static GuiManager buildEmpty(EntityManager em) {
		GuiManager g = new GuiManager(em);
		return g;
	}

	public static Widget createTurnBar() {
		DialogLayout statusBar = new DialogLayout();
		statusBar.setTheme("turnbar");

		Label label = new Label();
		label.setText("Turn : 1");

		Button button = GuiFactory.createNextTurnButton();

		Group hz = statusBar.createParallelGroup(statusBar
				.createSequentialGroup().addMinGap(DialogLayout.DEFAULT_GAP)
				.addWidget(label));
		Group vz = statusBar.createParallelGroup(statusBar
				.createSequentialGroup().addMinGap(DialogLayout.DEFAULT_GAP)
				.addWidget(button));

		Group horizontal = statusBar.createSequentialGroup(hz, vz);

		Group hz2 = statusBar.createSequentialGroup(label);
		Group vz2 = statusBar.createSequentialGroup(button);

		Group vertical = statusBar.createParallelGroup(hz2, vz2);

		statusBar.setHorizontalGroup(horizontal);
		statusBar.setVerticalGroup(vertical);

		return statusBar;
	}

	public static Button createNextTurnButton() {
		Button button = new Button("Next Turn");
		button.addCallback(new Runnable() {
			public void run() {
				System.out.println("some action!");
			}
		});
		return button;
	}

	public static Widget createPlanetInfoExample() {
		DialogLayout grid = new DialogLayout();
		grid.setTheme("");

		Label label = new Label();
		label.setText("Type");

		Label label2 = new Label();
		label2.setText("Planet1");

		Label label3 = new Label();
		label3.setText("Yellow");

		Label label4 = new Label();
		label4.setText("terran");

		BoxLayout l = new BoxLayout(Direction.VERTICAL);
		l.add(label);
		l.add(label2);
		l.add(label3);
		l.add(label4);

		return l;
	}

	public static Widget createPlanetInfo(Star star) {
		DialogLayout grid = new DialogLayout();
		grid.setTheme("");

		BoxLayout l = new BoxLayout(Direction.VERTICAL);

		Label label = new Label();
		label.setText("Type " + star.type);
		l.add(label);

		for (Planet p : star.planets) {
			Label pl = new Label();
			pl.setText(p.name);
			l.add(pl);
		}

		// Label label2 = new Label();
		// label2.setText("Planet1");
		//
		// Label label3 = new Label();
		// label3.setText("Yellow");
		//
		// Label label4 = new Label();
		// label4.setText("terran");
		//
		// l.add(label);
		// l.add(label2);
		// l.add(label3);
		// l.add(label4);

		return l;
	}

}
