package gui.mainwindow.tabs;

import events.EventManager;
import gui.dialog.edit.EditDialog;
import gui.dialog.type.TypeEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.type.TypeColumnDefinition;
import model.Type;
import util.Repository;

public class TypeTab extends ModelTab<Type> {

	private static final long serialVersionUID = -6218897174571210449L;


	public TypeTab(EventManager eventManager) {
		super(eventManager);
	}

	@Override
	public ModelTableModel<Type> initTableModel() {
		return new ModelTableModel<Type>(Repository.getInstance().getAllTypes(), new TypeColumnDefinition());
	}

	@Override
	public EditDialog<Type> getEditDialog() {
		return new TypeEditDialog(getSelectedModel(), eventManager);
	}

	@Override
	public EditDialog<Type> getCreateDialog() {
		return new TypeEditDialog(new Type(), eventManager);
	}
}