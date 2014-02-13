import javax.swing.UIManager;

import gui.mainwindow.MainWindow;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		new MainWindow().init();
	}
}
