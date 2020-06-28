package plant;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;

public class Bullets extends JLabel implements Runnable
{
	public int x, y, damage = 1, state;
	public final int HIT_STATE = 1, NOEM_STATE = 0, DEAD_STATE = 2;
	Image BulletsImage, BulletsbombImage, PaintingImage;
	public Bullets(int X, int Y) {
		super();
		this.x = X;
		this.y = Y;
		this.state = NOEM_STATE;
		setBounds(X, Y, 100, 100);
		setVisible(true);

		BulletsImage = (new ImageIcon("./img/Bullets/PeaNormal/PeaNormal_0.png").getImage());
		BulletsbombImage = (new ImageIcon("./img/Bullets/PeaNormalExplode/PeaNormalExplode_0.png").getImage());

		PaintingImage = BulletsImage;
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(PaintingImage, 0, 0, this);
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				repaint();
				this.setBounds(x = x + 20, y, 100, 100);
				if (state == HIT_STATE) {
					PaintingImage = BulletsbombImage;
					repaint();
					Thread.sleep(100);
					state = DEAD_STATE;
					break;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}