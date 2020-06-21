package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SunFlower extends plants implements Runnable {
	int idx = 0;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public SunFlower(int X, int Y) {
		super();
		HP = 4;
		CD = 6;
		attack = 0;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 18; i++) {
	    	getSunflower().add(new ImageIcon("SunFlower/SunFlower_" + i + ".png").getImage());
	    }
	    DrawGroup = Sunflower;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(num <= 17) {
		                Thread.sleep(100);
		                
		                repaint();
		                num ++;
		            	}
		            	else {
		            		num = 0;
		            	}
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
