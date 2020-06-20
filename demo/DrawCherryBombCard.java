package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawCherryBombCard extends Card{
	public DrawCherryBombCard(AdventurePane pane) {
		super(pane, 0, 72, 1500, 
			new ImageIcon("./img/Cards/CherryBomb0.png"),
			new ImageIcon("./img/Cards/CherryBomb2.png"),
			new ImageIcon("./img/Cards/CherryBomb1.png"),
			new ImageIcon("./img/Blurs/CherryBomb.png"));
	}
	public CherryBomb CreatePlant()
	{
		return new CherryBomb();
	}
}
