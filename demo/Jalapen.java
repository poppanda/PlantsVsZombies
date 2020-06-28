package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Jalapen extends plants  {

	public Jalapen(int X, int Y) {
		super();
		HP = 4;
		CD = 7;
		attack = 4;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    
	    for(int i = 0; i < 8; i++) {
	    	getJalapen().add(new ImageIcon("./img/Plants/Jalapeno/Jalapeno/Jalapeno_" + i + ".png").getImage());
	    }
	    DrawGroup = Jalapen;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive()) {
	            try{
	            	if(num <= 7) {
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
	  
	  public int spurt_fire() {
		  return this.HP = 0;
	  }

}

