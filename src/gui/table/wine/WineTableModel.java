package gui.table.wine;

import gui.table.ModelTableModel;

import java.util.List;

import model.Wine;

public class WineTableModel extends ModelTableModel<Wine> {

	private static final long serialVersionUID = -6502976641325537106L;

	public WineTableModel(List<Wine> data) {
		super(data);
		columnModel = new WineColumnDefinition();
	}

}
