package gui.dialog.cart;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import util.StringUtils;
import model.Wine;

public class CartDataPanel extends JPanel{

	private static final long serialVersionUID = 518902307693865022L;
	protected int gridy = 0;
	
	private JLabel total = new JLabel();
	private CartDialog dialog;
	
	public CartDataPanel(CartDialog dialog) {
		this.dialog = dialog;
		this.setLayout(new GridBagLayout());
	}
	
	public void render(){
		add(new JLabel("Anzahl"), next(0, ++gridy));
		add(new JLabel("Name"), next(1, gridy));
		add(new JLabel("Preis"), next(2, gridy));
		add(new JLabel("Gesamt"), next(3, gridy));
		
		for(CartEntry e: CartDialog.cart) {
			addElement(e);
		}

		GridBagConstraints g = next(0, ++gridy);
		g.gridwidth = 3;
		g.insets = new Insets(20, 0, 0, 0);
		add(new JLabel("Gesamtpreis"), g);
		add(total = new JLabel("asdf"), next(3, gridy));
		
		calcTotal();
	}
	
	private void calcTotal(){
		int total = 0;
		for(CartEntry e : CartDialog.cart){
			total += e.getAmount()*e.getWine().getPrice();
		}
		this.total.setText(StringUtils.formatCurrency(total/100d));
	}
	
	private void update(JSpinner amount, JLabel price, JLabel total, CartEntry e){
		int i = e.getAmount();
		try { i = (Integer) amount.getValue(); } 
		catch(Exception ex){ return; }
		e.setAmount(i);
		amount.setValue(i);
		price.setText(StringUtils.formatPrice(e.getWine().getPrice()));
		total.setText(StringUtils.formatPrice(e.getWine().getPrice()*i));
		calcTotal();
		
		if(i < 1){
			int val = JOptionPane.showConfirmDialog(null, "Eintrag entfernen?", "Option auswählen", JOptionPane.YES_NO_OPTION);
			if(val == JOptionPane.YES_OPTION){
				CartDialog.cart.remove(e);
				if(CartDialog.cart.isEmpty()){
					dialog.close();
					return;
				}
				removeAll();
				render();
				repaint();
			} else {
				amount.setValue(1);
				update(amount, price, total, e);
			}
		}
	}

	private void addElement(final CartEntry e){
		Wine w = e.getWine();
		int amt = e.getAmount();
		
		final CartDataPanel self = this;
		
		SpinnerNumberModel snm = new SpinnerNumberModel(amt, 0, 100, 1);
		
		final JSpinner amount = new JSpinner(snm);
		final JLabel price = new JLabel(StringUtils.formatPrice(w.getPrice()));
		final JLabel total = new JLabel(StringUtils.formatPrice(w.getPrice()*amt));
		
		snm.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				self.update(amount, price, total, e);
			}
		});
		
		add(amount, next(0, ++gridy));
		add(new JLabel(w.getName()), next(1, gridy));
		add(price, next(2, gridy));
		add(total, next(3, gridy));
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
