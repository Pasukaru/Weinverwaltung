package gui.window.edit.city;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import model.Country;
import model.Region;
import util.Repository;
import gui.window.BaseWindow;
import gui.window.edit.city.ButtonsPanel;
import gui.window.edit.city.DataPanel;
import gui.window.main.MainWindow;

public class EditCityWindow extends BaseWindow{

	/**
	 *
	 */
	private static final long serialVersionUID = 9013808505821269241L;

	private final DataPanel dataPanel;
	private final ButtonsPanel buttonsPanel;
	private MainWindow mainWindow;
	private Country country;
	private final List<Region> regions;
	private final List<Country> countries;


	public EditCityWindow(MainWindow mainWindow) {

		super();
		this.setMainWindow(mainWindow);
		regions = Repository.getInstance().getAllRegions();
		countries = Repository.getInstance().getAllCountries();

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		add(dataPanel = new DataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(this), BorderLayout.SOUTH);

		pack();
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
	}

	public List<Region> getRegions() {
		return regions;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}

	public ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
