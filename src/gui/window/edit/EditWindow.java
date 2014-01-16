package gui.window.edit;

import gui.window.BaseWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import model.Wine;

public class EditWindow extends BaseWindow {

	private static final long serialVersionUID = -9141574978152096541L;

	private final Wine wine;
	private final DataPanel dataPanel;
	private final ButtonsPanel buttonsPanel;

	public EditWindow(Wine wine) {
		super();
		this.wine = wine;

		setTitle(isCreate() ? "Create" : "Update");

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		add(dataPanel = new DataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(this), BorderLayout.SOUTH);

		pack();
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
	}

	public boolean isCreate() {
		return wine.getId() == null;
	}

	public Wine getWine() {
		return wine;
	}

	public void setVisible(boolean b) {
		super.setVisible(b);
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}

	public ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}
}
