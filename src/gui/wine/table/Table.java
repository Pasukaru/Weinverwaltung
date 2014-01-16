package gui.wine.table;

import javax.swing.JTable;

public class Table extends JTable {

	private static final long serialVersionUID = 1L;

	public Table(TableModel m) {
		super(m);

		this.setRowHeight(25);
	}
}