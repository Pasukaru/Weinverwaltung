package gui.table.wine;

import gui.table.ModelColumn;
import model.Wine;

public class NameColumn extends ModelColumn<Wine, String> {

	public NameColumn() {
		super("Name", String.class);
	}

	@Override
	public String getValue(Wine wine, int row, int col) {
		return wine.getName();
	}

}
