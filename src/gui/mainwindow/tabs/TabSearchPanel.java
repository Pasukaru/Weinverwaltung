package gui.mainwindow.tabs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class TabSearchPanel<T extends Model> extends JPanel {

	private static final long serialVersionUID = -3675296343620436137L;

	private JTextField search;
	
	private Timer timer;
	private SearchTask task;
	
	private class SearchTask extends TimerTask {
		private ModelTab<T> tab;

		public SearchTask(ModelTab<T> tab){
			this.tab = tab;
		}
		
		@Override
		public void run() {
			tab.refreshData();
		}
	}
	
	public TabSearchPanel(final ModelTab<T> tab){
		timer = new Timer();
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		search = new JTextField();
		search.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		
		final TabSearchPanel<T> self = this;
		
		search.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					self.cancelSearch();
					tab.refreshData();
				} else {
					self.scheduleSearch(tab);
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
		
		JButton searchButton = new JButton("Aktualisieren");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tab.refreshData();
			}
		});
		
		JButton close = new JButton("Tab schließen");
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
	
	public void cancelSearch(){
		if(task != null){
			try{ task.cancel(); }
			catch(Exception e){}
			task = null;
		}
	}
	
	public void scheduleSearch(ModelTab<T> tab){
		cancelSearch();
		task = new SearchTask(tab);
		timer.schedule(task, 250);
	}
	
	public void setQuery(String query){
		search.setText(query);
	}
	
	public String getQuery(){
		return search.getText();
	}
}
