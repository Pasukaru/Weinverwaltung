package gui.table.columns;

import gui.table.ModelTableColumnDefinition;

import java.util.ArrayList;

import model.Type;

public class TypeColumnDefinition extends ModelTableColumnDefinition<Type> {

	public TypeColumnDefinition() {
		columns = new ArrayList<ModelColumn<Type, ?>>();

		columns.add(new IndexColumn<Type>());

		columns.add(new ModelColumn<Type, String>("Name", String.class){
			@Override
			public String getValue(Type model, int row, int col) {
				return model.getName();
			}
		});

	}
}
