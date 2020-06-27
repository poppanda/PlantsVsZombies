package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSunShroomCard extends Card{
	public DrawSunShroomCard(AdventurePane pane) {
		super(pane, 212, 145, 4000, 
			new ImageIcon("./img/Cards/SunShroom0.png"),
			new ImageIcon("./img/Cards/SunShroom2.png"),
			new ImageIcon("./img/Cards/SunShroom1.png"),
			new ImageIcon("./img/Blurs/SunShroom.png"));
		super.setState(LOCK_STATE);
	}
	public SunShroom CreatePlant(int X, int Y)
	{
		return new SunShroom(X, Y);
	}
}