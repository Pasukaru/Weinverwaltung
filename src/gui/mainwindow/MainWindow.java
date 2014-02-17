package gui.mainwindow;

import events.EventManager;
import gui.mainwindow.tabs.CityTab;
import gui.mainwindow.tabs.ModelTab;
import gui.mainwindow.tabs.SortTab;
import gui.mainwindow.tabs.TypeTab;
import gui.mainwindow.tabs.VineTab;
import gui.mainwindow.tabs.WineTab;
import gui.mainwindow.tabs.WineryTab;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import model.City;
import model.Model;
import model.Sort;
import model.Vine;
import model.Wine;
import model.Winery;
import util.Repository;

public class MainWindow extends BaseWindow {

	private static final long serialVersionUID = 1L;

	private JTabbedPane tabPane;

	private EventManager eventManager;
	
	private HashMap<Class<? extends Model>, ModelTab<?>> tabs;
	
	public MainWindow() {
		super("Weinverwaltung");
	}
	
	public void init(){
		setUndecorated(true);
		setAlwaysOnTop(true);
		LoadingPanel loading = new LoadingPanel("Initialisiere...");
		setContentPane(loading);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		eventManager = new EventManager();

		loading.setText("Verbinde mit Datenbank...");
		pack();
		setLocationRelativeTo(null);

		try {
			Repository.init("WEINVERWALTUNG", eventManager);

			//TODO: - Test connection here - 

			loading.setText("Erstelle Oberfläche...");
			pack();
			setLocationRelativeTo(null);
			
			tabs = new HashMap<Class<? extends Model>, ModelTab<?>>();
			tabs.put(City.class, new CityTab());
			tabs.put(Sort.class, new SortTab());
			tabs.put(model.Type.class, new TypeTab());
			tabs.put(Vine.class, new VineTab());
			tabs.put(Winery.class, new WineryTab());
			tabs.put(Wine.class, new WineTab());

			tabPane = new JTabbedPane();
			tabPane.addTab("+", new TabSelectorTab(this));
			openTab(Wine.class);
			
			dispose();
			
			setAlwaysOnTop(false);
			setUndecorated(false);
			setContentPane(tabPane);
			pack();
			setSize(new Dimension(800, getHeight()));
			setLocationRelativeTo(null);
			setVisible(true);
			requestFocus();
			repaint();
		} catch(Exception e){
			setVisible(false);
			JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden", null, JOptionPane.ERROR_MESSAGE);
			dispose();
			System.exit(1);
		}
	}

	public <T extends Model> void openTab(Class<T> model) {
		@SuppressWarnings("unchecked")
		ModelTab<T> tab = (ModelTab<T>) tabs.get(model);
		if(tab.getParent() == tabPane){
			tabPane.setSelectedComponent(tab);
		} else {
			int i = tabPane.getTabCount() - 1;
			tabPane.insertTab(tab.getTitle(), null, tab, null, i);
			tabPane.setSelectedIndex(i);
			tab.open();
		}
	}
	
	public void removeTab(Class<? extends Model> model){
		ModelTab<?> tab = tabs.get(model);
		tabPane.remove(tabs.get(model));
		tab.close();
	}
	
	public String getTabTitle(Class<? extends Model> model){
		return tabs.get(model).getTitle();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}