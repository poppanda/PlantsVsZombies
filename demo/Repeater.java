package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Repeter extends plants {
	int idx = 0;
	int shoot = 13;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public Repeter(int X, int Y) {
		super();
		HP = 7;
		CD = 9;
		attack = 2;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 13; i++) {
	    	getRepeater().add(new ImageIcon("Repeater_" + idx + ".png").getImage());
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
