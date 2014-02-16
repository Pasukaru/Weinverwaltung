package gui.dialog.edit;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public abstract class EditDataPanel<T extends Model> extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

	protected final T model;
	protected JTextField name;
	
	protected int gridy = 0;

	public EditDataPanel(T model) {
		this.setLayout(new GridBagLayout());
		this.model = model;
		this.name = new JTextField(model.getName());
	}
	
	public String getName(){
		return name.getText();
	}

	protected GridBagConstraints next(int gridx, int gridy) {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = gridx;
		grid.gridy = gridy;
		grid.weightx = 1.0;
		grid.weighty = 1.0;
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.anchor = GridBagConstraints.CENTER;
		return grid;
	}

}
