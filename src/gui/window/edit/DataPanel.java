package gui.window.edit;

import gui.CityRenderer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.City;
import model.Wine;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

	private final EditWindow editWindow;
	private final Wine wine;

	private JComboBox<City> city;
	private JTextField name;

	private int gridx = 0;
	private int gridy = 0;

	public DataPanel(final EditWindow editWindow) {
		this.setLayout(new GridBagLayout());

		this.editWindow = editWindow;
		wine = editWindow.getWine();

		addName();
		addCity();
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
		name = new JTextField();
		if (wine != null) {
			name.setText(wine.getName());
		} else {
			name.setText("");
		}
		this.add(new JLabel("Name"), next(++gridy));
		this.add(name, next(gridy));
	}

	private void addCity() {
		City[] cities = editWindow.getCities().toArray(new City[0]);

		city = new JComboBox<City>(cities);
		city.setRenderer(new CityRenderer());
		city.setSelectedItem(wine.getCity());

		this.add(new JLabel("City"), next(++gridy));
		this.add(city, next(gridy));
	}

	public String getName() {
		return name.getText();
	}

}
