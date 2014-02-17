package gui.dialog.cart;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Repository;

import model.Wine;

public class CartDataPanel extends JPanel{

	private static final long serialVersionUID = 518902307693865022L;
	protected int gridy = 0;
	private JFormattedTextField amount;


	public CartDataPanel() {
		this.setLayout(new GridBagLayout());
		addElement(Repository.getInstance(Wine.class).getAll().get(0));
	}

	private void addElement(Wine w){
		String formattedPrice = Double.toString(w.getPrice()/100d)+" E";
		amount = new JFormattedTextField(new Integer(0));

		add(amount, next(0, ++gridy));
		add(new JLabel(w.getName()), next(1, gridy));
		add(new JLabel(formattedPrice), next(2, gridy));
//		add(new JLabel(amount.getText()*w.getPrice()), next(3, gridy));
	}

	protected GridBagConstraints next(int gridx, int gridy) {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = gridx;
		grid.gridy = gridy;
		grid.weightx = 1.0;
		grid.weighty = 1.0;
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.anchor = GridBagConstraints.CENTER;
		return grid;
	}
}
