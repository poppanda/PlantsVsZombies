package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawPotatoMineCard extends Card{
	public int x;
	public int y;
	public DrawPotatoMineCard(AdventurePane pane) {
		
		super(pane, 53, 75, 5000, 
			new ImageIcon("./img/Cards/PotatoMine0.png"),
			new ImageIcon("./img/Cards/PotatoMine2.png"),
			new ImageIcon("./img/Cards/PotatoMine1.png"),
			new ImageIcon("./img/Blurs/PotatoMine.png"));
	}
	
	public PotatoMine CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new PotatoMine(X, Y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
