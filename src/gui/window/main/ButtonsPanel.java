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
<<<<<<< HEAD
		this.add(new DbButton());
=======
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
		this.add(new EditButton(mainWindow));
	}
}
