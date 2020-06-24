package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawPeaShooterCard extends Card{
	public int x;
	public int y;
	public DrawPeaShooterCard(AdventurePane pane) {
		
		super(pane, 53, 72, 6000, 
			new ImageIcon("./img/Cards/Peashooter0.png"),
			new ImageIcon("./img/Cards/Peashooter2.png"),
			new ImageIcon("./img/Cards/Peashooter1.png"),
			new ImageIcon("./img/Blurs/Peashooter.png"));
	}
	
	public PeaShooter CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new PeaShooter(X, Y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
