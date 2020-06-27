package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawThreePeashooterCard extends Card{
	
	public DrawThreePeashooterCard(AdventurePane pane) {
		super(pane, 265, 145, 9000, 
			new ImageIcon("./img/Cards/ThreePeashooter0.png"),
			new ImageIcon("./img/Cards/ThreePeashooter2.png"),
			new ImageIcon("./img/Cards/ThreePeashooter1.png"),
			new ImageIcon("./img/Blurs/ThreePeashooter.png"));
		super.setState(LOCK_STATE);
	}
	
	public ThreePeashooter CreatePlant(int X, int Y)
	{
		return new ThreePeashooter(X, Y);
	}
}
