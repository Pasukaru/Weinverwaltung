package gui.window.main.tabs;

import javax.swing.JPanel;

import events.EventManager;

public class MainTab extends JPanel {

	private static final long serialVersionUID = 6963316486962402827L;

	protected final EventManager eventManager;

	public MainTab(EventManager eventManager) {
		this.eventManager = eventManager;
	}

}
