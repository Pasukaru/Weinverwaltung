package gui.table.wine;

import gui.table.ModelColumn;
import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.Wine;

public class WineColumnDefinition extends ModelTableColumnDefinition<Wine> {

	public WineColumnDefinition() {
		columns = new ArrayList<ModelColumn<Wine, ?>>();
		columns.add(new WineIndexColumn());
		columns.add(new NameColumn());
		columns.add(new TypeColumn());
		columns.add(new CityColumn());
		columns.add(new RegionColumn());
		columns.add(new CountryColumn());
	}
}
