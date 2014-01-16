import gui.window.main.MainWindow;
import util.JpaUtil;

public class Main {

	public static void main(String[] args) {
		JpaUtil.init("WEINVERWALTUNG");
		new MainWindow().setVisible(true);
	}
}
