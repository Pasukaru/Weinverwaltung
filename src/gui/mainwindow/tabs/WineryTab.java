package gui.mainwindow.tabs;

import java.util.List;

import events.EventManager;
import gui.dialog.edit.EditDialog;
import gui.dialog.edit.winery.WineryEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.winery.WineryColumnDefinition;
import model.Winery;
import util.Repository;

public class WineryTab extends ModelTab<Winery> {

	private static final long serialVersionUID = -6218897174571210449L;


	public WineryTab(EventManager eventManager) {
		super(eventManager);
	}

	@Override
	public List<Winery> fetchData() {
		return Repository.getInstance().getAllWineries();
	}

	@Override
	public ModelTableModel<Winery> initTableModel() {
		return new ModelTableModel<Winery>(fetchData(), new WineryColumnDefinition());
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