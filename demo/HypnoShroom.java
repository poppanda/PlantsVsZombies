package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class HypnoShroom extends plants implements Runnable {
	
	int x ;
	int y ;
	public HypnoShroom(int X, int Y) {
		
		super();
		HP = 6;
		CD = 10;
		attack = 10;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 15; i++) {
	    	getHypnoShroom().add(new ImageIcon("HypnoShroom/HypnoShroom/HypnoShroom_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 12; i++) {
	    	getHypnoShroomSleep().add(new ImageIcon("HypnoShroom/HypnoShroomSleep/HypnoShroomSleep_" + i + ".png").getImage());
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
	            	if(n <= 70) {
	            		DrawGroup = HypnoShroom;
	            		if(num <= 14) {
	    	                Thread.sleep(100);
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	//sleep 3s
	            	else if(n > 70 && n < 100) {
	            		DrawGroup = HypnoShroomSleep;
	            		if(num <= 12) {
	    	                Thread.sleep(100);
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	else {
	            		n = 0;
	            		DrawGroup = HypnoShroom;
	            		if(num <= 14) {
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