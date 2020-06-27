package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class CherryBomb extends plants {

	int width = 100;
	int height = 100;
	public CherryBomb(int X, int Y) {
		super();
		HP = 10;
		CD = 15;
		attack = 10;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
		setVisible(true);

		for (int i = 0; i < 7; i++) {
			getCherrybomb().add(new ImageIcon("./img/Plants/CherryBomb/CherryBomb_" + i + ".png").getImage());
		}
		DrawGroup = Cherrybomb;
	}


	@Override
	public void run() {
		num = 0;
		while (true) {
			if (isAlive(this.HP)) {
				try {
					Thread.sleep(100);
					repaint();
					if (num + 1 == 7) break;
					else num++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				this.goEmpty();
				break;
			}
		}
		System.out.println("DONE");
	}
	public int boom() {
		return HP = 0;
	}


}