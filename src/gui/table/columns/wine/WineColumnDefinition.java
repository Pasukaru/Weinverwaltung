package gui.table.columns.wine;

import gui.table.ModelTableColumnDefinition;
import gui.table.columns.IndexColumn;
import gui.table.columns.ModelColumn;

import java.util.ArrayList;

import model.Wine;

public class WineColumnDefinition extends ModelTableColumnDefinition<Wine> {

	public WineColumnDefinition() {
		columns = new ArrayList<ModelColumn<Wine, ?>>();
		columns.add(new IndexColumn<Wine>());
		columns.add(new NameColumn());
		columns.add(new TypeColumn());
		columns.add(new CityColumn());
		columns.add(new RegionColumn());
		columns.add(new CountryColumn());
	}
}
