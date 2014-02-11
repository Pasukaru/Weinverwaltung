package gui.table.columns.city;

import gui.table.ModelTableColumnDefinition;
import gui.table.columns.IndexColumn;
import gui.table.columns.ModelColumn;

import java.util.ArrayList;

import model.City;
import model.Country;
import model.Region;

public class CityColumnDefinition extends ModelTableColumnDefinition<City> {

	public CityColumnDefinition() {
		columns = new ArrayList<ModelColumn<City, ?>>();

		columns.add(new IndexColumn<City>());

		columns.add(new ModelColumn<City, String>("Country", String.class){
			@Override
			public String getValue(City model, int row, int col) {
				String value = "---";
				Region region = model.getRegion();
				if(region != null){
					Country country = region.getCountry();
					if(country != null){
						value = country.getName();
					}
				}
				return value;
			}
		});

	}
}
