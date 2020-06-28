package plant;

import View.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawSunFlowerCard extends Card{
	public DrawSunFlowerCard(AdventurePane pane) {
		super(pane, 0, 72, 6000, 
			new ImageIcon("./img/Cards/SunFlower0.png"),
			new ImageIcon("./img/Cards/SunFlower2.png"),
			new ImageIcon("./img/Cards/SunFlower1.png"),
			new ImageIcon("./img/Blurs/SunFlower.png"));
	}
	public SunFlower CreatePlant(int X, int Y)
	{
		return new SunFlower(X, Y, super.pane);
	}
}
