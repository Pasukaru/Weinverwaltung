package gui.window.main;

import gui.wine.table.Table;
import gui.wine.table.TableModel;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import model.Wine;

public class TablePanel extends JScrollPane {
	private static final long serialVersionUID = -4486226458897430944L;

	private Table table;

	public TablePanel(Table table) {
		this.table = table;
		this.setViewportView(table);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	}

	private TableModel getModel() {
		return ((TableModel) table.getModel());
	}

	public Wine getSelectedRow() {
		return getModel().getRow(table.getSelectedRow());
	}
}
