package gui.window.edit;

import gui.window.BaseWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import model.City;
import model.Wine;

public class EditWindow extends BaseWindow {

	private static final long serialVersionUID = -9141574978152096541L;

	private final Wine wine;

	private final List<City> cities;

	private final DataPanel dataPanel;
	private final ButtonsPanel buttonsPanel;

	public EditWindow(Wine wine) {
		super();
		this.wine = wine;

		cities = new ArrayList<City>();
		cities.add(new City("City", "1234", null));
		cities.add(new City("City2", "1234", null));

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

	public List<City> getCities() {
		return cities;
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
