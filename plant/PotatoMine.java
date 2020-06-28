package plant;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PotatoMine extends plants {
	Bomb retBomb;
	public PotatoMine(int X, int Y) {
		super();
		HP = 30;
		this.x = X;
		this.y = Y;
		this.dy = 30;
		state = INIT_STATE;
		setBounds(X, Y, 200, 200);
		setVisible(true);

		for (int i = 0; i < 8; i++) {
			getPotatoMine().add(new ImageIcon("./img/Plants/PotatoMine/PotatoMine/PotatoMine_" + i + ".png").getImage());
		}
		getBombPotato().add(new ImageIcon("./img/Plants/PotatoMine/PotatoMineExplode/PotatoMineExplode_0.png").getImage());
		getPotatoInit().add(new ImageIcon("./img/Plants/PotatoMine/PotatoMineInit/PotatoMineInit_0.png").getImage());
		DrawGroup = PotatoInit;
	}
	@Override
	public void run() {
		int beBigTime = 3000;
		retBomb = new Bomb((x - 55)/80 - 1, (x - 55)/80 - 1, (y - 100) / 97, (y - 100) / 97);
		retBomb.setState(retBomb.WAIT_STATE);
		while (true) {
			if (isAlive()) {
				try {
					if(state == INIT_STATE)
					{
						DrawGroup = PotatoInit;
						Thread.sleep(100);
						beBigTime -= 100;
						repaint();
						if(beBigTime == 0)
						{
							state = BOMB_STATE;
							num = 0;
						}
					}
					else if(state == BOMB_STATE) {
						DrawGroup = PotatoMine;
						if(retBomb.state == retBomb.BOMB_STATE)break;
						Thread.sleep(100);
						num = (num + 1) % 8;
						repaint();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				state = DEAD_STATE;
				break;
			}
		}
		num = 0;
		DrawGroup = BombPotato;
		repaint();
		try{
			Thread.sleep(500);
			state = DEAD_STATE;
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public Bomb getBomb(){
		return retBomb;
	}
}