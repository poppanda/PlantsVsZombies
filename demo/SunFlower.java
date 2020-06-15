package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SunFlower extends plants implements Runnable {
	int idx = 0;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public SunFlower() {
		super();
		HP = 4;
		CD = 5;
		attack = 0;
		 setBounds(0, 0, 100, 100);
	        setVisible(true);
	}

	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon("SunFlower/SunFlower_" + idx + ".png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	                Thread.sleep(100);
	                idx = (idx + 1) % 17;
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

