package gui.dialog.edit.city;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;
import java.util.List;

import model.City;
import model.Country;
import model.Region;
import util.Repository;

public class CityEditDialog extends EditDialog<City> {

	private static final long serialVersionUID = 9013808505821269241L;

	private final CityEditDataPanel dataPanel;
	private final EditButtonPanel<City> buttonsPanel;
	private Country country;
	private final List<Region> regions;
	private final List<Country> countries;

	public CityEditDialog(City model) {
		super(model);

		regions = Repository.getInstance().getAllRegions();
		countries = Repository.getInstance().getAllCountries();

		add(dataPanel = new CityEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<City>(this), BorderLayout.SOUTH);
	}


	@Override
	protected void save() {

		model.setName(dataPanel.getName());
		model.setRegion(dataPanel.getRegion());

		Repository.getInstance().updateModel(model);
		close();
	}


	public List<Region> getRegions() {
		return regions;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public CityEditDataPanel getDataPanel() {
		return dataPanel;
	}

	public EditButtonPanel<City> getButtonsPanel() {
		return buttonsPanel;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
