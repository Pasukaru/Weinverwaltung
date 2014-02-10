package gui.window.main.tabs.wines;

import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;

	public ButtonsPanel(WineTab tab) {
		super();
		this.add(new AddButton());
		this.add(new EditButton(tab));
	}
}
