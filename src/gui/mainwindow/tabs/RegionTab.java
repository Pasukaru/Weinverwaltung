package gui.mainwindow.tabs;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.region.RegionEditDialog;
import gui.mainwindow.MainWindow;
import gui.table.ModelTableModel;
import gui.table.columns.RegionColumnDefinition;
import model.Region;

public class RegionTab extends ModelTab<Region> {

	private static final long serialVersionUID = -6218897174571210449L;

	public RegionTab(MainWindow mainWindow) {
		super(mainWindow, Region.class, "Regionen");
	}

	@Override
	public ModelTableModel<Region> initTableModel() {
		return new ModelTableModel<Region>(new RegionColumnDefinition());
	}

	@Override
	public EditDialog<Region> getEditDialog() {
		return new RegionEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Region> getCreateDialog() {
		return new RegionEditDialog(new Region());
	}
}