package gui.dialog.edit.country;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;

import repository.Repository;
import model.Country;

public class CountryEditDialog extends EditDialog<Country> {

	private static final long serialVersionUID = -9141574978152096541L;

	private EditButtonPanel<Country> buttonsPanel;

	public CountryEditDialog(Country model) {
		super(model);

		setTitle(isCreate() ? "Weinart hinzufügen" : "Weinart bearbeiten");

		add(dataPanel = new CountryEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Country>(this), BorderLayout.SOUTH);
	}
	
	@Override
	public void save(){
		model.setName(dataPanel.getName());
		Repository.getInstance(Country.class).update(model);
		dispose();
	}

	public CountryEditDataPanel getDataPanel() {
		return (CountryEditDataPanel) dataPanel;
	}

	public EditButtonPanel<Country> getButtonsPanel() {
		return buttonsPanel;
	}
}
