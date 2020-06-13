package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SnowPea extends plants implements Runnable {
	int idx = 0;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public SnowPea() {
		super();
		HP = 6;
		CD = 7;
		attack = 3;
		 setBounds(0, 0, 100, 100);
	        setVisible(true);
	}

	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon("SnowPea/SnowPea_" + "0" + ".png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	x += 10;
	                Thread.sleep(100);
	               // idx = (idx + 1) % 2;
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
