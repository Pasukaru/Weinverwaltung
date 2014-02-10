package gui.mainwindow.tabs.wine;

import gui.ActionButton;
import gui.dialog.edit.wine.WineEditDialog;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Wine;

public class EditButton extends ActionButton implements ListSelectionListener {

	private final WineTab tab;
	private static final long serialVersionUID = -1778114520964065458L;

	public EditButton(final WineTab parent) {
		super("Edit");
		this.tab = parent;

		setEnabled(false);
		parent.getTable().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.setEnabled(e.getFirstIndex() >= 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Wine w = tab.getSelectedModel();
		if (w == null) {
			JOptionPane.showMessageDialog(null, "No wine selected");
		} else {
			new WineEditDialog(w).show();
		}
	}
}
