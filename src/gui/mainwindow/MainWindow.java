package gui.mainwindow;

import events.EventManager;
import gui.mainwindow.tabs.WineTab;
import gui.table.wine.WineTable;
import gui.table.wine.WineTableModel;

import java.awt.Component;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainWindow extends BaseWindow {

	private static final long serialVersionUID = 1L;

	private final JTabbedPane tabPane;

	private final EventManager eventManager = new EventManager();

	public MainWindow() {
		super("Weinverwaltung");

		tabPane = new JTabbedPane();

		addSelectorTab();
		addWineTab();
		tabPane.setSelectedIndex(0);

		this.setContentPane(tabPane);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	private void addTab(String title, Component c) {
		int i = tabPane.getTabCount() - 1;
		tabPane.insertTab(title, null, c, null, i);
	}

	public void addWineTab() {
		addTab("Wine", new WineTab(eventManager));
	}

	public void addSelectorTab() {
		tabPane.addTab("+", new JPanel());
	}

	public WineTableModel getTableModel() {
		return null;
	}

	public WineTable getTable() {
		return null;
	}

	public void loadData() {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}