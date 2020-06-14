package zombies;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Image;
import java.lang.Thread;

import javax.swing.ImageIcon;
class Zombie extends ZombieBasis {
	public Zombie() {
		super();
		HP = 10;
		damage = 3;
		int i;
		for (i = 0; i < 20; i++) {
			getBoomDie().add(new ImageIcon("src/NormalZombie/BoomDie/BoomDie_" + i + ".png").getImage());
		}
		for (i = 0; i < 10; i++) {
			getNormDie().add(new ImageIcon("src/NormalZombie/ZombieDie/ZombieDie_" + i + ".png").getImage());
		}
		for (i = 0; i < 22; i++) {
			getWalk().add(new ImageIcon("src/NormalZombie/Zombie/Zombie_" + i + ".png").getImage());
		}
		for (i = 0; i < 21; i++) {
			getEat().add(new ImageIcon("src/NormalZombie/ZombieAttack/ZombieAttack_" + i + ".png").getImage());
		}
	}
	@Override
	public void run() {
		while (true) {
			if (iseating()) {
				eat();
				DrawGroup = Walk;
				num = 0;
				repaint();
			}
			if (!isAlive()) {
				die();
				break;
			}
			num++;
			if (num == Walk.size()) num = 0;
			setX(getX() - 5);
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}