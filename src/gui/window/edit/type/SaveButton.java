package gui.window.edit.type;

import gui.ActionButton;

import java.awt.event.ActionEvent;

import model.Type;
import util.Repository;

public class SaveButton extends ActionButton {

	private static final long serialVersionUID = 5049875329071992746L;

	private final Type type;
	private final EditWindow editWindow;

	public SaveButton(EditWindow editWindow) {
		super();
		this.editWindow = editWindow;
		this.type = editWindow.getWineType();
		if (type.getId() == null) {
			this.setText("Create");
		} else {
			this.setText("Update");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DataPanel data = editWindow.getDataPanel();
		type.setName(data.getName());
		Repository.getInstance().updateType(type);
		editWindow.dispose();
		editWindow.getMainWindow().getTableModel().fireTableDataChanged();
	}
}
