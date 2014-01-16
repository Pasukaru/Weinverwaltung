import gui.window.main.MainWindow;
import util.JpaUtil;

public class Main {

	public static void main(String[] args) {
		new MainWindow().setVisible(true);
		JpaUtil.init("weinverwaltung");
	}
}
