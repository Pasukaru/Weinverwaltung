package gui.wine.table;

import gui.wine.table.column.ColumnModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Wine;

public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private ColumnModel columnModel;
	private List<Wine> data;

	public TableModel(List<Wine> data) {
		super();
		this.columnModel = new ColumnModel();
		this.data = data;
	}

	private List<Wine> getData() {
		return data;
	}

	public Wine getRow(int row) {
		List<Wine> data = getData();
		Wine wine = null;
		if (row >= 0 && data.size() > row) {
			wine = getData().get(row);
		}
		return wine;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(final int col) {
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
