package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSquashCard extends Card{
	public DrawSquashCard(AdventurePane pane) {
		
		super(pane, 106, 75, 15000, 
			new ImageIcon("./img/Cards/Squash0.png"),
			new ImageIcon("./img/Cards/Squash2.png"),
			new ImageIcon("./img/Cards/Squash1.png"),
			new ImageIcon("./img/Blurs/Squash.png"));
	}
	
	public Squash CreatePlant()
	{
		return new Squash();
	}
	
}