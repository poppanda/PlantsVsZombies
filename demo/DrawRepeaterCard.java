package demo;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawRepeaterCard extends Card{
	public DrawRepeaterCard(AdventurePane pane) {
		super(pane, 159, 72, 70, 
			new ImageIcon("./img/Cards/Repeater0.png"),
			new ImageIcon("./img/Cards/Repeater2.png"),
			new ImageIcon("./img/Cards/Repeater1.png"),
			new ImageIcon("./img/Blurs/Repeater.png"));
	}
	
	public Repeater CreatePlant()
	{
		return new Repeater();
	}
}