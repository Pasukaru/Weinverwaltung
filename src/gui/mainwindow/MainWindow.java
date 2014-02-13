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

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import util.Repository;

public class MainWindow extends BaseWindow {

	private static final long serialVersionUID = 1L;

	private JTabbedPane tabPane;

	private EventManager eventManager;
	
	private CityTab city = null;
	private SortTab sort = null;
	private TypeTab type = null;
	private VineTab vine = null;
	private WineryTab winery = null;
	private WineTab wine = null;
	
	public MainWindow() {
		super("Weinverwaltung");
	}
	
	public void init(){
		setUndecorated(true);
		setContentPane(new LoadingPanel(this));
		setAlwaysOnTop(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		tabPane = new JTabbedPane();
		addSelectorTab();
		
		eventManager = new EventManager();

		try {
			Repository.init("WEINVERWALTUNG", eventManager);
			
			setVisible(false);
			dispose();
		
			setAlwaysOnTop(false);
			setUndecorated(false);

			addWineTab();

			setContentPane(tabPane);
			pack();
			setSize(new Dimension(800, getHeight()));
			setLocationRelativeTo(null);
			setVisible(true);
		} catch(Exception e){
			setVisible(false);
			JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden", null, JOptionPane.ERROR_MESSAGE);
			dispose();
			System.exit(1);
		}
	}

	private void addTab(String title, Component c) {
		int i = tabPane.getTabCount() - 1;
		tabPane.insertTab(title, null, c, null, i);
		tabPane.setSelectedComponent(c);
	}

	public void addWineTab() {
		if(wine == null){
			addTab("Weine", wine = new WineTab());
		} else {
			tabPane.setSelectedComponent(wine);
		}
	}

	public void addCityTab(){
		if(city == null){
			addTab("Städte", city = new CityTab());
		} else {
			tabPane.setSelectedComponent(city);
		}
		
	}

	public void addTypeTab(){
		if(type == null){
			addTab("Weinarten", type = new TypeTab());
		} else {
			tabPane.setSelectedComponent(type);
		}
	}

	public void addSortTab(){
		if(sort == null){
			addTab("Weinsorten", sort = new SortTab());
		} else {
			tabPane.setSelectedComponent(sort);
		}
	}

	public void addVineTab(){
		if(vine == null){
			addTab("Rebsorten", vine = new VineTab());
		} else {
			tabPane.setSelectedComponent(vine);
		}
	}

	public void addWineryTab(){
		if(winery == null){
			addTab("Winzer", winery = new WineryTab());
		} else {
			tabPane.setSelectedComponent(winery);
		}
	}

	public void addSelectorTab() {
		tabPane.addTab("+", new TabSelectorTab(this));
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}