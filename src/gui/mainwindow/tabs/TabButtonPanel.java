package gui.mainwindow.tabs;

import gui.mainwindow.DbButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import util.Repository;
import model.Model;

public class TabButtonPanel<T extends Model> extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;

	public TabButtonPanel(final ModelTab<T> tab) {
		super();
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tab.getCreateDialog().show();
			}
		});
		
		final JButton edit = new JButton("Edit");
		edit.setEnabled(false);
		edit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tab.getEditDialog().show();
			}
		});
		
		final JButton delete = new JButton("Delete");
		delete.setEnabled(false);
		delete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!Repository.getInstance().deleteModel(tab.getSelectedModel())){
					JOptionPane.showMessageDialog(tab, "You cannot delete this entry because it is still used.", "Error", JOptionPane.ERROR_MESSAGE);
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

		JButton test = new DbButton();
		
		this.add(add);
		this.add(edit);
		this.add(delete);
		this.add(test);
	}
}
