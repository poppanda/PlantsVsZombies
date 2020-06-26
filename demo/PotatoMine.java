package demo;

package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PotatoMine extends plants  {
	
	int width = 100;
	int height = 100;
	static LinkedList<Image> pic= new LinkedList<>();
	 LinkedList<Image> draw = new LinkedList<>();
	public PotatoMine(int X, int Y) {
		super();
		HP = 4;
		CD = 7;
		attack = 4;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    
	    for(int i = 0; i < 8; i++) {
	    	getPotatoMine().add(new ImageIcon("./img/Plants/PotatoMine/PotatoMine/PotatoMine_" + i + ".png").getImage());
	    }
	    DrawGroup = PotatoMine;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
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
	        		this.goEmpty();
	        		break;
	        	}
	        }
}
	  
	  public int boom() {
		  return this.HP = 0;
	  }
	
}


