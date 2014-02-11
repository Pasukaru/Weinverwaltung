package gui.dialog.type;

import events.EventManager;
import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;

import model.Type;
import util.Repository;

public class TypeEditDialog extends EditDialog<Type> {

	private static final long serialVersionUID = -9141574978152096541L;

	private TypeEditDataPanel dataPanel;
	private EditButtonPanel<Type> buttonsPanel;

	public TypeEditDialog(final Type type, EventManager eventManager) {
		super(type, eventManager);
	}
	
	@Override
	protected void init() {
		this.removeAll();
		setTitle(isCreate() ? "Create Wine" : "Edit Wine");

		add(dataPanel = new TypeEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Type>(this), BorderLayout.SOUTH);
	}
	
	@Override
	public void save(){
		model.setName(dataPanel.getName());
		Repository.getInstance().updateModel(model);
		dispose();
	}
	public TypeEditDataPanel getDataPanel() {
		return dataPanel;
	}

	public EditButtonPanel<Type> getButtonsPanel() {
		return buttonsPanel;
	}
}
