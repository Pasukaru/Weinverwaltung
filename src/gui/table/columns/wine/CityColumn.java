package gui.table.columns.wine;

import gui.table.columns.ModelColumn;
import model.City;
import model.Wine;

public class CityColumn extends ModelColumn<Wine, String> {

	public CityColumn() {
		super("City", String.class);
	}

	@Override
	public String getValue(Wine wine, int row, int col) {
		City city = wine.getCity();
		return city == null ? "---" : city.getName();
	}
}
