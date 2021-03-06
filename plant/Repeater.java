package plant;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Repeater extends plants {

	public Repeater(int X, int Y) {
		super();
		HP = 50;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
		setVisible(true);
		for (int i = 0; i < 15; i++)
			getRepeater().add(new ImageIcon("./img/Plants/RepeaterPea/RepeaterPea_" + i + ".png").getImage());

		DrawGroup = Repeater;
	}


	@Override
	public void run() {
		while (true) {
			if (isAlive()) {
				try {
					if (num == 2) state = ATTACK_STATE;
					else state = NORMAL_STATE;
					if (BulletsList.size() == 0) {
						BulletsList.add(new Bullets(x + 10, y));
						BulletsList.add(new Bullets(x + 40, y));
					}

					Thread.sleep(100);
					repaint();
					num = (num + 1) % 15;
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

	public boolean remainBullets() {
		return BulletsList.size() != 0;
	}
}