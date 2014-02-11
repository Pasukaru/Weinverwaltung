package gui.dialog.type;

import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Type;

public class TypeEditDataPanel extends EditDataPanel<Type> {

	private static final long serialVersionUID = 646403762781205389L;

	private JTextField name;

	public TypeEditDataPanel(TypeEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}
	
	private void addName() {
		name = new JTextField();
		if (model != null) {
			name.setText(model.getName());
		} else {
			name.setText("");
		}
		add(new JLabel("Name"), next(0, ++gridy));
		add(name, next(1, gridy));
	}
	
	public String getName() {
		return name.getText();
	}

}
