package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawPeaShooterCard extends Card{
	public DrawPeaShooterCard(AdventurePane pane) {
		super(pane, 53, 72, 600, 
			new ImageIcon("./img/Cards/Peashooter0.png"),
			new ImageIcon("./img/Cards/Peashooter2.png"),
			new ImageIcon("./img/Cards/Peashooter1.png"),
			new ImageIcon("./img/Blurs/Peashooter.png"));
	}
	
	public PeaShooter CreatePlant()
	{
		return new PeaShooter();
	}
	
}
