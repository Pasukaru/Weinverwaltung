package gui.table;

import gui.table.columns.ModelColumn;

import java.util.List;

import model.Model;

public class ModelTableColumnDefinition<T extends Model> {

	protected List<ModelColumn<T, ?>> columns;

	public ModelTableColumnDefinition() {
		
	}

	public String getName(int col) {
		return columns.get(col).getName();
	}

	public int getColumnCount() {
		return columns.size();
	}

	public Object getValue(T model, int row, int col) {
		return columns.get(col).getValue(model, row, col);
	}
}
