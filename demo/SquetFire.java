package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SquetFire extends plants {
	
	int width = 100;
	int height = 100;
	public SquetFire(int X, int Y) {
		super();
		HP = 10;
		CD = 15;
		attack = 10;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 8; i++) {
	    	getJalapenExplode().add(new ImageIcon("Jalapeno/JalapenoExplode/JalaPenoExplode_" + i + ".png").getImage());
	    }
	    DrawGroup = JalapenExplode;
	}

	  
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(num <= 7) {
		                Thread.sleep(200);
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
