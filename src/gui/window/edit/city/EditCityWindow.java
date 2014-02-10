package gui.window.edit.city;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import model.City;
import model.Wine;
import util.Repository;
import gui.window.BaseWindow;
import gui.window.edit.city.ButtonsPanel;
import gui.window.edit.city.DataPanel;
import gui.window.main.MainWindow;

public class EditCityWindow extends BaseWindow{

	private final DataPanel dataPanel;
	private final ButtonsPanel buttonsPanel;
	private MainWindow mainWindow;
	private City city;

	public EditCityWindow(MainWindow mainWindow) {

		super();
		this.mainWindow = mainWindow;

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		add(dataPanel = new DataPanel(this), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(this), BorderLayout.SOUTH);

		pack();
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
	}

}
