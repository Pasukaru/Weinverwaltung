package gui.table.wine;

import gui.table.ModelColumn;
import model.Type;
import model.Wine;

public class TypeColumn extends ModelColumn<Wine, String> {

	public TypeColumn() {
		super("Type", String.class);
	}

	@Override
	public String getValue(Wine wine, int row, int col) {
		String value = "---";
		Type type = wine.getType();
		if (type != null) {
			value = type.getName();
		}
		return value;
	}
}
