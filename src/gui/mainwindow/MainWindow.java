package gui.mainwindow;

import events.EventManager;
import gui.ExceptionHandler;
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
	
	private LoadingPanel loading = null;
	
	public void showLoadingPanel(String text){
		loading.setText(text);
		if(getContentPane() != loading){
			dispose();
			setContentPane(loading);
			setUndecorated(true);
			setAlwaysOnTop(true);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			repaint();
			requestFocus();
		}
	}
	
	public void hideLoadingPanel(){
		dispose();
		setAlwaysOnTop(false);
		setUndecorated(false);
		setContentPane(tabPane);
		pack();
		setSize(new Dimension(800, getHeight()));
		setLocationRelativeTo(null);
		setVisible(true);
		repaint();
		requestFocus();
	}
	
	public void init(){
		loading = new LoadingPanel("");
		
		showLoadingPanel("Initialisiere...");
		
		Repository.setExceptionHandler(new ExceptionHandler(this));
		
		eventManager = new EventManager();
		
		showLoadingPanel("Lade Datenbankschema...");

		Repository.init(eventManager);

		showLoadingPanel("Erstelle Oberfläche...");
		
		tabs = new HashMap<Class<? extends Model>, ModelTab<?>>();
		tabs.put(City.class, new CityTab(this));
		tabs.put(Sort.class, new SortTab(this));
		tabs.put(model.Type.class, new TypeTab(this));
		tabs.put(Vine.class, new VineTab(this));
		tabs.put(Winery.class, new WineryTab(this));
		tabs.put(Wine.class, new WineTab(this));

		tabPane = new JTabbedPane();
		tabPane.addTab("+", new TabSelectorTab(this));
		
		showLoadingPanel("Lade Daten...");

		openTab(Wine.class);
		
		hideLoadingPanel();
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
		Repository.close();
		System.exit(0);
	}
}