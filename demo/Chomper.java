package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Chomper extends plants {

	public Chomper(int X, int Y) {
		super();
		HP = 6;
		this.x = X;
		this.y = Y;
		state = CAN_EAT_STATE;
		setBounds(X, Y, 100, 100);
		setVisible(true);

		for (int i = 0; i < 13; i++) {
			getChomper().add(new ImageIcon("./img/Plants/Chomper/Chomper/Chomper_" + i + ".png").getImage());
		}
		for (int i = 0; i < 9; i++) {
			getChomperAttack().add(new ImageIcon("./img/Plants/Chomper/ChomperAttack/ChomperAttack_" + i + ".png").getImage());
		}
		for (int i = 0; i < 6; i++) {
			getChomperDigest().add(new ImageIcon("./img/Plants/Chomper/ChomperDigest/ChomperDigest_" + i + ".png").getImage());
		}
		DrawGroup = Chomper;
	}

	public void Eat() {
		state = EAT_STATE;
		num = 0;
	}

	@Override
	public void run() {
		int eatingTime = 0;
		while (true) {
			if (isAlive()) {
				try {
					if (state == CAN_EAT_STATE) {
						DrawGroup = Chomper;
						Thread.sleep(100);
						repaint();
						num = (num + 1) % 13;
					} else if (state == EAT_STATE) {
						DrawGroup = ChomperAttack;
						Thread.sleep(100);
						repaint();
						num = (num + 1) % 9;
						if (num == 0) {
							state = EATING;
							eatingTime = 10000;
							num = 0;
						}
					} else if (state == EATING) {
						DrawGroup = ChomperDigest;
						Thread.sleep(100);
						eatingTime -= 100;
						repaint();
						num = (num + 1) % 6;
						if (eatingTime == 0) state = CAN_EAT_STATE;
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