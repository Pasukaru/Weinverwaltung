package gui.mainwindow.tabs;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.wine.WineEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.wine.WineColumnDefinition;
import model.Wine;

public class WineTab extends ModelTab<Wine> {

	private static final long serialVersionUID = -6218897174571210449L;

	public WineTab() {
		super(Wine.class);
	}
	
	@Override
	public ModelTableModel<Wine> initTableModel() {
		return new ModelTableModel<Wine>(fetchData(), new WineColumnDefinition());
	}

	@Override
	public EditDialog<Wine> getEditDialog() {
		return new WineEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Wine> getCreateDialog() {
		return new WineEditDialog(new Wine());
	}
}