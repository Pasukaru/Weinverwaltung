package gui.dialog.edit.sort;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;

import repository.Repository;
import model.Sort;

public class SortEditDialog extends EditDialog<Sort> {

	private static final long serialVersionUID = 9013808505821269241L;

	private EditButtonPanel<Sort> buttonsPanel;

	public SortEditDialog(Sort model) {
		super(model);

		setTitle(isCreate() ? "Weinsorte hinzufügen" : "Weinsorte bearbeiten");

		add(dataPanel = new SortEditDataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new EditButtonPanel<Sort>(this), BorderLayout.SOUTH);
	}

	@Override
	protected void save() {
		model.setName(dataPanel.getName());

		Repository.getInstance(Sort.class).update(model);
		dispose();
	}

	public SortEditDataPanel getDataPanel() {
		return (SortEditDataPanel) dataPanel;
	}

	public EditButtonPanel<Sort> getButtonsPanel() {
		return buttonsPanel;
	}
}
