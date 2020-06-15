package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSnowPeaCard extends JLabel implements Runnable{
	int idx = 2;
	int x ;
	int y ;
	int width = 70;
	int height = 90;
	public DrawSnowPeaCard() {
		 setBounds(0, 0, 100, 100);
	     setVisible(true);
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("Cards/SnowPea" + idx + ".png").getImage(),340 , 0, width, height, this);
    }
	
	@Override
	public void run() {
		while(true) {
			if(idx >= 0) {
				repaint();
				try {
					//Draw a picture in 3 seconds
					Thread.sleep(3000);
					idx--;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				idx = 2;
			}
		}
	}
}
