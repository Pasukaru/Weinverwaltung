package gui.mainwindow.tabs;

import events.EventManager;
import gui.dialog.edit.EditDialog;
import gui.dialog.edit.wine.WineEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.wine.WineColumnDefinition;
import model.Wine;
import util.Repository;

public class WineTab extends ModelTab<Wine> {

	private static final long serialVersionUID = -6218897174571210449L;


	public WineTab(EventManager eventManager) {
		super(eventManager);
	}

	@Override
	public ModelTableModel<Wine> initTableModel() {
		return new ModelTableModel<Wine>(Repository.getInstance().getAllWines(), new WineColumnDefinition());
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