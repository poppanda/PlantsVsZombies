package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawRepeaterCard extends JLabel implements Runnable{
	int idx = 2;
	int x ;
	int y ;
	int width = 70;
	int height = 90;
	public DrawRepeaterCard() {
		 setBounds(0, 0, 100, 100);
	     setVisible(true);
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("Cards/Repeater" + idx + ".png").getImage(),410 , 0, width, height, this);
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(idx >= 0) {
				repaint();
	       //��Ҫ�������������һֱ��ͼ���������Ҳ�����CD
				try {
					//3�����һ��ͼ
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
