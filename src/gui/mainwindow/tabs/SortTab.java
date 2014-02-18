package gui.mainwindow.tabs;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.sort.SortEditDialog;
import gui.mainwindow.MainWindow;
import gui.table.ModelTableModel;
import gui.table.columns.sort.SortColumnDefinition;
import model.Sort;

public class SortTab extends ModelTab<Sort> {

	private static final long serialVersionUID = -6218897174571210449L;

	public SortTab(MainWindow mainWindow) {
		super(mainWindow, Sort.class, "Weinsorten");
	}

	@Override
	public ModelTableModel<Sort> initTableModel() {
		return new ModelTableModel<Sort>(new SortColumnDefinition());
	}

	@Override
	public EditDialog<Sort> getEditDialog() {
		return new SortEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Sort> getCreateDialog() {
		return new SortEditDialog(new Sort());
	}
}