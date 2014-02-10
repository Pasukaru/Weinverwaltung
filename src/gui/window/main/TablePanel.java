package gui.window.main;

import gui.table.wine.WineTable;
import gui.table.wine.WineTableModel;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import model.Wine;

public class TablePanel extends JScrollPane {
	private static final long serialVersionUID = -4486226458897430944L;

	private WineTable table;

	public TablePanel(WineTable table) {
		this.table = table;
		this.setViewportView(table);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	}

	private WineTableModel getModel() {
		return ((WineTableModel) table.getModel());
	}

	public Wine getSelectedRow() {
		return getModel().getRow(table.getSelectedRow());
	}
}
