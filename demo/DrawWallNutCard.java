package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawWallNutCard extends Card{
	public DrawWallNutCard(AdventurePane pane) {
		
		super(pane, 212, 72, 1200, 
			new ImageIcon("./img/Cards/WallNut0.png"),
			new ImageIcon("./img/Cards/WallNut2.png"),
			new ImageIcon("./img/Cards/WallNut1.png"),
			new ImageIcon("./img/Blurs/WallNut.png"));
	}
	
	public WallNut CreatePlant()
	{
		return new WallNut();
	}
	
}