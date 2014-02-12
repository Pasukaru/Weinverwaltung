package gui.dialog.edit.sort;

import gui.dialog.edit.EditButtonPanel;
import gui.dialog.edit.EditDialog;

import java.awt.BorderLayout;

import model.Sort;
import util.Repository;

public class SortEditDialog extends EditDialog<Sort> {

	private static final long serialVersionUID = 9013808505821269241L;

	private SortEditDataPanel dataPanel;
	private EditButtonPanel<Sort> buttonsPanel;

	public SortEditDialog(Sort model) {
		super(model);

		setTitle(isCreate() ? "Create Sort" : "Edit Sort");

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
		return dataPanel;
	}

	public EditButtonPanel<Sort> getButtonsPanel() {
		return buttonsPanel;
	}
}
