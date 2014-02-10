package gui.window.edit;

import gui.window.BaseWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import model.City;
import model.Country;
import model.Region;
import model.Sort;
import model.Vine;
import model.Wine;
import model.Winery;
import util.Repository;

public class EditWindow extends BaseWindow {

	private static final long serialVersionUID = -9141574978152096541L;

	private final Wine wine;

	private final List<City> cities;
	private final List<model.Type> types;
	private final List<Sort> sorts;
	private final List<Region> regions;
	private final List<Country> countries;
	private final List<Vine> vines;
	private final List<Winery> wineries;

	private final DataPanel dataPanel;
	private final ButtonsPanel buttonsPanel;

	public EditWindow(Wine wine) {
		super();
		this.wine = wine;

		cities = Repository.getInstance().getAllCities();
		types = Repository.getInstance().getAllTypes();
		sorts = Repository.getInstance().getAllSorts();
		regions = Repository.getInstance().getAllRegions();
		countries = Repository.getInstance().getAllCountries();
		vines = Repository.getInstance().getAllVines();
		wineries = Repository.getInstance().getAllWineries();

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

	public List<model.Type> getTypes() {
		return types;
	}

	public List<Sort> getSorts() {
		return sorts;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public List<Vine> getVines() {
		return vines;
	}

	public List<Winery> getWineries() {
		return wineries;
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
