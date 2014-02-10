package gui.window.main.tabs.wines;

import gui.ActionButton;
import gui.window.edit.wine.EditWindow;

import java.awt.event.ActionEvent;

import model.Wine;

public class AddButton extends ActionButton {

	private final WineTab tab;
	private static final long serialVersionUID = -1778114520964065458L;

	public AddButton(final WineTab tab) {
		super("Add");
		this.tab = tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new EditWindow(new Wine()).setVisible(true);
	}
}
