package gui.window.edit.city;


import gui.CountryRenderer;
import gui.RegionRenderer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Country;
import model.Region;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 646403762781205389L;

	private final EditCityWindow editCityWindow;
	private JTextField city;
	private int gridy = 0;
	private JComboBox<Country> country;
	private JComboBox<Region> region;

	public DataPanel(final EditCityWindow editCityWindow) {
		this.setLayout(new GridBagLayout());
		this.editCityWindow = editCityWindow;

		addName();
		addRegion();
		addCountry();

		region.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

//				country.setSelectedItem(

			}
		});
	}

	public String getName() {
		return city.getText();
	}

	public EditCityWindow getEditCityWindow() {
		return editCityWindow;
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

		city = new JTextField();
		city.setText("");

		add(new JLabel("City"), next(0, ++gridy));
		add(city, next(1, gridy));
	}

	@SuppressWarnings("unchecked")
	private void addCountry() {
		Country[] countries = editCityWindow.getCountries().toArray(new Country[0]);

		country = new JComboBox<Country>(countries);
		country.setRenderer(new CountryRenderer());

		add(new JLabel("Country"), next(0, ++gridy));
		add(country, next(1, gridy));
	}

	@SuppressWarnings("unchecked")
	private void addRegion() {
		Region[] regions = editCityWindow.getRegions().toArray(new Region[0]);

		region = new JComboBox<Region>(regions);
		region.setRenderer(new RegionRenderer());

		add(new JLabel("Region"), next(0, ++gridy));
		add(region, next(1, gridy));
	}

	public Country getCountry() {
		return (Country) country.getSelectedItem();
	}

	public Region getRegion() {
		return (Region) region.getSelectedItem();
	}

}
