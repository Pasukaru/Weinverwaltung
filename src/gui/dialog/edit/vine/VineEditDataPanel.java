package gui.dialog.edit.vine;


import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;

import model.Vine;

public class VineEditDataPanel extends EditDataPanel<Vine> {

	private static final long serialVersionUID = 646403762781205389L;

	public VineEditDataPanel(VineEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}

	private void addName() {
		add(new JLabel("Rebsorte"), next(0, ++gridy));
		add(name, next(1, gridy));
	}
}
