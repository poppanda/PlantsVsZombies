package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawHypnoShroomCard extends Card{
	
	public DrawHypnoShroomCard(AdventurePane pane) {
		
		super(pane, 0, 145, 6000, 
			new ImageIcon("./img/Cards/HypnoShroom0.png"),
			new ImageIcon("./img/Cards/HypnoShroom2.png"),
			new ImageIcon("./img/Cards/HypnoShroom1.png"),
			new ImageIcon("./img/Blurs/HypnoShroom.png"));
		super.setState(LOCK_STATE);
	}
	
	public HypnoShroom CreatePlant(int X, int Y)
	{
		this.x = X;
		this.y = Y;
		return new HypnoShroom(X, Y);
	}
		
}