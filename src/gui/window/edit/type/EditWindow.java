package gui.window.edit.type;

import gui.window.BaseWindow;
import gui.window.main.MainWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class EditWindow extends BaseWindow {

	private static final long serialVersionUID = -9141574978152096541L;

	private final model.Type type;

	private final DataPanel dataPanel;
	private final ButtonsPanel buttonsPanel;

	private final MainWindow mainWindow;

	public EditWindow(model.Type type, MainWindow mainWindow) {
		super();
		this.type = type;
		this.mainWindow = mainWindow;

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
		return type.getId() == null;
	}

	public model.Type getWineType() {
		return type;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}

	public ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}
}