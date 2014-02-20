package gui.mainwindow.tabs;

import gui.mainwindow.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import repository.Repository;
import model.Model;

public class TabButtonPanel<T extends Model> extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;

	public TabButtonPanel(final ModelTab<T> tab, MainWindow mainWindow) {
		super();

		setBorder(new TitledBorder(null, "Aktionen", TitledBorder.CENTER, TitledBorder.TOP));

		JButton add = new JButton("Hinzufügen");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tab.getCreateDialog().show();
			}
		});
		
		final JButton edit = new JButton("Bearbeiten");
		edit.setEnabled(false);
		edit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tab.getEditDialog().show();
			}
		});
		
		final JButton delete = new JButton("Löschen");
		delete.setEnabled(false);
		delete.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				T model = tab.getSelectedModel();
				if(model != null){
					if(!((Repository<T>) Repository.getInstance(model.getClass())).delete(model)){
						JOptionPane.showMessageDialog(tab, "Dieser Eintrag kann nicht gelöscht werden, da andere Daten von ihm abhängen.", "Fehler", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		tab.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				boolean selected = tab.getSelectedModel() != null;
				edit.setEnabled(selected);
				delete.setEnabled(selected);
			}
		});
		
		this.add(add);
		this.add(edit);
		this.add(delete);
	}
}
