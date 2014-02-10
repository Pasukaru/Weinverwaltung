package gui.window;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class BaseWindow extends JFrame implements WindowListener {

	private static final long serialVersionUID = 4400172610474693161L;

	public BaseWindow() {
		super();
		this.addWindowListener(this);
	}

	public BaseWindow(String title) {
		super(title);
		this.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

}
