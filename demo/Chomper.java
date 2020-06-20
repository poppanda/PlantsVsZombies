package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Chomper extends plants implements Runnable {
	
	int x ;
	int y ;
	public Chomper() {
		
		super();
		HP = 6;
		CD = 10;
		attack = 10;
		setBounds(0, 0, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 13; i++) {
	    	getChomper().add(new ImageIcon("Chomper/Chomper/Chomper_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 9; i++) {
	    	getChomperAttack().add(new ImageIcon("Chomper/ChomperAttack/ChomperAttack_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 6; i++) {
	    	getChomperDigest().add(new ImageIcon("Chomper/ChomperDigest/ChomperDigest_" + i + ".png").getImage());
	    }
	}
	
	public boolean canEat(int X, int Y) {
		if(X - this.x < 50 && Y == this.y)
			return true;
		return false;
	}
	
	public boolean eating()
	{
		return true;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(canEat(100,100) == false) {
	            		DrawGroup = Chomper;
	            		if(num <= 12) {
	    	                Thread.sleep(100);
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	else if(canEat(100,100)) {
	            		DrawGroup = ChomperAttack;
	            		if(num <= 8) {
	    	                Thread.sleep(100);
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	else if(eating()) {
	            		DrawGroup = ChomperDigest;
	            		if(num <= 5) {
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
