package gui.window.edit.wine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddCityButton extends JButton implements ActionListener {

	private final EditWindow editWindow;

	public AddCityButton(EditWindow editWindow) {
		super("Add City");
		this.editWindow = editWindow;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
