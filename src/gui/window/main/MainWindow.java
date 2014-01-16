package gui.window.main;

import gui.window.BaseWindow;
import gui.wine.table.Table;
import gui.wine.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import model.Vine;
import model.Wine;

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

		Wine w = new Wine(
			"Irgendwas",
			new HashSet<Vine>(),
			null,
			null,
			null,
			null);
		wines.add(w);

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

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
