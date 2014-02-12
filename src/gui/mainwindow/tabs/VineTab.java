package gui.mainwindow.tabs;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.vine.VineEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.vine.VineColumnDefinition;
import model.Vine;

public class VineTab extends ModelTab<Vine> {

	private static final long serialVersionUID = -6218897174571210449L;

	public VineTab() {
		super(Vine.class);
	}

	@Override
	public ModelTableModel<Vine> initTableModel() {
		return new ModelTableModel<Vine>(fetchData(), new VineColumnDefinition());
	}

	@Override
	public EditDialog<Vine> getEditDialog() {
		return new VineEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Vine> getCreateDialog() {
		return new VineEditDialog(new Vine());
	}
}