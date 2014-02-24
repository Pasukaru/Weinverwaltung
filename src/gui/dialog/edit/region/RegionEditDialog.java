package gui.dialog.edit.region;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;
import java.util.List;

import repository.Repository;
import model.Country;
import model.Region;

public class RegionEditDialog extends EditDialog<Region> {

	private static final long serialVersionUID = -9141574978152096541L;

	private EditButtonPanel<Region> buttonsPanel;
	
	private List<Country> countries;

	public RegionEditDialog(Region model) {
		super(model);

		setTitle(isCreate() ? "Weinart hinzufügen" : "Weinart bearbeiten");
		
		countries = Repository.getInstance(Country.class).getAll();

		add(dataPanel = new RegionEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Region>(this), BorderLayout.SOUTH);
	}

	@Override
	protected List<String> validateModel() {
		List<String> errors = super.validateModel();

		RegionEditDataPanel dataPanel = getDataPanel();
		if(dataPanel.getCountry() == null){
			errors.add("Bitte ein Land auswählen");
		}
		
		return errors;
	}
	@Override
	public void save(){
		RegionEditDataPanel dataPanel = getDataPanel();
		model.setName(dataPanel.getName());
		model.setCountry(dataPanel.getCountry());
		Repository.getInstance(Region.class).update(model);
		dispose();
	}

	public RegionEditDataPanel getDataPanel() {
		return (RegionEditDataPanel) dataPanel;
	}
	
	public List<Country> getCountries(){
		return countries;
	}

	public EditButtonPanel<Region> getButtonsPanel() {
		return buttonsPanel;
	}
}
