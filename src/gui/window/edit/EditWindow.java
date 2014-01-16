package gui.window.edit;

import gui.window.BaseWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
<<<<<<< HEAD

=======
import java.util.ArrayList;
import java.util.List;

import model.City;
>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
import model.Wine;

public class EditWindow extends BaseWindow {

	private static final long serialVersionUID = -9141574978152096541L;

	private final Wine wine;
<<<<<<< HEAD
=======

	private final List<City> cities;

>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
	private final DataPanel dataPanel;
	private final ButtonsPanel buttonsPanel;

	public EditWindow(Wine wine) {
		super();
		this.wine = wine;

<<<<<<< HEAD
=======
		cities = new ArrayList<City>();
		cities.add(new City("City", "1234", null));
		cities.add(new City("City2", "1234", null));

>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
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

<<<<<<< HEAD
=======
	public List<City> getCities() {
		return cities;
	}

>>>>>>> b84e755e8de1e96b9412d8f727ce157d35520eac
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
