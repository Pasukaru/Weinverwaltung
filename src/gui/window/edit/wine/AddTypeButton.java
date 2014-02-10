package gui.window.edit.wine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddTypeButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 2328630827756691503L;

	private final EditWindow editWindow;

	public AddTypeButton(EditWindow editWindow) {
		super("Add City");
		this.editWindow = editWindow;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
