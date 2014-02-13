package gui.dialog.edit.winery;


import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Winery;

public class WineryEditDataPanel extends EditDataPanel<Winery> {


	private static final long serialVersionUID = 646403762781205389L;

	private JTextField winery;
	private int gridy = 0;


	public WineryEditDataPanel(WineryEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}

	public String getName() {
		return winery.getText();
	}
	private void addName() {

		winery = new JTextField();
		winery.setText("");

		add(new JLabel("Winzer"), next(0, ++gridy));
		add(winery, next(1, gridy));
	}
}
