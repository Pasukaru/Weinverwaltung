package gui.mainwindow.tabs;

import events.EventManager;
import gui.dialog.edit.EditDialog;
import gui.dialog.edit.city.CityEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.city.CityColumnDefinition;
import model.City;
import util.Repository;

public class CityTab extends ModelTab<City> {

	private static final long serialVersionUID = -6218897174571210449L;


	public CityTab(EventManager eventManager) {
		super(eventManager);
	}

	@Override
	public ModelTableModel<City> initTableModel() {
		return new ModelTableModel<City>(Repository.getInstance().getAllCities(), new CityColumnDefinition());
	}

	@Override
	public EditDialog<City> getEditDialog() {
		return new CityEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<City> getCreateDialog() {
		return new CityEditDialog(new City());
	}
}