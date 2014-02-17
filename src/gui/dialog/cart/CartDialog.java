package gui.dialog.cart;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class CartDialog extends JOptionPane{

	private static final long serialVersionUID = 1570317439463845409L;

	protected CartDataPanel dataPanel;
	private String title;
	private JDialog dialog = null;


	public CartDialog(){
		setLayout(new BorderLayout());
		add(dataPanel = new CartDataPanel(), BorderLayout.CENTER);
		title="";
		show();
	}

	public void show(){
		dialog = createDialog(title);
		dialog.setVisible(true);
	}
}
