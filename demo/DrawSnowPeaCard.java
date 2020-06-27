package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSnowPeaCard extends Card{
	
	public DrawSnowPeaCard(AdventurePane pane) {
		super(pane, 106, 145, 6000, 
			new ImageIcon("./img/Cards/SnowPea0.png"),
			new ImageIcon("./img/Cards/SnowPea2.png"),
			new ImageIcon("./img/Cards/SnowPea1.png"),
			new ImageIcon("./img/Blurs/SnowPea.png"));
		super.setState(LOCK_STATE);
	}
	
	public SnowPea CreatePlant(int X, int Y)
	{
		return new SnowPea(X, Y);
	}
}