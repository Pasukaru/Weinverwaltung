package gui.table.columns.wine;

import gui.table.ModelTableColumnDefinition;
import gui.table.columns.IndexColumn;
import gui.table.columns.ModelColumn;

import java.util.ArrayList;
import java.util.Set;

import util.StringUtils;
import model.City;
import model.Country;
import model.Region;
import model.Sort;
import model.Vine;
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
		
		columns.add(new ModelColumn<Wine, String>("Preis", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				return StringUtils.formatPrice(model.getPrice());
			}
		});

		columns.add(new ModelColumn<Wine, String>("Weinart", String.class) {
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

		columns.add(new ModelColumn<Wine, String>("Weinsorte", String.class) {
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

		columns.add(new ModelColumn<Wine, String>("Rebsorten", String.class) {
			@Override
			public String getValue(Wine model, int row, int col) {
				String value = "---";
				Set<Vine> vines = model.getVine();
				if (vines != null) {
					for (Vine vine : vines) {
						if(value.equals("---")){
							value = vine.getName();
						}else{
							value = value+", "+vine.getName();
						}
					}
				}
				return value;
			}
		});

		columns.add(new ModelColumn<Wine, String>("Winzer", String.class) {
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

		columns.add(new ModelColumn<Wine, String>("Stadt", String.class) {
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

		columns.add(new ModelColumn<Wine, String>("Land", String.class) {
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
	}
}
