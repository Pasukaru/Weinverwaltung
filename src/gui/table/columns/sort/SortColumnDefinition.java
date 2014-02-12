package gui.table.columns.sort;

import gui.table.ModelTableColumnDefinition;
import gui.table.columns.IndexColumn;
import gui.table.columns.ModelColumn;

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
