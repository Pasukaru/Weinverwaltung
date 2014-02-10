package gui.table.wine;

import javax.swing.JTable;

public class WineTable extends JTable {

	private static final long serialVersionUID = 1L;

	public WineTable(WineTableModel m) {
		super(m);

		this.setRowHeight(25);
	}
}