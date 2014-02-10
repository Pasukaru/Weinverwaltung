package gui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Model;

public class ModelTableModel<T extends Model> extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	protected ModelTableColumnDefinition<T> columnModel;
	private List<T> data;

	public ModelTableModel(List<T> data) {
		super();
		this.data = data;
	}

	private List<T> getData() {
		return data;
	}

	public T getRow(int row) {
		List<T> data = getData();
		T wine = null;
		if (row >= 0 && data.size() > row) {
			wine = getData().get(row);
		}
		return wine;
	}

	@Override
	public Class<?> getColumnClass(final int col) {
		Object value = getValueAt(0, col);
		return value == null ? Object.class : value.getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	};

	@Override
	public String getColumnName(int col) {
		return columnModel.getName(col);
	}

	@Override
	public int getColumnCount() {
		return columnModel.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return getData().size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		return columnModel.getValue(getData().get(row), row, col);
	}

}
