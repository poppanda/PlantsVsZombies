package plant;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawRepeaterCard extends Card{

	public DrawRepeaterCard(AdventurePane pane) {
		super(pane, 159, 72, 7000, 
			new ImageIcon("./img/Cards/Repeater0.png"),
			new ImageIcon("./img/Cards/Repeater2.png"),
			new ImageIcon("./img/Cards/Repeater1.png"),
			new ImageIcon("./img/Blurs/Repeater.png"));
	}
	public Repeater CreatePlant(int X, int Y)
	{
		return new Repeater(X, Y);
	}
}