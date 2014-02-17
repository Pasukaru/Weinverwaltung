package gui.mainwindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class LoadingPanel extends JPanel {

	private static final long serialVersionUID = -3202625181356999859L;
	
	private JLabel label;
	
	public LoadingPanel(String text){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new BevelBorder(BevelBorder.LOWERED)));

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
