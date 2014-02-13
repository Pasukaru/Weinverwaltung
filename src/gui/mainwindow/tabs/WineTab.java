package gui.mainwindow.tabs;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.dialog.edit.EditDialog;
import gui.dialog.edit.wine.WineEditDialog;
import gui.table.ModelTableModel;
import gui.table.columns.wine.WineColumnDefinition;
import model.Wine;

public class WineTab extends ModelTab<Wine> {

	private static final long serialVersionUID = -6218897174571210449L;

	public WineTab() {
		super(Wine.class);

		final JButton cart = new JButton("Add to cart");
		cart.setEnabled(false);
		cart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				JOptionPane.showMessageDialog(null, "TODO");

//				JFrame jf = new JFrame();
//				FlowLayout fl = new FlowLayout();
//				jf.setLayout(fl);
//				jf.setVisible(true);

			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				cart.setEnabled(table.getSelectedModel() != null);
			}
		});

		buttonPanel.add(cart);
	}

	@Override
	public ModelTableModel<Wine> initTableModel() {
		return new ModelTableModel<Wine>(fetchData(), new WineColumnDefinition());
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