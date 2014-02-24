package gui.mainwindow;

import events.EventManager;
import gui.ExceptionHandler;
import gui.mainwindow.tabs.CityTab;
import gui.mainwindow.tabs.CountryTab;
import gui.mainwindow.tabs.ModelTab;
import gui.mainwindow.tabs.RegionTab;
import gui.mainwindow.tabs.SortTab;
import gui.mainwindow.tabs.TypeTab;
import gui.mainwindow.tabs.VineTab;
import gui.mainwindow.tabs.WineTab;
import gui.mainwindow.tabs.WineryTab;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JTabbedPane;

import repository.Repository;
import model.City;
import model.Country;
import model.Model;
import model.Region;
import model.Sort;
import model.Vine;
import model.Wine;
import model.Winery;

public class MainWindow extends BaseWindow {

	private static final long serialVersionUID = 1L;

	private JTabbedPane tabPane;

	private EventManager eventManager;
	
	private HashMap<Class<? extends Model>, ModelTab<?>> tabs;
	
	public MainWindow() {
		super("Weinverwaltung");
	}
	
	private LoadingPanel loading = null;
	
	public void showLoadingPanel(){
		if(getContentPane() != loading){
			dispose();
			setContentPane(loading);
			setUndecorated(true);
			setAlwaysOnTop(true);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			loading.start();
			requestFocus();
		}
	}
	
	public void hideLoadingPanel(){
		dispose();
		setAlwaysOnTop(false);
		setUndecorated(false);
		loading.stop();
		setContentPane(tabPane);
		pack();
		setSize(new Dimension(800, getHeight()));
		setLocationRelativeTo(null);
		setVisible(true);
		requestFocus();
	}
	
	public void init(){
		loading = new LoadingPanel();
		
		showLoadingPanel();
		
		Repository.setExceptionHandler(new ExceptionHandler(this));
		
		eventManager = new EventManager();
		
		Repository.init(eventManager);

		tabs = new HashMap<Class<? extends Model>, ModelTab<?>>();
		tabs.put(City.class, new CityTab(this));
		tabs.put(Country.class, new CountryTab(this));
		tabs.put(Region.class, new RegionTab(this));
		tabs.put(Sort.class, new SortTab(this));
		tabs.put(model.Type.class, new TypeTab(this));
		tabs.put(Vine.class, new VineTab(this));
		tabs.put(Winery.class, new WineryTab(this));
		tabs.put(Wine.class, new WineTab(this));

		tabPane = new JTabbedPane();
		tabPane.addTab("+", new TabSelectorTab(this));
		
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