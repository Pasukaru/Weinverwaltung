package gui.dialog.edit.sort;


import gui.dialog.edit.EditDataPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Sort;

public class SortEditDataPanel extends EditDataPanel<Sort> {


	private static final long serialVersionUID = 646403762781205389L;

	private JTextField sort;
	private int gridy = 0;


	public SortEditDataPanel(SortEditDialog editWindow) {
		super(editWindow.getModel());
		addName();
	}

	public String getName() {
		return sort.getText();
	}
	private void addName() {

		sort = new JTextField();
		sort.setText("");

		add(new JLabel("Sort"), next(0, ++gridy));
		add(sort, next(1, gridy));
	}
}
