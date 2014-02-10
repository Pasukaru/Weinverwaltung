package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import util.Repository;

public abstract class SaveModelButton<T extends Model> extends JButton
	implements ActionListener {

	private static final long serialVersionUID = -8272946312666081569L;

	private final T model;

	public SaveModelButton(T model) {
		super("Save");
		this.model = model;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		save(model);
	}

	public void save(T model) {
		Repository.getInstance().updateModel(model);
	}
}
