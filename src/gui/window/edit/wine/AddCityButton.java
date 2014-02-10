package gui.window.edit.wine;

import gui.window.edit.city.EditCityWindow;
import gui.window.main.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddCityButton extends JButton implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final EditWindow editWindow;

	public AddCityButton(EditWindow editWindow) {
		super("Add City");
		this.editWindow = editWindow;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		EditCityWindow ecw = new EditCityWindow(new MainWindow());
		ecw.setVisible(true);
	}
}
