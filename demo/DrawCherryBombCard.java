package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawCherryBombCard extends Card{
	
	public int x;
	public int y;
	public DrawCherryBombCard(AdventurePane pane) {
		super(pane, 265, 72, 15000, 
			new ImageIcon("./img/Cards/CherryBomb0.png"),
			new ImageIcon("./img/Cards/CherryBomb2.png"),
			new ImageIcon("./img/Cards/CherryBomb1.png"),
			new ImageIcon("./img/Blurs/CherryBomb.png"));
	}
	
	public CherryBomb CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new CherryBomb(X, Y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}