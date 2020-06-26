package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSunShroomCard extends Card{
	public DrawSunShroomCard(AdventurePane pane) {
		
		super(pane, 159, 75, 4000, 
			new ImageIcon("./img/Cards/SunShroom0.png"),
			new ImageIcon("./img/Cards/SunShroom2.png"),
			new ImageIcon("./img/Cards/SunShroom1.png"),
			new ImageIcon("./img/Blurs/SunShroom.png"));
	}
	
	public SunShroom CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new SunShroom(X, Y);
	}
	
}