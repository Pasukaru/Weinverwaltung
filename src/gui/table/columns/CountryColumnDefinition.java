package gui.table.columns;

import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.Country;

public class CountryColumnDefinition extends ModelTableColumnDefinition<Country> {

	public CountryColumnDefinition() {
		columns = new ArrayList<ModelColumn<Country, ?>>();

		columns.add(new IndexColumn<Country>());

		columns.add(new ModelColumn<Country, String>("Name", String.class){
			@Override
			public String getValue(Country model, int row, int col) {
				return model.getName();
			}
		});

	}
}
