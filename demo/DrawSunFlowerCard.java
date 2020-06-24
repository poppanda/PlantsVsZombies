package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSunFlowerCard extends Card{
	public int x;
	public int y;
	public DrawSunFlowerCard(AdventurePane pane) {
		
		super(pane, 0, 72, 6000, 
			new ImageIcon("./img/Cards/SunFlower0.png"),
			new ImageIcon("./img/Cards/SunFlower2.png"),
			new ImageIcon("./img/Cards/SunFlower1.png"),
			new ImageIcon("./img/Blurs/SunFlower.png"));
	}
	
	public SunFlower CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new SunFlower(X, Y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
