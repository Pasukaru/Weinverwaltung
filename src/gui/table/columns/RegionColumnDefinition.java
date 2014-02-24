package gui.table.columns;

import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.Country;
import model.Region;

public class RegionColumnDefinition extends ModelTableColumnDefinition<Region> {

	public RegionColumnDefinition() {
		columns = new ArrayList<ModelColumn<Region, ?>>();

		columns.add(new IndexColumn<Region>());

		columns.add(new ModelColumn<Region, String>("Name", String.class){
			@Override
			public String getValue(Region model, int row, int col) {
				return model.getName();
			}
		});

		columns.add(new ModelColumn<Region, String>("Land", String.class){
			@Override
			public String getValue(Region model, int row, int col) {
				Country country = model.getCountry();
				return country.getName();
			}
		});

	}
}
