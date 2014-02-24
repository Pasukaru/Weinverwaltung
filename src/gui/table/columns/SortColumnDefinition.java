package gui.table.columns;

import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.Sort;

public class SortColumnDefinition extends ModelTableColumnDefinition<Sort> {

	public SortColumnDefinition() {
		columns = new ArrayList<ModelColumn<Sort, ?>>();

		columns.add(new IndexColumn<Sort>());

		columns.add(new ModelColumn<Sort, String>("Name", String.class){
			@Override
			public String getValue(Sort model, int row, int col) {
				return model.getName();
			}
		});

	}
}
