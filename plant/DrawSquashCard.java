package plant;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSquashCard extends Card{
	
	public DrawSquashCard(AdventurePane pane) {
		super(pane, 159, 145, 15000, 
			new ImageIcon("./img/Cards/Squash0.png"),
			new ImageIcon("./img/Cards/Squash2.png"),
			new ImageIcon("./img/Cards/Squash1.png"),
			new ImageIcon("./img/Blurs/Squash.png"));
		super.setState(LOCK_STATE);
	}
	public Squash CreatePlant(int X, int Y)
	{
		return new Squash(X, Y);
	}
}
