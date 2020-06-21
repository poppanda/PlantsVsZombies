package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class CherryBomb extends plants implements Runnable {
	int idx = 0;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public CherryBomb(int X, int Y) {
		super();
		HP = 10;
		CD = 15;
		attack = 10;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 7; i++) {
	    	getCherrybomb().add(new ImageIcon("CherryBomb/boom/CherryBomb_" + i + ".png").getImage());
	    }
	    DrawGroup = Cherrybomb;
	}

	  
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(num <= 6) {
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
	public int boom() {
		return HP = 0;
	}
}