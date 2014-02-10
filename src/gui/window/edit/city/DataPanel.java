package gui.window.edit.city;


import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

	private final EditCityWindow editCityWindow;
	private JTextField name;


	public DataPanel(final EditCityWindow editCityWindow) {
		this.setLayout(new GridBagLayout());
		this.editCityWindow = editCityWindow;
	}

	public String getName() {
		return name.getText();
	}

	public EditCityWindow getEditCityWindow() {
		return editCityWindow;
	}

}
