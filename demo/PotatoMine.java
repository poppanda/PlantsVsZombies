package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PotatoMine extends plants {
	Bomb retBomb;
	public PotatoMine(int X, int Y) {
		super();
		HP = 4;
		CD = 7;
		attack = 4;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
		setVisible(true);

		for (int i = 0; i < 8; i++) {
			getPotatoMine().add(new ImageIcon("./img/Plants/PotatoMine/PotatoMine/PotatoMine_" + i + ".png").getImage());
		}
		getBombPotato().add(new ImageIcon("./img/Plants/PotatoMine/PotatoMineExplode/PotatoMineExplode_0.png").getImage());
		DrawGroup = PotatoMine;
	}

	@Override
	public void run() {
		while (true) {
			DrawGroup = PotatoMine;
			if (isAlive(this.HP)) {
				try {

					Thread.sleep(100);
					num = (num + 1) % 8;
					repaint();

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
		retBomb = new Bomb(x, x + 80, y, y + 97);
		retBomb.setState(retBomb.WAIT_STATE);
		while(retBomb.state == retBomb.WAIT_STATE)
		{
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		DrawGroup = BombPotato;
		repaint();
		state = DEAD_STATE;
	}
	public Bomb getBomb(){
		return retBomb;
	}
}