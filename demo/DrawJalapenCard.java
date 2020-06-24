package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawJalapenCard extends Card{
	public int x;
	public int y;
	public DrawSnowPeaCard(AdventurePane pane) {
		
		super(pane, 0, 75, 8000, 
			new ImageIcon("./img/Cards/Jalapen0.png"),
			new ImageIcon("./img/Cards/Jalapen2.png"),
			new ImageIcon("./img/Cards/Jalapen1.png"),
			new ImageIcon("./img/Blurs/Jalapen.png"));
	}
	
	public Jalapen CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new Jalapen(X, Y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
