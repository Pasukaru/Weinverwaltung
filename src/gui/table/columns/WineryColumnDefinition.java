package gui.table.columns;

import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.Winery;

public class WineryColumnDefinition extends ModelTableColumnDefinition<Winery> {

	public WineryColumnDefinition() {
		columns = new ArrayList<ModelColumn<Winery, ?>>();

		columns.add(new IndexColumn<Winery>());

		columns.add(new ModelColumn<Winery, String>("Name", String.class){
			@Override
			public String getValue(Winery model, int row, int col) {
				return model.getName();
			}
		});

	}
}
