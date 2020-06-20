package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawThreePeashooterCard extends Card{
	public DrawThreePeashooterCard(AdventurePane pane) {
		
		super(pane, 212, 75, 900, 
			new ImageIcon("./img/Cards/ThreePeashooter0.png"),
			new ImageIcon("./img/Cards/ThreePeashooter2.png"),
			new ImageIcon("./img/Cards/ThreePeashooter1.png"),
			new ImageIcon("./img/Blurs/ThreePeashooter.png"));
	}
	
	public ThreePeashooter CreatePlant()
	{
		return new ThreePeashooter();
	}
	
}
