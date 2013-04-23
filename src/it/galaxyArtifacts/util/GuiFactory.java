package it.galaxyArtifacts.util;

import it.galaxyArtifacts.gui.GuiManager;
import de.matthiasmann.twl.Button;
import de.matthiasmann.twl.DialogLayout;
import de.matthiasmann.twl.DialogLayout.Group;
import de.matthiasmann.twl.Label;
import de.matthiasmann.twl.Widget;

public class GuiFactory {

	private GuiFactory() {
	}

	public static GuiManager buildEmpty() {
		GuiManager g = new GuiManager();
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

}
