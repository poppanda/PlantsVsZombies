package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SnowPea extends plants  {
	
	public int x ;
	public int y ;
	int width = 100;
	int height = 100;
	public SnowPea(int X, int Y) {
		super();
		HP = 6;
		CD = 7;
		attack = 3;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 15; i++) {
	    	getSnowpea().add(new ImageIcon("SnowPea/SnowPea_" + i + ".png").getImage());
	    }
	    DrawGroup = Snowpea;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	state = AttACK_STATE;
	            	if(num <= 14) {
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
	 
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
}
