package gui.window.main.tabs.wines;

import gui.dialog.edit.city.CityEditDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.City;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = -7314612205656147889L;

	public ButtonsPanel(WineTab tab) {
		super();
		this.add(new AddButton());
		this.add(new EditButton(tab));

		
		JButton test = new JButton("Test AddCity");
		
		test.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CityEditDialog(new City()).show();
			}
		});
		
		this.add(test);
	}
}
