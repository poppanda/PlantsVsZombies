package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawPotatoMineCard extends Card{
	public DrawPotatoMineCard(AdventurePane pane) {
		super(pane, 53, 75, 500, 
			new ImageIcon("./img/Cards/PotatoMine0.png"),
			new ImageIcon("./img/Cards/PotatoMine2.png"),
			new ImageIcon("./img/Cards/PotatoMine1.png"),
			new ImageIcon("./img/Blurs/PotatoMine.png"));
	}
	
	public PotatoMine CreatePlant()
	{
		return new PotatoMine();
	}
	
}
