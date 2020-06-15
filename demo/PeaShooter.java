package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PeaShooter extends plants implements Runnable {
	int idx = 0;
	int shoot = 13;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public PeaShooter() {
		super();
		HP = 6;
		CD = 6;
		attack = 2;
		 setBounds(0, 0, 100, 100);
	        setVisible(true);
	}

	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon("Peashooter/Peashooter/Peashooter_" + idx + ".png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	        		
	            try{
	                Thread.sleep(100);
	                idx = (idx + 1) % 12;
	                repaint();
	            }catch(InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	            
	        }
	        	else {
	        		this.goEmpty();
	        		break;
	        	}
	        }
}
	 
}
