package zombies;

import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class BucketheadZombie extends ZombieBasis {
	LinkedList < Image > LoseCap = new LinkedList < > ();
	int losecap = 9;
	public BucketheadZombie() {
		super();
		HP = 15;
		damage = 3;
		int i;
		for (i = 0; i < 21; i++) {
			getWalk().add(new ImageIcon("src/BucketheadZombie/BucketheadZombie/BucketheadZombie_" + i + ".png").getImage());
		}
		for (i = 0; i < 11; i++) {
			getEat().add(new ImageIcon("src/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_" + i + ".png").getImage());
		}
		for (i = 0; i < 22; i++) {
			LoseCap.add(new ImageIcon("src/NormalZombie/Zombie/Zombie_" + i + ".png").getImage());
		}
		for (i = 0; i < 20; i++) {
			getBoomDie().add(new ImageIcon("src/NormalZombie/BoomDie/BoomDie_" + i + ".png").getImage());
		}
		for (i = 0; i < 10; i++) {
			getNormDie().add(new ImageIcon("src/NormalZombie/ZombieDie/ZombieDie_" + i + ".png").getImage());
		}
	}
	@Override
	public void run() {
		while (true) {
			if (HP <= losecap) {
				DrawGroup = LoseCap;
				num = 0;
				repaint();
			}
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
			DrawGroup = Walk;
			num++;
			if (DrawGroup == Walk) {
				if (num == Walk.size()) num = 0;
			}
			if (DrawGroup == LoseCap) {
				if (num == LoseCap.size()) num = 0;
			}
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