package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawHypnoShroomCard extends Card{
	public DrawHypnoShroomCard(AdventurePane pane) {
		
		super(pane, 371, 72, 600, 
			new ImageIcon("./img/Cards/HypnoShroom0.png"),
			new ImageIcon("./img/Cards/HypnoShroom2.png"),
			new ImageIcon("./img/Cards/HypnoShroom1.png"),
			new ImageIcon("./img/Blurs/HypnoShroom.png"));
	}
	
	public HypnoShroom CreatePlant()
	{
		return new HypnoShroom();
	}
	
}