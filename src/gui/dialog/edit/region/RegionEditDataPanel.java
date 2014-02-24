package gui.dialog.edit.region;

import gui.dialog.edit.EditDataPanel;
import gui.elements.ModelRenderer;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.Country;
import model.Region;

public class RegionEditDataPanel extends EditDataPanel<Region> {

	private static final long serialVersionUID = 646403762781205389L;

	private JComboBox<Country> country;
	
	private RegionEditDialog editDialog;
	
	public RegionEditDataPanel(RegionEditDialog editWindow) {
		super(editWindow.getModel());
		this.editDialog = editWindow;
		addName();
		addCountry();
	}
	
	private void addName() {
		add(new JLabel("Name"), next(0, ++gridy));
		add(name, next(1, gridy));
	}
	
	@SuppressWarnings("unchecked")
	private void addCountry(){
		Country[] countries = editDialog.getCountries().toArray(new Country[0]);

		country = new JComboBox<Country>(countries);
		country.setRenderer(new ModelRenderer<Country>());
		country.setSelectedItem(model.getCountry());

		add(new JLabel("Land"), next(0, ++gridy));
		add(country, next(1, gridy));
	}
	
	public String getName() {
		return name.getText();
	}
	
	public Country getCountry(){
		return (Country) country.getSelectedItem();
	}

}
