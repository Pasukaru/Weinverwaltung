package gui.window.edit;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;

	private final EditWindow editWindow;

	public ButtonsPanel(EditWindow p) {
		super();
		this.editWindow = p;

		setLayout(new FlowLayout());
		this.add(new SaveButton(editWindow));
	}
}
