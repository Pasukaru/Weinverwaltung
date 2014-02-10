package gui.window.main;

import gui.window.BaseWindow;
import gui.wine.table.Table;
import gui.wine.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import model.Wine;
import util.Repository;

public class MainWindow extends BaseWindow {

	private static final long serialVersionUID = 1L;

	private final List<Wine> wines;
	private final TableModel tableModel;
	private final Table table;
	private final TablePanel tableWrapper;

	public MainWindow() {
		super("Weinverwaltung");

		wines = new ArrayList<Wine>();

		tableModel = new TableModel(wines);
		table = new Table(tableModel);
		tableWrapper = new TablePanel(table);

		loadData();

		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());

		container.add(BorderLayout.CENTER, tableWrapper);
		container.add(BorderLayout.SOUTH, new ButtonsPanel(this));

		this.pack();
		this.setLocationRelativeTo(null);
	}

	public TableModel getTableModel() {
		return tableModel;
	}

	public Table getTable() {
		return table;
	}

	public void loadData() {
		List<Wine> wines = Repository.getInstance().getAllWines();
		this.wines.clear();
		this.wines.addAll(wines);
		this.getTableModel().fireTableDataChanged();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
