package gui.table.columns;

import model.Model;

public class IndexColumn<T extends Model> extends ModelColumn<T, Integer> {

	public IndexColumn() {
		super("#", Integer.class);
	}

	@Override
	public Integer getValue(T model, int row, int col) {
		return row + 1;
	}

}
