package gui.wine.table.column;

import model.Wine;

public abstract class Column<T> {

	protected String name;
	protected Class<?> clazz;

	public Column(String name, Class<?> clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public Class<?> getValueClass() {
		return clazz;
	}

	public abstract T getValue(Wine wine, int row, int col);

}
