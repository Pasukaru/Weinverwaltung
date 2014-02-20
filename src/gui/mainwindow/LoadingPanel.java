package gui.mainwindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import util.SplashMessage;

public class LoadingPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = -3202625181356999859L;
	
	private JLabel label;
	private Thread splash = null;
	
	public LoadingPanel(){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new BevelBorder(BevelBorder.LOWERED)));

		JLabel title = new JLabel("Weinverwaltung", JLabel.CENTER);
		title.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
		
		add(BorderLayout.NORTH, title);
		
		try {
			add(BorderLayout.CENTER, new ImagePanel(ImageIO.read(getClass().getResource("/images/splash.jpg"))));
		} catch (Exception e) {e.printStackTrace();}
		
		add(BorderLayout.SOUTH, label = new JLabel("", new ImageIcon(getClass().getResource("/images/ajax-loader.gif")), JLabel.CENTER));
	}
	
	private void setText(){
		label.setText(SplashMessage.getNext());
	}
	
	public void start(){
		if(splash != null){
			try { splash.join(); } 
			catch (InterruptedException e) {}
			stop();
		}
		splash = new Thread(this);
		splash.start();
	}
	
	@Override
	public void run() {
		while(splash != null){
			try {
				setText();
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
		}
	}
	
	public void stop(){
		splash = null;
	}

}
