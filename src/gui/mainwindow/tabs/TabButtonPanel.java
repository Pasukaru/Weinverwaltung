package gui.mainwindow.tabs;

import gui.dialog.edit.city.CityEditDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.City;
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
		
		tab.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				edit.setEnabled(event.getFirstIndex() >= 0);
			}
		});

		JButton test = new JButton("Test AddCity");
		
		test.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CityEditDialog(new City()).show();
			}
		});
		
		this.add(add);
		this.add(edit);
		this.add(test);
	}
}
