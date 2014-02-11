package gui.table.columns.wine;

import gui.table.columns.ModelColumn;
import model.City;
import model.Region;
import model.Wine;

public class RegionColumn extends ModelColumn<Wine, String> {

	public RegionColumn() {
		super("Region", String.class);
	}

	@Override
	public String getValue(Wine wine, int row, int col) {
		String value = "---";
		City city = wine.getCity();
		if (city != null) {
			Region region = city.getRegion();
			if (region != null) {
				value = region.getName();
			}
		}
		return value;
	}
}
