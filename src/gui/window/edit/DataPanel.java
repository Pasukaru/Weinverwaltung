package gui.window.edit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Wine;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

	private final Wine wine;
	private final JTextField name;

	private int gridx = 0;
	private int gridy = 0;

	public DataPanel(final EditWindow editWindow) {
		this.setLayout(new GridBagLayout());

		wine = editWindow.getWine();
		name = new JTextField();
		addName();
	}

	private GridBagConstraints next(int gridy) {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = gridx++;
		grid.gridy = gridy;
		grid.weightx = 1.0;
		grid.weighty = 1.0;
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.anchor = GridBagConstraints.CENTER;
		return grid;
	}

	private void addName() {
		if (wine != null) {
			name.setText(wine.getName());
		} else {
			name.setText("");
		}
		this.add(new JLabel("Name"), next(++gridy));
		this.add(name, next(gridy));
	}

	public String getName() {
		return name.getText();
	}

}
