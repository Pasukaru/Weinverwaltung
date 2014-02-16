package gui.mainwindow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 5255144389794223172L;

    public ImagePanel(BufferedImage image) {
    	setLayout(new BorderLayout());
    	
    	double r = ((double) image.getWidth())/((double) image.getHeight());
    	int th = 400;
    	int tw = (int) (th*r);
    	
    	add(BorderLayout.CENTER, new JLabel(new ImageIcon(image.getScaledInstance(tw, th, Image.SCALE_FAST))));
    	this.setPreferredSize(new Dimension(tw, th));
    }

}