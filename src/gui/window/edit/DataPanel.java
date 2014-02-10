package gui.window.edit;

import gui.CityRenderer;
import gui.TypeRenderer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.City;
import model.Type;
import model.Wine;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

	private final EditWindow editWindow;
	private Wine wine;

	private JComboBox<City> city;
	private JComboBox<Type> type;
	private JTextField name;

	private int gridy = 0;

	public DataPanel(final EditWindow editWindow) {
		this.setLayout(new GridBagLayout());
		this.editWindow = editWindow;

		wine = editWindow.getWine();

		addName();
		addCity();
		addType();
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

	private void addName() {
		name = new JTextField();
		if (wine != null) {
			name.setText(wine.getName());
		} else {
			name.setText("");
		}
		add(new JLabel("Name"), next(0, ++gridy));
		add(name, next(1, gridy));
	}

	@SuppressWarnings("unchecked")
	private void addCity() {
		City[] cities = editWindow.getCities().toArray(new City[0]);

		city = new JComboBox<City>(cities);
		city.setRenderer(new CityRenderer());
		city.setSelectedItem(wine.getCity());

		add(new JLabel("City"), next(0, ++gridy));
		add(city, next(1, gridy));
	}

	@SuppressWarnings("unchecked")
	private void addType() {
		Type[] types = editWindow.getTypes().toArray(new Type[0]);

		type = new JComboBox<Type>(types);
		type.setRenderer(new TypeRenderer());
		type.setSelectedItem(wine.getType());

		add(new JLabel("Type"), next(0, ++gridy));
		add(type, next(1, gridy));
	}

	public String getName() {
		return name.getText();
	}

	public City getCity() {
		return (City) city.getSelectedItem();
	}

	public Type getType() {
		return (Type) type.getSelectedItem();
	}

}
