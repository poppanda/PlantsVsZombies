package demo;

package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SunShroom extends plants  {

	int width = 100;
	int height = 100;
	public SunShroom(int X, int Y) {
		super();
		HP = 4;
		CD = 6;
		attack = 0;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    
	    for(int i = 0; i < 10; i++) {
	    	getSunShroom().add(new ImageIcon("./img/Plants/SunShroom/SunShroom/SunShroom_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 10; i++) {
	    	getSunShroomBig().add(new ImageIcon("./img/Plants/SunShroom/SunShroomBig/SunShroomBig_" + i + ".png").getImage());
	    }
	    
	}

	  @Override
	    public void run()
	    {
		    int n = 0;
	        while(true)
	        {
	        	
	        	if(isAlive(this.HP)) {
	        		n++;
	            try{
	            	//12s later be big
	            	if(n <= 120) {
	            		DrawGroup = SunShroom;
	            		if(num <= 9) {
		                Thread.sleep(100);
		                repaint();
		                num ++;
	            		}
	            		else {
	            			num = 0;
	            		}
		            }
	            	else {
	            		DrawGroup = SunShroomBig;
	            		if(num <= 9) {
			                Thread.sleep(100);
			                repaint();
			                num ++;
		            		}
		            		else {
		            			num = 0;
		            		}
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


