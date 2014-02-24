package gui.mainwindow;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.City;
import model.Country;
import model.Model;
import model.Region;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;

public class TabSelectorTab extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Class<?>[] clazzes = {Wine.class, Type.class, Sort.class, Vine.class, Winery.class, City.class, Region.class, Country.class};

	public TabSelectorTab(final MainWindow mainWindow) {
		setLayout(new FlowLayout());
		for(Class<?> clazz : clazzes){
			@SuppressWarnings("unchecked")
			final Class<Model> x = (Class<Model>) clazz;
			JButton button = new JButton(mainWindow.getTabTitle(x));
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					mainWindow.openTab(x);
				}
			});
			add(button);
		}
	}
}
