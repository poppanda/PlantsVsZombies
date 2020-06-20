package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawCherryBombCard extends Card{
	Image LightIcon = new ImageIcon("Card/CherryBomb0.png");
	Image DarkIcon = new ImageIcon("Card/CherryBomb2.png");
	Image FillIcon = new ImageIcon("Card/CherryBomb1.png");
	Image CursorIcon = new ImageIcon("CherryBomb/boom/CherryBomb_0.png");
	public DrawCherryBombCard(AdventurePane pane) {
		super(pane, 0, 72, 15, LightIcon, DarkIcon, FillIcon, CursorIcon);
	}
}
