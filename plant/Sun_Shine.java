package plant;

import View.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Image;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class Sun_Shine extends JButton {
	private int x, y, num;
	private boolean clicked = false;
	private final ImageIcon PaintingIcon = new ImageIcon("./img/Plants/Sun/Sun_0.png");
	public Sun_Shine(int x, int y, AdventurePane pane) {
		super();
		this.x = x;
		this.y = y;
		setBorder(null);
        setOpaque(false);
        setVisible(true);
		setBounds(x, y, PaintingIcon.getIconWidth(), PaintingIcon.getIconHeight());
		pane.add(this, JLayeredPane.DRAG_LAYER);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.remove(Sun_Shine.this);
				pane.repaint();
			}
		});
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(PaintingIcon.getImage(), 0, 0, this);
	}
}