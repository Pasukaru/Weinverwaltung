package gui.window.edit;

<<<<<<< HEAD
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

=======
import gui.CityRenderer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

<<<<<<< HEAD
=======
import model.City;
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
import model.Wine;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

<<<<<<< HEAD
	private final Wine wine;
	private final JTextField name;
=======
	private final EditWindow editWindow;
	private final Wine wine;

	private JComboBox<City> city;
	private JTextField name;
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac

	private int gridx = 0;
	private int gridy = 0;

	public DataPanel(final EditWindow editWindow) {
		this.setLayout(new GridBagLayout());

<<<<<<< HEAD
		wine = editWindow.getWine();
		name = new JTextField();
		addName();
=======
		this.editWindow = editWindow;
		wine = editWindow.getWine();

		addName();
		addCity();
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
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
<<<<<<< HEAD
=======
		name = new JTextField();
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
		if (wine != null) {
			name.setText(wine.getName());
		} else {
			name.setText("");
		}
		this.add(new JLabel("Name"), next(++gridy));
		this.add(name, next(gridy));
	}

<<<<<<< HEAD
=======
	private void addCity() {
		City[] cities = editWindow.getCities().toArray(new City[0]);

		city = new JComboBox<City>(cities);
		city.setRenderer(new CityRenderer());
		city.setSelectedItem(wine.getCity());

		this.add(new JLabel("City"), next(++gridy));
		this.add(city, next(gridy));
	}

>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
	public String getName() {
		return name.getText();
	}

}
