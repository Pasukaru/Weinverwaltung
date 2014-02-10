package gui.window.edit.city;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;

	private final EditCityWindow editCityWindow;

	public ButtonsPanel(EditCityWindow p) {
		super();
		this.editCityWindow = p;

		setLayout(new FlowLayout());
		this.add(new SaveButton(editCityWindow));
	}
}
