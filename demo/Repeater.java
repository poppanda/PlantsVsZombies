package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Repeter extends plants {

	int width = 100;
	int height = 100;
	public Repeter(int X, int Y) {
		super();
		HP = 7;
		CD = 9;
		attack = 2;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    
	    for(int i = 0; i < 15; i++) {
	    	getRepeater().add(new ImageIcon("./img/Plants/RepeaterPea/RepeaterPea_" + i + ".png").getImage());
	    }
	    DrawGroup = Repeater;
	}

	 
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	state = AttACK_STATE;
	            	if(BulletsList.size() == 0) {
	            		BulletsList.add(new Bullets(x+10,y));
	            		BulletsList.add(new Bullets(x+40,y));
	            	}
	            	Thread t1 = new Thread(BulletsList.getFirst());
	            	t1.start();
	            	Thread t2 = new Thread(BulletsList.getLast());
	            	t2.start();
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

}
