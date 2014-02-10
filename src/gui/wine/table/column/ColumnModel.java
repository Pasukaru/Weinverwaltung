package gui.wine.table.column;

import java.util.ArrayList;
import java.util.List;

import model.Wine;

public class ColumnModel {

	private List<Column<?>> columns;

	public ColumnModel() {
		columns = new ArrayList<Column<?>>();
		columns.add(new IndexColumn());
		columns.add(new NameColumn());
		columns.add(new TypeColumn());
		columns.add(new CityColumn());
		columns.add(new RegionColumn());
		columns.add(new CountryColumn());
	}

	public String getName(int col) {
		return columns.get(col).getName();
	}

	public int getColumnCount() {
		return columns.size();
	}

	public Object getValue(Wine wine, int row, int col) {
		return columns.get(col).getValue(wine, row, col);
	}
}
