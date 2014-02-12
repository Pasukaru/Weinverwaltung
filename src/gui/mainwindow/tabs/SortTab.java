package gui.mainwindow.tabs;

import java.util.List;

import events.EventManager;
import gui.dialog.edit.EditDialog;
import gui.dialog.edit.sort.SortEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.sort.SortColumnDefinition;
import model.Sort;
import util.Repository;

public class SortTab extends ModelTab<Sort> {

	private static final long serialVersionUID = -6218897174571210449L;


	public SortTab(EventManager eventManager) {
		super(eventManager);
	}

	@Override
	public List<Sort> fetchData() {
		return Repository.getInstance().getAllSorts();
	}

	@Override
	public ModelTableModel<Sort> initTableModel() {
		return new ModelTableModel<Sort>(fetchData(), new SortColumnDefinition());
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