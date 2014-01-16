package gui.wine.table.column;

import model.Wine;

public class IndexColumn extends Column<Integer> {

	public IndexColumn() {
		super("#", Integer.class);
	}

	@Override
	public Integer getValue(Wine wine, int row, int col) {
		return row + 1;
	}

}
