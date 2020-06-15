package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class WallNut extends plants implements Runnable {
	
	int x ;
	int y ;
	public WallNut() {
		super();
		HP = 15;
		CD = 15;
		attack = 0;
		setBounds(0, 0, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 16; i++) {
	    	getWallnut().add(new ImageIcon("WallNut/WallNut_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 11; i++) {
	    	getWallnut1().add(new ImageIcon("Wallnut_cracked1/Wallnut_cracked1_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 15; i++) {
	    	getWallnut2().add(new ImageIcon("Wallnut_cracked2/Wallnut_cracked2_" + i + ".png").getImage());
	    }
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(HP > 10) {
	            		DrawGroup = Wallnut;
	            		if(num <= 15) {
	    	                Thread.sleep(100);
	    	                
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	else if(HP > 5 && HP < 10) {
	            		DrawGroup = Wallnut1;
	            		if(num <= 10) {
	    	                Thread.sleep(100);
	    	                
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	else if(HP > 0 && HP < 5) {
	            		DrawGroup = Wallnut2;
	            		if(num <= 14) {
	    	                Thread.sleep(100);
	    	                
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	else {
	            		
	            		break;
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

