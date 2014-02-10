package gui.window.main.tabs.wines;

import events.EventManager;
import gui.window.main.TablePanel;
import gui.window.main.tabs.MainTab;
import gui.wine.table.Table;
import gui.wine.table.TableModel;

import java.awt.BorderLayout;

import model.Wine;
import util.Repository;

public class WineTab extends MainTab {

	private static final long serialVersionUID = -6218897174571210449L;

	private final TableModel tableModel;
	private final Table table;

	public WineTab(EventManager eventManager) {
		super(eventManager);
		tableModel = new TableModel(Repository.getInstance().getAllWines());
		table = new Table(tableModel);

		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, new TablePanel(table));
		add(BorderLayout.SOUTH, new ButtonsPanel(this));
	}

	public Wine getSelectedModel() {
		return tableModel.getRow(table
			.getSelectionModel()
			.getMinSelectionIndex());
	}

	public Table getTable() {
		return table;
	}
}
