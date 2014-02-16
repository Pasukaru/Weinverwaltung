package gui.dialog.edit.winery;

import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;

import model.Winery;

public class WineryEditDataPanel extends EditDataPanel<Winery> {

	private static final long serialVersionUID = 646403762781205389L;

	public WineryEditDataPanel(WineryEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}

	private void addName() {
		add(new JLabel("Winzer"), next(0, ++gridy));
		add(name, next(1, gridy));
	}
}
