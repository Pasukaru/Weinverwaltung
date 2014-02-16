package gui.dialog.edit.type;

import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;

import model.Type;

public class TypeEditDataPanel extends EditDataPanel<Type> {

	private static final long serialVersionUID = 646403762781205389L;

	public TypeEditDataPanel(TypeEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}
	
	private void addName() {
		add(new JLabel("Name"), next(0, ++gridy));
		add(name, next(1, gridy));
	}
	
	public String getName() {
		return name.getText();
	}

}
