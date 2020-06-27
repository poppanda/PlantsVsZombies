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
		setBounds(X, Y, 300, 300);
		setVisible(true);

		for (int i = 0; i < 7; i++) {
			getCherrybomb().add(new ImageIcon("./img/Plants/CherryBomb/CherryBomb_" + i + ".png").getImage());
		}
		getBombCherry().add(new ImageIcon("./img/Screen/Boom.png").getImage());
		
	}


	@Override
	public void run() {
		num = 0;
		while (true) {
			DrawGroup = Cherrybomb;
			if (isAlive(this.HP)) {
				try {
					Thread.sleep(100);
					repaint();
					if (num + 1 == 7) break;
					else num++;
					System.out.println(num);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				state = DEAD_STATE;
				this.goEmpty();
				break;
			}
		}
		state = BOMB_STATE;
		DrawGroup = BombCherry;
		num = 0;
		repaint();
		state = DEAD_STATE;
	}
	public int boom() {
		return HP = 0;
	}


}