package gui.window.main.tabs.wines;

import gui.ActionButton;
import gui.dialog.edit.wine.WineEditDialog;

import java.awt.event.ActionEvent;

import model.Wine;

public class AddButton extends ActionButton {

	private static final long serialVersionUID = -1778114520964065458L;

	public AddButton() {
		super("Add");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new WineEditDialog(new Wine()).show();
	}
}
