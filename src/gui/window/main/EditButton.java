package gui.window.main;

import gui.ActionButton;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Wine;

public class EditButton extends ActionButton implements ListSelectionListener {

	private final MainWindow mainWindow;
	private static final long serialVersionUID = -1778114520964065458L;

	public EditButton(final MainWindow parent) {
		super("Edit");
		this.mainWindow = parent;

		setEnabled(false);
		parent.getTable().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.setEnabled(e.getFirstIndex() >= 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Wine w = mainWindow.getTableModel().getRow(
			mainWindow.getTable().getSelectionModel().getMinSelectionIndex());
		if (w == null) {
			JOptionPane.showMessageDialog(null, "No wine selected");
		} else {
			new gui.window.edit.EditWindow(w).setVisible(true);
		}
	}
}
