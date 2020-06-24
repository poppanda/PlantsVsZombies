package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawRepeaterCard extends Card{
	public int x;
	public int y;
	public DrawRepeaterCard(AdventurePane pane) {
		
		super(pane, 159, 72, 7000, 
			new ImageIcon("./img/Cards/Repeater0.png"),
			new ImageIcon("./img/Cards/Repeater2.png"),
			new ImageIcon("./img/Cards/Repeater1.png"),
			new ImageIcon("./img/Blurs/Repeater.png"));
	}
	
	public Repeater CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new Repeater(X, Y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}