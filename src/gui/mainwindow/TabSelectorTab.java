package gui.mainwindow;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TabSelectorTab extends JPanel {

	private static final long serialVersionUID = 1L;

	public TabSelectorTab(final MainWindow mainWindow) {
		setLayout(new FlowLayout());

		JButton city = new JButton("Städte");
		city.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.addCityTab();
			}
		});
		
		JButton sort = new JButton("Weinsorten");
		sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.addSortTab();
			}
		});
		
		JButton type = new JButton("Weinarten");
		type.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.addTypeTab();
			}
		});
		
		JButton vine = new JButton("Rebsorten");
		vine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.addVineTab();
			}
		});
		
		JButton winery = new JButton("Winzer");
		winery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.addWineryTab();
			}
		});
		
		JButton wine = new JButton("Weine");
		wine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.addWineTab();
			}
		});

		add(wine);
		add(type);
		add(sort);
		add(vine);
		add(winery);
		add(city);
	}
}
