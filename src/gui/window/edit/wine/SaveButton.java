package gui.window.edit.wine;

import gui.ActionButton;

import java.awt.event.ActionEvent;

import model.Wine;
import util.Repository;

public class SaveButton extends ActionButton {

	private static final long serialVersionUID = 5049875329071992746L;

	private final Wine wine;
	private final EditWindow editWindow;

	public SaveButton(EditWindow editWindow) {
		super();
		this.editWindow = editWindow;
		this.wine = editWindow.getWine();
		if (editWindow.getWine().getId() == null) {
			this.setText("Create");
		} else {
			this.setText("Update");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DataPanel data = editWindow.getDataPanel();
		wine.setName(data.getName());
		wine.setCity(data.getCity());
		wine.setType(data.getType());
		Repository.getInstance().updateWine(wine);
		editWindow.dispose();
		editWindow.getMainWindow().getTableModel().fireTableDataChanged();
	}
}
