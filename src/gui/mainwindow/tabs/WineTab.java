package gui.mainwindow.tabs;

import events.EventManager;
import gui.dialog.edit.EditDialog;
import gui.dialog.edit.wine.WineEditDialog;
import gui.table.ModelTable;
import gui.table.ModelTableModel;
import gui.table.wine.WineTable;
import gui.table.wine.WineTableModel;
import model.Wine;
import util.Repository;

public class WineTab extends ModelTab<Wine> {

	private static final long serialVersionUID = -6218897174571210449L;


	public WineTab(EventManager eventManager) {
		super(eventManager);
	}

	@Override
	public ModelTableModel<Wine> initTableModel() {
		return new WineTableModel(Repository.getInstance().getAllWines());
	}


	@Override
	public ModelTable<Wine> initTable(ModelTableModel<Wine> tableModel) {
		return new WineTable(tableModel);
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
