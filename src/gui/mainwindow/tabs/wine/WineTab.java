package gui.mainwindow.tabs.wine;

import events.EventManager;
import gui.mainwindow.tabs.ModelTab;
import gui.table.wine.WineTable;
import gui.table.wine.WineTableModel;

import java.awt.BorderLayout;

import model.Wine;
import util.Repository;

public class WineTab extends ModelTab {

	private static final long serialVersionUID = -6218897174571210449L;

	private final WineTableModel tableModel;
	private final WineTable table;

	public WineTab(EventManager eventManager) {
		super(eventManager);
		tableModel = new WineTableModel(Repository.getInstance().getAllWines());
		table = new WineTable(tableModel);

		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, new TablePanel(table));
		add(BorderLayout.SOUTH, new ButtonsPanel(this));
	}

	public Wine getSelectedModel() {
		return tableModel.getRow(table
			.getSelectionModel()
			.getMinSelectionIndex());
	}

	public WineTable getTable() {
		return table;
	}
}
