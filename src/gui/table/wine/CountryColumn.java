package gui.table.wine;

import gui.table.ModelColumn;
import model.City;
import model.Country;
import model.Region;
import model.Wine;

public class CountryColumn extends ModelColumn<Wine, String> {

	public CountryColumn() {
		super("Country", String.class);
	}

	@Override
	public String getValue(Wine wine, int row, int col) {
		String value = "---";
		City city = wine.getCity();
		if (city != null) {
			Region region = city.getRegion();
			if (region != null) {
				Country country = region.getCountry();
				if (country != null) {
					value = country.getName();
				}
			}
		}
		return value;
	}
}
