package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSunFlowerCard extends Card{
	public DrawSunFlowerCard(AdventurePane pane) {
		super(pane, 0, 72, 60, 
			new ImageIcon("./img/Cards/SunFlower0.png"),
			new ImageIcon("./img/Cards/SunFlower2.png"),
			new ImageIcon("./img/Cards/SunFlower1.png"),
			new ImageIcon("./img/Blurs/SunFlower.png"));
	}
	
	public SunFlower CreatePlant()
	{
		return new SunFlower();
	}
	
}
