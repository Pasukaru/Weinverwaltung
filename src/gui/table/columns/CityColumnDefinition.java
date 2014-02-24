package gui.table.columns;

import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.City;
import model.Country;
import model.Region;

public class CityColumnDefinition extends ModelTableColumnDefinition<City> {

	public CityColumnDefinition() {
		columns = new ArrayList<ModelColumn<City, ?>>();

		columns.add(new IndexColumn<City>());

		columns.add(new ModelColumn<City, String>("Name", String.class){
			@Override
			public String getValue(City model, int row, int col) {
				return model.getName();
			}
		});

		columns.add(new ModelColumn<City, String>("Region", String.class){
			@Override
			public String getValue(City model, int row, int col) {
				String value = "---";
				Region region = model.getRegion();
				if(region != null){
					value = region.getName();
				}
				return value;
			}
		});

		columns.add(new ModelColumn<City, String>("Land", String.class){
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
