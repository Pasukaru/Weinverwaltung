package gui.table;

import model.Model;

public abstract class ModelColumn<T extends Model, V> {

	protected String name;
	protected Class<?> clazz;

	public ModelColumn(String name, Class<?> clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public Class<?> getValueClass() {
		return clazz;
	}

	public abstract V getValue(T model, int row, int col);

}
