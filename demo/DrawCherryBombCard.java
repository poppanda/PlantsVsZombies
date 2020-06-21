package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawCherryBombCard extends Card{
	public DrawCherryBombCard(AdventurePane pane) {
<<<<<<< HEAD
		super(pane, 265, 72, 15000, 
=======
		super(pane, 0, 72, 15000, 
>>>>>>> 06bdd91daab52a1f5189fa9fca805acd85fa46af
			new ImageIcon("./img/Cards/CherryBomb0.png"),
			new ImageIcon("./img/Cards/CherryBomb2.png"),
			new ImageIcon("./img/Cards/CherryBomb1.png"),
			new ImageIcon("./img/Blurs/CherryBomb.png"));
<<<<<<< HEAD
=======
	}
	public CherryBomb CreatePlant()
	{
		return new CherryBomb();
>>>>>>> 06bdd91daab52a1f5189fa9fca805acd85fa46af
	}
	
	public CherryBomb CreatePlant()
	{
		return new CherryBomb();
	}
}