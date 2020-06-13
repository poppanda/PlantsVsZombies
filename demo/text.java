package demo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class text extends JLayeredPane {
	
	public static JFrame jframe=new JFrame();
	public static ImageIcon back=new ImageIcon("Peashooter/background.jpg");
	public static JLabel background=new JLabel();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jframe.setSize(back.getIconWidth(),back.getIconHeight());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.setTitle("Õ„∂π…‰ ÷");
		jframe.add(background);
		background.setSize(back.getIconWidth(),back.getIconHeight());
		background.setIcon(back);
	//	PeaShooter p = new PeaShooter();
		WallNut b = new WallNut();
		jframe.add(b,0);
		//jframe.add(p,2);
		//Thread t1 = new Thread(p);
		Thread t2 = new Thread(b);
		t2.start();
		//t1.start();
	}

}
