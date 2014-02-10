package gui.dialog.edit;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Model;

public abstract class EditDialog<T extends Model> extends JOptionPane implements WindowListener {
	
	private static final long serialVersionUID = -3904763827415560312L;

	protected final T model;
	private String title;
	private JDialog dialog = null;
	
	public EditDialog(T model){
		this.model = model;
		title = "";
		setLayout(new BorderLayout());
	}
	
	protected abstract void save();
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public T getModel(){
		return model;
	}

	public void show(){
		dialog = createDialog(title);
		dialog.addWindowListener(this);
		dialog.setVisible(true);
	}
	
	public void close(){
		if(dialog != null){
			dialog.dispose();
			dialog = null;
		}
	}

	public boolean isCreate() {
		return model.getId() == null;
	}

	@Override
	public void windowClosed(WindowEvent e) {
		close();
	}

	@Override
	public void windowActivated(WindowEvent e) {}

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
