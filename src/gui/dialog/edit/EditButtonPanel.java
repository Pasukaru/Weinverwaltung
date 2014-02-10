package gui.dialog.edit;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;

public class EditButtonPanel<T extends Model> extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;
	
	protected JButton saveButton = null;

	public EditButtonPanel(final EditDialog<T> editDialog) {
		super();
		setLayout(new FlowLayout());

		saveButton = new SaveModelButton<T>(editDialog) {
			private static final long serialVersionUID = -241171922352921487L;
		};

		this.add(saveButton);
	}
}
