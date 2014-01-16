package gui.window.main;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;

	private final MainWindow mainWindow;

	public ButtonsPanel(MainWindow p) {
		super();
		this.mainWindow = p;

		setLayout(new FlowLayout());
		this.add(new DbButton());
		this.add(new EditButton(mainWindow));
	}
}
