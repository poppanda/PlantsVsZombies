package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawPeaShooterCard extends JLabel implements Runnable{
	int idx = 2;
	int x ;
	int y ;
	int width = 70;
	int height = 90;
	public DrawPeaShooterCard() {
		 setBounds(0, 0, 100, 100);
	     setVisible(true);
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("Cards/Peashooter" + idx + ".png").getImage(),270 , 0, width, height, this);
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(idx >= 0) {
				repaint();
	       //��Ҫ�������������һֱ��ͼ���������Ҳ�����CD
				try {
					//2�����һ��ͼ
					Thread.sleep(2000);
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

