package gui.mainwindow.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.dialog.cart.CartDialog;
import gui.dialog.edit.EditDialog;
import gui.dialog.edit.wine.WineEditDialog;
import gui.mainwindow.DbButton;
import gui.mainwindow.MainWindow;
import gui.table.ModelTableModel;
import gui.table.columns.WineColumnDefinition;
import model.Wine;

public class WineTab extends ModelTab<Wine> {

	private static final long serialVersionUID = -6218897174571210449L;

	public WineTab(MainWindow mainWindow) {
		super(mainWindow, Wine.class, "Weine");

		final JButton addToCart = new JButton("Zum Warenkorb hinzufügen");
		addToCart.setEnabled(false);
		addToCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CartDialog.add(table.getSelectedModel());
			}
		});
		
		final JButton showCart = new JButton("Warenkorb anzeigen");
		showCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CartDialog().show();
			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				addToCart.setEnabled(table.getSelectedModel() != null);
			}
		});

		buttonPanel.add(new DbButton(mainWindow));
		buttonPanel.add(addToCart);
		buttonPanel.add(showCart);
	}

	@Override
	public ModelTableModel<Wine> initTableModel() {
		return new ModelTableModel<Wine>(new WineColumnDefinition());
	}

	@Override
	public EditDialog<Wine> getEditDialog() {
		return new WineEditDialog(getSelectedModel());
	}

	@Override
	public EditDialog<Wine> getCreateDialog() {
		return new WineEditDialog(new Wine());
	}
}