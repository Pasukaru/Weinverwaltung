package gui.dialog.edit.sort;


import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;

import model.Sort;

public class SortEditDataPanel extends EditDataPanel<Sort> {


	private static final long serialVersionUID = 646403762781205389L;

	public SortEditDataPanel(SortEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}

	private void addName() {
		add(new JLabel("Weinsorte"), next(0, ++gridy));
		add(name, next(1, gridy));
	}
}
