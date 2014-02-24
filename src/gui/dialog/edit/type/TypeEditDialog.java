package gui.dialog.edit.type;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;

import repository.Repository;
import model.Type;

public class TypeEditDialog extends EditDialog<Type> {

	private static final long serialVersionUID = -9141574978152096541L;

	private EditButtonPanel<Type> buttonsPanel;

	public TypeEditDialog(Type model) {
		super(model);

		setTitle(isCreate() ? "Weinart hinzufügen" : "Weinart bearbeiten");

		add(dataPanel = new TypeEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Type>(this), BorderLayout.SOUTH);
	}
	
	@Override
	public void save(){
		model.setName(dataPanel.getName());
		Repository.getInstance(Type.class).update(model);
		dispose();
	}

	public TypeEditDataPanel getDataPanel() {
		return (TypeEditDataPanel) dataPanel;
	}

	public EditButtonPanel<Type> getButtonsPanel() {
		return buttonsPanel;
	}
}
