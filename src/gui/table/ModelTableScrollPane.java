package gui.table;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import model.Model;

public class ModelTableScrollPane<T extends Model> extends JScrollPane {
	private static final long serialVersionUID = -4486226458897430944L;

	public ModelTableScrollPane(ModelTable<T> table) {
		this.setViewportView(table);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	}
}
