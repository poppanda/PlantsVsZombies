package plant;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class WallNut extends plants {

	public WallNut(int X, int Y) {
		super();
		HP = 400;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
		setVisible(true);

		for (int i = 0; i < 16; i++) {
			getWallnut().add(new ImageIcon("./img/Plants/WallNut/WallNut/WallNut_" + i + ".png").getImage());
		}
		for (int i = 0; i < 11; i++) {
			getWallnut1().add(new ImageIcon("./img/Plants/WallNut/Wallnut_cracked1/Wallnut_cracked1_" + i + ".png").getImage());
		}
		for (int i = 0; i < 15; i++) {
			getWallnut2().add(new ImageIcon("./img/Plants/WallNut/Wallnut_cracked2/Wallnut_cracked2_" + i + ".png").getImage());
		}
		DrawGroup = getWallnut();
	}

	@Override
	public void run() {
		while (true) {
			if (isAlive()) {
				try {
					if (HP > 250) {
						DrawGroup = Wallnut;

						Thread.sleep(100);
						num = (num + 1) % 16;
						repaint();

					} else if (HP > 100 && HP <= 250) {
						DrawGroup = Wallnut1;

						Thread.sleep(100);
						num = (num + 1) % 11;
						repaint();

					} else if (HP > 0 && HP <= 100) {
						DrawGroup = Wallnut2;

						Thread.sleep(100);
						num = (num + 1) % 15;
						repaint();

					} else {

						break;
					}

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