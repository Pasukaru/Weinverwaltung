import javax.swing.UIManager;

import gui.mainwindow.MainWindow;
import util.JpaUtil;
import util.Repository;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		JpaUtil.init("WEINVERWALTUNG");
		new MainWindow().setVisible(true);
	}
}
