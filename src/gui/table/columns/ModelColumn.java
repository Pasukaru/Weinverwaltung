package gui.table.columns;

import model.Model;

public abstract class ModelColumn<T extends Model, V> {

	protected String name;
	protected Class<V> clazz;

	public ModelColumn(String name, Class<V> clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public Class<V> getValueClass() {
		return clazz;
	}

	public abstract V getValue(T model, int row, int col);

}
