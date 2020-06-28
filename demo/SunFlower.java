package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SunFlower extends plants {
	AdventurePane pane;
	public SunFlower(int X, int Y, AdventurePane pane) {
		super();
		HP = 4;
		CD = 6;
		attack = 0;
		this.x = X;
		this.y = Y;
		this.pane = pane;
		setBounds(X, Y, 100, 100);
		setVisible(true);
		for (int i = 0; i < 18; i++) {
			getSunflower().add(new ImageIcon("./img/Plants/SunFlower/SunFlower_" + i + ".png").getImage());
		}
		DrawGroup = Sunflower;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			count++;
			if(count == 50)
			{
				count = 0;
				new Sun_Shine(x, y, pane);
			}
			if (isAlive()) {
				try {
					Thread.sleep(100);
					num = (num + 1) % 18;
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				state = DEAD_STATE;
				break;
			}
		}
	}
}