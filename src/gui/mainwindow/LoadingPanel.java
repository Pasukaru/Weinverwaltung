package gui.mainwindow;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class LoadingPanel extends JPanel {

	private static final long serialVersionUID = -3202625181356999859L;
	
	private JLabel label;
	
	public LoadingPanel(String text){
		setLayout(new BorderLayout());
		setBorder(new BevelBorder(BevelBorder.RAISED));

		try {
			add(BorderLayout.CENTER, new ImagePanel(ImageIO.read(getClass().getResource("/images/splash.jpg"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		add(BorderLayout.SOUTH, label = new JLabel(text, new ImageIcon(getClass().getResource("/images/ajax-loader.gif")), JLabel.CENTER));
	}
	
	public void setText(String text) {
		label.setText(text);
	}

}
