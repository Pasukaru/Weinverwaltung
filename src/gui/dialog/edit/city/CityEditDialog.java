package gui.dialog.edit.city;

import events.EventManager;
import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;

import model.City;
import model.Country;
import model.Region;
import util.Repository;

public class CityEditDialog extends EditDialog<City> {

	private static final long serialVersionUID = 9013808505821269241L;

	private CityEditDataPanel dataPanel;
	private EditButtonPanel<City> buttonsPanel;
	private Country country;
	private List<Region> regions;
	private List<Country> countries;
	
	public CityEditDialog(City model, EventManager eventManager) {
		super(model, eventManager);
	}


	@Override
	protected void init() {
		this.removeAll();
		setTitle(isCreate() ? "Create Wine" : "Edit Wine");

		regions = Repository.getInstance().getAllRegions();
		countries = Repository.getInstance().getAllCountries();

		add(dataPanel = new CityEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<City>(this), BorderLayout.SOUTH);
	}


	@Override
	protected void save() {
		//TODO implementation
		JOptionPane.showMessageDialog(null, "TODO");
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
