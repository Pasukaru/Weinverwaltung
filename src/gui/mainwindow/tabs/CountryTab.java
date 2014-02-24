package gui.mainwindow.tabs;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.country.CountryEditDialog;
import gui.mainwindow.MainWindow;
import gui.table.ModelTableModel;
import gui.table.columns.CountryColumnDefinition;
import model.Country;

public class CountryTab extends ModelTab<Country> {

	private static final long serialVersionUID = -6218897174571210449L;

	public CountryTab(MainWindow mainWindow) {
		super(mainWindow, Country.class, "Länder");
	}

	@Override
	public ModelTableModel<Country> initTableModel() {
		return new ModelTableModel<Country>(new CountryColumnDefinition());
	}

	@Override
	public EditDialog<Country> getEditDialog() {
		return new CountryEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Country> getCreateDialog() {
		return new CountryEditDialog(new Country());
	}
}