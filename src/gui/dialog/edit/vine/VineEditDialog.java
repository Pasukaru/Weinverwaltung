package gui.dialog.edit.vine;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;

import model.Vine;
import util.Repository;

public class VineEditDialog extends EditDialog<Vine> {

	private static final long serialVersionUID = 9013808505821269241L;

	private VineEditDataPanel dataPanel;
	private EditButtonPanel<Vine> buttonsPanel;

	public VineEditDialog(Vine model) {
		super(model);

		setTitle(isCreate() ? "Create Vine" : "Edit Vine");

		add(dataPanel = new VineEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Vine>(this), BorderLayout.SOUTH);
	}

	@Override
	protected void save() {
		model.setName(dataPanel.getName());

		Repository.getInstance(Vine.class).update(model);
		dispose();
	}

	public VineEditDataPanel getDataPanel() {
		return dataPanel;
	}

	public EditButtonPanel<Vine> getButtonsPanel() {
		return buttonsPanel;
	}
}
