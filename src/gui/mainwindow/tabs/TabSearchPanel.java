package gui.mainwindow.tabs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class TabSearchPanel<T extends Model> extends JPanel {

	private static final long serialVersionUID = -3675296343620436137L;

	private JTextField search;
	
	public void setQuery(String query){
		search.setText(query);
	}
	
	public String getQuery(){
		return search.getText();
	}
	
	public TabSearchPanel(final ModelTab<T> tab){
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		search = new JTextField();
		search.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		
		search.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					tab.refreshData();
				}
			}
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		add(BorderLayout.WEST, new JLabel("Suche: "));
		add(BorderLayout.CENTER, search);


		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton searchButton = new JButton("suchen");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tab.refreshData();
			}
		});
		
		JButton close = new JButton("Tab schlieﬂen");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tab.close();
			}
		});
		
		buttonPanel.add(searchButton);
		buttonPanel.add(close);
		add(BorderLayout.EAST, buttonPanel);
	}
}
