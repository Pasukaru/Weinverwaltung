package gui.dialog.cart;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Wine;


public class CartDialog extends JOptionPane {

	private static final long serialVersionUID = 1570317439463845409L;

	protected final static List<CartEntry> cart = new ArrayList<CartEntry>();
	
	protected CartDataPanel dataPanel;
	
	private JDialog dialog = null;

	public static void add(Wine wine){
		CartEntry entry = null;
		
		for(int i=0, n=cart.size(); i<n; i++){
			if(cart.get(i).getWine() == wine){
				entry = cart.get(i);
				break;
			}
		}
		
		if(entry == null){
			entry = new CartEntry(wine);
			cart.add(entry);
		} else { 
			if(entry.getAmount() < 100){
				entry.setAmount(entry.getAmount()+1);
			}
		}
	}
	
	public CartDialog(){
		setLayout(new BorderLayout());
		add(dataPanel = new CartDataPanel(this), BorderLayout.CENTER);
	}

	public void show(){
		if(cart.isEmpty()){
			JOptionPane.showMessageDialog(null, "Der Warenkorb ist noch leer!", "Warnung", JOptionPane.WARNING_MESSAGE);
			return;
		}
		dataPanel.render();
		dialog = createDialog("Warenkorb");
		dialog.setVisible(true);
	}
	
	public void close(){
		if(dialog != null){
			dialog.dispose();	
		}
	}
}
