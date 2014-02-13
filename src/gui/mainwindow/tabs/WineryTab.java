package gui.mainwindow.tabs;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.winery.WineryEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.winery.WineryColumnDefinition;
import model.Winery;

public class WineryTab extends ModelTab<Winery> {

	private static final long serialVersionUID = -6218897174571210449L;

	public WineryTab() {
		super(Winery.class, "Winzer");
	}

	@Override
	public ModelTableModel<Winery> initTableModel() {
		return new ModelTableModel<Winery>(new WineryColumnDefinition());
	}

	@Override
	public EditDialog<Winery> getEditDialog() {
		return new WineryEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Winery> getCreateDialog() {
		return new WineryEditDialog(new Winery());
	}
}