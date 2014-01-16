package gui.wine.table.column;

import model.City;
import model.Wine;

public class CityColumn extends Column<String> {

	public CityColumn() {
		super("City", String.class);
	}

	@Override
	public String getValue(Wine wine, int row, int col) {
		City city = wine.getCity();
		return city == null ? "---" : city.getName();
	}
}
