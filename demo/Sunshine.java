package demo;

import View.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Image;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class Sunshine extends JButton {
	private int x, y, num;
	private boolean clicked = false;
	private Thread moveThread = null;
	private static ReentrantLock lock = new ReentrantLock();
	LinkedList < Image > sunIcons = new LinkedList < > ();
	public int MODE;
	public final int PRODUCE_MODE = 0, SUN_MODE = 1, DEAD_MODE = 2;
	public Sunshine(int x, int y, int MODE, AdventurePane pane) {
		super();
		for (int i = 0; i <= 21; i++)
			sunIcons.add(new ImageIcon("./img/Plants/Sun/Sun_" + i + ".png").getImage());
		num = 0;
		this.MODE = MODE;
		this.x = x;
		this.y = y;
		setBounds(x, y, 100, 100);
		pane.add(this, JLayeredPane.DRAG_LAYER);
		moveThread = new move();
		//moveThread.start();
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CLICK");
				clicked = true;
				setEnabled(false);
				(new moveToCorner()).start();
			}
		});
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(num);
		g.drawImage(sunIcons.get(num), 0, 0, this);
		//g.drawImage(new ImageIcon("./img/Plants/Sun/Sun_0.png").getImage(), 0, 0, this);
	}
	class moveToCorner extends Thread {
		public moveToCorner() {
			int time = 500;
			double nx = x, ny = y, vx = (10 - x) / 5, vy = (10 - y) / 5;
			while (time != 0) {
				try {
					Thread.sleep(100);
					time -= 100;
					nx += vx;
					ny += vy;
					setLocation(x = (int) nx, y = (int) ny);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			MODE = DEAD_MODE;
		}
	}
	class move extends Thread {
		public move() {
			setEnabled(false);
			try {
				if (MODE == PRODUCE_MODE) {
					double dx = -40, dy, ox = x, oy = y, vx = 8, a = 0.125;
					int time = 1000;
					while (time != 0 && clicked == false) {
						num = (num + 1) % 22;
						repaint();
						Thread.sleep(100);
						time -= 100;
						dx += vx;
						dy = 100 - a * dx * dx / 2;
						x = (int)(ox + dx);
						y = (int)(oy + dy);
						setLocation(x, y);
					}
				} else if (MODE == SUN_MODE) {
					double ny = y, dy = (int) Math.random() % 300 + 200, vy = 12;
					while (ny < dy && clicked == false) {
						num = (num + 1) % 22;
						repaint();
						Thread.sleep(100);
						ny += vy;
						y = (int) ny;
						setLocation(x, y);
					}
				}
				setEnabled(true);
				Thread.sleep(5000);
				MODE = DEAD_MODE;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}