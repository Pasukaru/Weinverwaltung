package gui.table.columns;

import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.Vine;

public class VineColumnDefinition extends ModelTableColumnDefinition<Vine> {

	public VineColumnDefinition() {
		columns = new ArrayList<ModelColumn<Vine, ?>>();

		columns.add(new IndexColumn<Vine>());

		columns.add(new ModelColumn<Vine, String>("Name", String.class){
			@Override
			public String getValue(Vine model, int row, int col) {
				return model.getName();
			}
		});

	}
}
