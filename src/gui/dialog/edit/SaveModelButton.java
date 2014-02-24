package gui.dialog.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import util.StringUtils;
import model.Model;

public abstract class SaveModelButton<T extends Model> extends JButton implements ActionListener {

	private static final long serialVersionUID = -8272946312666081569L;

	private final EditDialog<T> editDialog;

	public SaveModelButton(EditDialog<T> editDialog) {
		super("Save");
		this.editDialog = editDialog;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> errors = editDialog.validateModel();
		if(!errors.isEmpty()){
			JOptionPane.showMessageDialog(null, StringUtils.join(errors, System.lineSeparator()), "Ungültige Eingabe(n)", JOptionPane.WARNING_MESSAGE);
			return;
		}
		editDialog.save();
	}
}
