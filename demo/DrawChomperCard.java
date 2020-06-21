package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawChomperCard extends Card{
	public DrawChomperCard(AdventurePane pane) {
		
		super(pane, 318, 72, 9000, 
			new ImageIcon("./img/Cards/Chomper0.png"),
			new ImageIcon("./img/Cards/Chomper2.png"),
			new ImageIcon("./img/Cards/Chomper1.png"),
			new ImageIcon("./img/Blurs/Chomper.png"));
	}
	
	public Chomper CreatePlant()
	{
		return new Chomper();
	}
	
}
