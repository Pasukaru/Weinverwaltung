package gui.mainwindow.tabs;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.city.CityEditDialog;
import gui.mainwindow.MainWindow;
import gui.table.ModelTableModel;
import gui.table.columns.city.CityColumnDefinition;
import model.City;

public class CityTab extends ModelTab<City> {

	private static final long serialVersionUID = -6218897174571210449L;

	public CityTab(MainWindow mainWindow) {
		super(mainWindow, City.class, "Städte");
	}
	
	@Override
	public ModelTableModel<City> initTableModel() {
		return new ModelTableModel<City>(new CityColumnDefinition());
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