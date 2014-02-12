package gui.dialog.edit.winery;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;

import model.Winery;
import util.Repository;

public class WineryEditDialog extends EditDialog<Winery> {

	private static final long serialVersionUID = 9013808505821269241L;

	private WineryEditDataPanel dataPanel;
	private EditButtonPanel<Winery> buttonsPanel;

	public WineryEditDialog(Winery model) {
		super(model);

		setTitle(isCreate() ? "Create Winery" : "Edit Winery");

		add(dataPanel = new WineryEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Winery>(this), BorderLayout.SOUTH);
	}

	@Override
	protected void save() {
		model.setName(dataPanel.getName());

		Repository.getInstance(Winery.class).update(model);
		dispose();
	}

	public WineryEditDataPanel getDataPanel() {
		return dataPanel;
	}

	public EditButtonPanel<Winery> getButtonsPanel() {
		return buttonsPanel;
	}
}
