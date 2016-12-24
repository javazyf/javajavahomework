package View;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ÓÐ±³¾°Í¼Æ¬µÄPanelÀà
 */

public class BackGroundJPanel extends JPanel {
	public BackGroundJPanel() {
		
	}

	public void paintComponent(Graphics g) {
		int x = 0, y = 0;
		java.net.URL imgURL = getClass().getResource("/picture/2.jpg");
		ImageIcon icon = new ImageIcon(imgURL);
		g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height, this);
		while (true) {
			g.drawImage(icon.getImage(), x, y, this);
			if (x > getSize().width && y > getSize().height)
				break;
			
			if (x > getSize().width) {
				x = 0;
				y += icon.getIconHeight();
			} else
				x += icon.getIconWidth();

		}

	}

}
