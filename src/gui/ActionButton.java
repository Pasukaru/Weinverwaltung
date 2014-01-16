package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class ActionButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -4720059196574346909L;

	public ActionButton() {
		addActionListener(this);
	}

	public ActionButton(String label) {
		super(label);
		addActionListener(this);
	}
}
