package gui.table.wine;

import gui.table.ModelColumn;
import model.Wine;

public class WineIndexColumn extends ModelColumn<Wine, Integer> {

	public WineIndexColumn() {
		super("#", Integer.class);
	}

	@Override
	public Integer getValue(Wine wine, int row, int col) {
		return row + 1;
	}

}
