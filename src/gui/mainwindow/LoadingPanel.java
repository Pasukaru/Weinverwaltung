package gui.mainwindow;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class LoadingPanel extends JPanel {

	private static final long serialVersionUID = -3202625181356999859L;
	
	private JLabel label;
	
	public LoadingPanel(String text){
		add(label = new JLabel(text, new ImageIcon(getClass().getResource("/images/ajax-loader.gif")), JLabel.CENTER));
		setBorder(new BevelBorder(BevelBorder.RAISED));
	}
	
	public void setText(String text) {
		label.setText(text);
	}

}
