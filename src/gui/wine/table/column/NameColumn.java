package gui.wine.table.column;

import model.Wine;

public class NameColumn extends Column<String> {

	public NameColumn() {
		super("Name", String.class);
	}

	@Override
	public String getValue(Wine wine, int row, int col) {
		return wine.getName();
	}

}
