package gui.window.main;

import gui.ActionButton;

import java.awt.event.ActionEvent;

import model.Wine;

public class AddButton extends ActionButton {

	private final MainWindow mainWindow;
	private static final long serialVersionUID = -1778114520964065458L;

	public AddButton(final MainWindow parent) {
		super("Add");
		this.mainWindow = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new gui.window.edit.EditWindow(new Wine(), mainWindow).setVisible(true);
	}
}
