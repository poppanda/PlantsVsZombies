package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SnowPea extends plants  {
	
	public SnowPea(int X, int Y) {
		super();
		HP = 6;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    
	    for(int i = 0; i < 15; i++) {
	    	getSnowpea().add(new ImageIcon("./img/Plants/SnowPea/SnowPea_" + i + ".png").getImage());
	    }
	    DrawGroup = Snowpea;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive()) {
	            try{
	            	state = ATTACK_STATE;
	            	if(BulletsList.size() == 0) {
	            		BulletsList.add(new Bullets(x+10,y));
	            	}
	            	Thread t = new Thread(BulletsList.getFirst());
	            	t.start();
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
	        		break;
	        	}
	        }
}
	  
}
