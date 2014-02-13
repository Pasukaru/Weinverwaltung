package gui.mainwindow;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingPanel extends JPanel implements Runnable, ComponentListener{

	private static final long serialVersionUID = -3202625181356999859L;
	
	private static final String[] dots = {".", "..", "..."};

	private JLabel label;
	private JFrame parent;
	private int i;
	private boolean stop;
	private Thread t;
	
	public LoadingPanel(JFrame parent){
		this.parent = parent;
		add(label = new JLabel("", new ImageIcon(getClass().getResource("/images/ajax-loader.gif")), JLabel.CENTER));
		parent.addComponentListener(this);
	}

	@Override
	public void run() {
		while(!stop){
			System.out.println("here");
			i++;
			if(i == dots.length){
				i = 0;
			}
			
			label.setText("Lädt"+dots[i]);
			parent.pack();
			parent.setLocationRelativeTo(null);
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void componentShown(ComponentEvent e) {
		i = 0;
		stop = false;
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void componentHidden(ComponentEvent e) {
		stop = true;
		parent.removeComponentListener(this);
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentResized(ComponentEvent e) {}
}
