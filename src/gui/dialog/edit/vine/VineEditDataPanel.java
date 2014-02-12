package gui.dialog.edit.vine;


import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Vine;

public class VineEditDataPanel extends EditDataPanel<Vine> {


	private static final long serialVersionUID = 646403762781205389L;

	private JTextField vine;
	private int gridy = 0;


	public VineEditDataPanel(VineEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}

	public String getName() {
		return vine.getText();
	}
	private void addName() {

		vine = new JTextField();
		vine.setText("");

		add(new JLabel("Vine"), next(0, ++gridy));
		add(vine, next(1, gridy));
	}
}
