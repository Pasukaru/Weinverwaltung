package gui.window.edit.type;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Type;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

	private final EditWindow editWindow;
	private Type type;

	private JTextField name;

	private int gridy = 0;

	public DataPanel(final EditWindow editWindow) {
		this.setLayout(new GridBagLayout());
		this.editWindow = editWindow;

		type = editWindow.getWineType();

		addName();
	}

	private GridBagConstraints next(int gridx, int gridy) {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = gridx;
		grid.gridy = gridy;
		grid.weightx = 1.0;
		grid.weighty = 1.0;
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.anchor = GridBagConstraints.CENTER;
		return grid;
	}

	public EditWindow getEditWindow() {
		return editWindow;
	}

	private void addName() {
		name = new JTextField();
		if (type != null) {
			name.setText(type.getName());
		} else {
			name.setText("");
		}
		add(new JLabel("Name"), next(0, ++gridy));
		add(name, next(1, gridy));
	}

	public String getName() {
		return name.getText();
	}
}
