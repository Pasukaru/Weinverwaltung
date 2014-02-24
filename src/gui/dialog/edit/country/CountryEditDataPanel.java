package gui.dialog.edit.country;

import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;

import model.Country;

public class CountryEditDataPanel extends EditDataPanel<Country> {

	private static final long serialVersionUID = 646403762781205389L;

	public CountryEditDataPanel(CountryEditDialog editWindow) {
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
