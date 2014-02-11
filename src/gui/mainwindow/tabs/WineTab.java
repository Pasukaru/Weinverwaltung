package gui.mainwindow.tabs;

import java.util.List;

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
	public List<Wine> fetchData() {
		return Repository.getInstance().getAllWines();
	}

	@Override
	public ModelTableModel<Wine> initTableModel() {
		return new ModelTableModel<Wine>(fetchData(), new WineColumnDefinition());
	}

	@Override
	public EditDialog<Wine> getEditDialog() {
		return new WineEditDialog(getSelectedModel(), eventManager);
	}

	@Override
	public EditDialog<Wine> getCreateDialog() {
		return new WineEditDialog(new Wine(), eventManager);
	}
}