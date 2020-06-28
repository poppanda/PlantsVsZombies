package plant;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class CherryBomb extends plants {

	public CherryBomb(int X, int Y) {
		super();
		HP = 30;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 300, 300);
		setVisible(true);

		for (int i = 0; i < 7; i++) {
			getCherrybomb().add(new ImageIcon("./img/Plants/CherryBomb/CherryBomb_" + i + ".png").getImage());
		}
		getBombCherry().add(new ImageIcon("./img/Screen/Boom.png").getImage());
		DrawGroup = getCherrybomb();
	}


	@Override
	public void run() {
		num = 0;
		while (true) {
			DrawGroup = Cherrybomb;
			if (isAlive()) {
				try {
					Thread.sleep(100);
					repaint();
					if (num + 1 == 7) break;
					else num++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				state = DEAD_STATE;
				break;
			}
		}
		state = BOMB_STATE;
		try{
			Thread.sleep(100);
			DrawGroup = BombCherry;
			num = 0;
			repaint();
			Thread.sleep(500);
			state = DEAD_STATE;
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public Bomb getBomb()
	{
		Bomb ret = new Bomb((x - 55)/80 - 2, (x - 55)/80 + 1, (y - 100) / 97 - 1, (y - 100) / 97 + 1);
		ret.setState(ret.BOMB_STATE);
		return ret;
	}
}