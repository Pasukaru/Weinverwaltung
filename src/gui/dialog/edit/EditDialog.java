package gui.dialog.edit;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import util.Repository;
import model.Model;

public abstract class EditDialog<T extends Model> extends JOptionPane implements WindowListener {
	
	private static final long serialVersionUID = -3904763827415560312L;

	protected EditDataPanel<T> dataPanel;
	protected final T model;
	private String title;
	private JDialog dialog = null;
	
	public EditDialog(T model){
		this.model = model;
		title = "";
		setLayout(new BorderLayout());
	}
	
	protected String validateName(){
		String name = dataPanel.getName().trim();
		String error = null;
		if(name.isEmpty()){
			error = "Bitte einen Namen eintragen";
		} else {
			Model check = Repository.getInstance(model.getClass()).getByName(name);
			if(check != null && !check.equals(model)){
				error = "Dieser Name ist bereits vergeben";
			}
		}
		return error;
	}
	
	protected List<String> validateModel(){
		List<String> errors = new ArrayList<String>();
		String nameError = validateName();
		if(nameError != null){
			errors.add(nameError);
		}
		return errors;
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
	
	public void dispose(){
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
		dispose();
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
