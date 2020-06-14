package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawCherryBombCard extends JLabel implements Runnable{
	int idx = 2;
	int x ;
	int y ;
	int width = 70;
	int height = 90;
	public DrawCherryBombCard() {
		 setBounds(0, 0, 100, 100);
	     setVisible(true);
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("Cards/CherryBomb" + idx + ".png").getImage(),560 , 0, width, height, this);
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(idx >= 0) {
				repaint();
	       //需要鼠标监听，否则会一直绘图，即不点击也会进入CD
				try {
					//5秒绘制一张图
					Thread.sleep(5000);
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
