package gui.mainwindow;

import events.EventManager;
import gui.mainwindow.tabs.CityTab;
import gui.mainwindow.tabs.SortTab;
import gui.mainwindow.tabs.TypeTab;
import gui.mainwindow.tabs.VineTab;
import gui.mainwindow.tabs.WineTab;
import gui.mainwindow.tabs.WineryTab;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import util.Repository;

public class MainWindow extends BaseWindow {

	private static final long serialVersionUID = 1L;

	private final JTabbedPane tabPane;

	private final EventManager eventManager = new EventManager();

	public MainWindow() {
		super("Weinverwaltung");

		Repository.init(eventManager);

		tabPane = new JTabbedPane();

		addSelectorTab();
		addWineTab();
		addTypeTab();
		addSortTab();
		addVineTab();
		addWineryTab();
		addCityTab();
		tabPane.setSelectedIndex(0);

		setContentPane(tabPane);
		pack();
		setSize(new Dimension(800, getHeight()));
		setLocationRelativeTo(null);
	}

	private void addTab(String title, Component c) {
		int i = tabPane.getTabCount() - 1;
		tabPane.insertTab(title, null, c, null, i);
	}

	public void addWineTab() {
		addTab("Wine", new WineTab(eventManager));
	}

	public void addCityTab(){
		addTab("City", new CityTab(eventManager));
	}

	public void addTypeTab(){
		addTab("Type", new TypeTab(eventManager));
	}

	public void addSortTab(){
		addTab("Sort", new SortTab(eventManager));
	}

	public void addVineTab(){
		addTab("Vine", new VineTab(eventManager));
	}

	public void addWineryTab(){
		addTab("Winery", new WineryTab(eventManager));
	}

	public void addSelectorTab() {
		tabPane.addTab("+", new JPanel());
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}