package gui.dialog.type;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;
import java.util.List;

import model.City;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;
import util.Repository;

public class TypeEditDialog extends EditDialog<Type> {

	private static final long serialVersionUID = -9141574978152096541L;

	private final TypeEditDataPanel dataPanel;
	private final EditButtonPanel<Type> buttonsPanel;

	public TypeEditDialog(final Type type) {
		super(type);

		setTitle(isCreate() ? "Create Wine" : "Edit Wine");

		add(dataPanel = new TypeEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Type>(this), BorderLayout.SOUTH);
	}
	
	@Override
	public void save(){
		model.setName(dataPanel.getName());
		Repository.getInstance().updateModel(model);
		close();
	}
	public TypeEditDataPanel getDataPanel() {
		return dataPanel;
	}

	public EditButtonPanel<Type> getButtonsPanel() {
		return buttonsPanel;
	}
}
