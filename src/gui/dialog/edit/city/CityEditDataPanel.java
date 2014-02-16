package gui.dialog.edit.city;

import gui.dialog.edit.EditDataPanel;
import gui.renderers.combobox.ModelRenderer;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.City;
import model.Country;
import model.Region;

public class CityEditDataPanel extends EditDataPanel<City> {

	private static final long serialVersionUID = 646403762781205389L;

	private CityEditDialog editDialog;
	private JComboBox<Country> country;
	private JComboBox<Region> region;

	public CityEditDataPanel(CityEditDialog editWindow) {
		super(editWindow.getModel());
		this.editDialog = editWindow;

		addName();
		addRegion();
		addCountry();

		region.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				Region region = (Region) e.getItem();
				country.setSelectedItem(region.getCountry());
			}
		});
	}

	private void addName() {
		add(new JLabel("Stadt"), next(0, ++gridy));
		add(name, next(1, gridy));
	}

	@SuppressWarnings("unchecked")
	private void addCountry() {
		Country[] countries = editDialog.getCountries().toArray(new Country[0]);

		country = new JComboBox<Country>(countries);
		country.setRenderer(new ModelRenderer<Country>());
		country.setEnabled(false);

		add(new JLabel("Land"), next(0, ++gridy));
		add(country, next(1, gridy));
	}

	@SuppressWarnings("unchecked")
	private void addRegion() {
		Region[] regions = editDialog.getRegions().toArray(new Region[0]);

		region = new JComboBox<Region>(regions);
		region.setRenderer(new ModelRenderer<Region>());

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
