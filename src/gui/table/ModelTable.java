package gui.table;

import javax.swing.JTable;

import model.Model;

public class ModelTable<T extends Model> extends JTable {

	private static final long serialVersionUID = 4883419999473209610L;

	public ModelTable(ModelTableModel<T> tableModel){
		super(tableModel);
	}
}
