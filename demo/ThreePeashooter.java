package demo;

package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class ThreePeashooter extends plants  {
	
	public int x ;
	public int y ;
	int width = 100;
	int height = 100;
	static LinkedList<Image> pic= new LinkedList<>();
	 LinkedList<Image> draw = new LinkedList<>();
	public ThreePeashooter(int X, int Y) {
		super();
		HP = 6;
		CD = 6;
		attack = 4;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 17; i++) {
	    	getThreePeashooter().add(new ImageIcon("ThreePeater/ThreePeater_" + i + ".png").getImage());
	    }
	    DrawGroup = ThreePeashooter;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	state = AttACK_STATE;
	            	if(num <= 15) {
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
	 
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
}

