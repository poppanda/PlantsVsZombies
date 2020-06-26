package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Chomper extends plants  {
	
	public Chomper(int X, int Y) {
		super();
		HP = 6;
		CD = 10;
		attack = 10;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    
	    for(int i = 0; i < 13; i++) {
	    	getChomper().add(new ImageIcon("./img/Plants/Chomper/Chomper/Chomper_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 9; i++) {
	    	getChomperAttack().add(new ImageIcon("./img/Plants/Chomper/ChomperAttack/ChomperAttack_" + i + ".png").getImage());
	    }
	    for(int i = 0; i < 6; i++) {
	    	getChomperDigest().add(new ImageIcon("./img/Plants/Chomper/ChomperDigest/ChomperDigest_" + i + ".png").getImage());
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
	            		Thread.sleep(100);
		                repaint();
	            		num = (num + 1) % 13;
	            	}
	            	else if(canEat(100,100)) {
	            		DrawGroup = ChomperAttack;
	            		Thread.sleep(100);
		                repaint();
	            		num = (num + 1) % 9;
	            	}
	            	else if(eating()) {
	            		DrawGroup = ChomperDigest;
	            		Thread.sleep(100);
		                repaint();
	            		num = (num + 1) % 6;
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
