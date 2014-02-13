package gui.table;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import model.Model;

public class ModelTableScrollPane<T extends Model> extends JScrollPane {
	private static final long serialVersionUID = -4486226458897430944L;

	public ModelTableScrollPane(ModelTable<T> table) {
		this.setViewportView(table);
		setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
	}
}
