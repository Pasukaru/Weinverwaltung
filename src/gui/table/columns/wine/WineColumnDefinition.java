package gui.table.columns.wine;

import gui.table.ModelTableColumnDefinition;
import gui.table.columns.IndexColumn;
import gui.table.columns.ModelColumn;

import java.util.ArrayList;

import model.City;
import model.Country;
import model.Region;
import model.Sort;
import model.Wine;
import model.Winery;

public class WineColumnDefinition extends ModelTableColumnDefinition<Wine> {

	public WineColumnDefinition() {
		columns = new ArrayList<ModelColumn<Wine, ?>>();
		columns.add(new IndexColumn<Wine>());

		columns.add(new ModelColumn<Wine, String>("Name", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				return model.getName();
			}
		});

		columns.add(new ModelColumn<Wine, String>("Type", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				String value = "---";
				model.Type type = model.getType();
				if (type != null) {
					value = type.getName();
				}
				return value;
			}
		});

		columns.add(new ModelColumn<Wine, String>("Sort", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				String value = "---";
				Sort sort = model.getSort();
				if (sort != null) {
					value = sort.getName();
				}
				return value;
			}
		});

		columns.add(new ModelColumn<Wine, String>("Winery", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				String value = "---";
				Winery winery = model.getWinery();
				if (winery != null) {
							value = winery.getName();
				}
				return value;
			}
		});

		columns.add(new ModelColumn<Wine, String>("City", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				String value = "---";
				City city = model.getCity();
				if (city != null) {
					value = city.getName();
				}
				return value;
			}
		});

		columns.add(new ModelColumn<Wine, String>("Region", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				String value = "---";
				City city = model.getCity();
				if (city != null) {
					Region region = city.getRegion();
					if (region != null) {
						value = region.getName();
					}
				}
				return value;
			}
		});

		columns.add(new ModelColumn<Wine, String>("Country", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				String value = "---";
				City city = model.getCity();
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
		});

		//TODO Vine muss noch mit hinzugefügt werden!


		// columns.add(new NameColumn());
		// columns.add(new TypeColumn());
		// columns.add(new CityColumn());
		// columns.add(new RegionColumn());
		// columns.add(new CountryColumn());
	}
}
