package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PeaShooter extends plants {
	
	public PeaShooter(int X, int Y) {
		super();
		HP = 40;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
		setVisible(true);

		for (int i = 0; i < 13; i++) {
			getPeashooter().add(new ImageIcon("./img/Plants/Peashooter/Peashooter_" + i + ".png").getImage());
		}

		DrawGroup = Peashooter;
	}

	@Override
	public void run() {

		while (true) {
			if (isAlive()) {
				try {
					if (num == 3) state = ATTACK_STATE;
					else state = NORMAL_STATE;
					if (BulletsList.size() == 0) {
						System.out.println("ADD");
						BulletsList.add(new Bullets(x + 10, y));
					}
					Thread.sleep(100);
					repaint();
					num = (num + 1) % 12;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				state = DEAD_STATE;
				break;
			}
		}
	}

	public Bullets getBullet() {
		Bullets ret = BulletsList.getFirst();
		BulletsList.removeFirst();
		return ret;
	}
}