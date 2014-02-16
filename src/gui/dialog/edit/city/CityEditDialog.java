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

	private EditButtonPanel<City> buttonsPanel;
	private Country country;

	private List<Region> regions;
	private List<Country> countries;

	public CityEditDialog(City model) {
		super(model);

		setTitle(isCreate() ? "Stadt hinzufügen" : "Stadt bearbeiten");

		regions = Repository.getInstance(Region.class).getAll();
		countries = Repository.getInstance(Country.class).getAll();

		add(dataPanel = new CityEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<City>(this), BorderLayout.SOUTH);
	}

	@Override
	protected void save() {
		CityEditDataPanel dataPanel = getDataPanel();
		
		model.setName(dataPanel.getName());
		model.setRegion(dataPanel.getRegion());

		Repository.getInstance(City.class).update(model);
		dispose();
	}


	public List<Region> getRegions() {
		return regions;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public CityEditDataPanel getDataPanel() {
		return (CityEditDataPanel) dataPanel;
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
