package demo;

package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Squash extends plants  {
	
	public Squash(int X, int Y) {
		super();
		HP = 6;
		CD = 10;
		attack = 10;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 17; i++) {
	    	getSquash().add(new ImageIcon("./img/Plants/Squash/Squash/Squash_" + i + ".png").getImage());
	    }
	   
	    getSquashAim().add(new ImageIcon("./img/Plants/Squash/SquashAim/SquashAim_0.png").getImage());
	    
	    for(int i = 0; i < 4; i++) {
	    	getSquashAttack().add(new ImageIcon("./img/Plants/Squash/SquashAttack/SquashAttack_" + i + ".png").getImage());
	    }
	}
	
	public boolean canSit(int X, int Y) {
		if(X - this.x < 150 && Y == this.y)
			return true;
		return false;
	}
	
	public int sit() {
		return this.HP = 0;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(canSit(100,100) == true) {
	            		DrawGroup = Squash;
	            		if(num <= 16) {
	    	                Thread.sleep(100);
	    	                repaint();
	    	                num ++;
	    	            	}
	    	            	else {
	    	            		num = 0;
	    	            	}
	            	}
	            	else if(canSit(100,100) == false) {
	            		DrawGroup = SquashAttack;
	            		if(num <= 3) {
	    	                Thread.sleep(100);
	    	                this.x += 50;
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


