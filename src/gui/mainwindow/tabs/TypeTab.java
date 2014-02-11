package gui.mainwindow.tabs;

import java.util.List;

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
	public List<Type> fetchData() {
		return Repository.getInstance().getAllTypes();
	}

	@Override
	public ModelTableModel<Type> initTableModel() {
		return new ModelTableModel<Type>(fetchData(), new TypeColumnDefinition());
	}

	@Override
	public EditDialog<Type> getEditDialog() {
		return new TypeEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Type> getCreateDialog() {
		return new TypeEditDialog(new Type());
	}
}