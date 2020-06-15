package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Repeater extends plants implements Runnable {
	int idx = 0;
	int shoot = 13;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public Repeater() {
		super();
		HP = 7;
		CD = 9;
		attack = 2;
		 setBounds(0, 0, 100, 100);
	        setVisible(true);
	}

	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon("Repeater_" + idx + ".png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	                Thread.sleep(100);
	                idx = (idx + 1) % 14;
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


