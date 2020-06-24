package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SnowBullets extends plants {

	public int x;
	public int y;
	int width = 20;
	int height = 20;
	
	public SnowBullets(int X, int Y) {
		super();
		CD = 1;
		attack = 2;
		setBounds(X, Y, 100, 100);
		this.x = X;
		this.y = Y;
	    setVisible(true);
	    getSnowbullets().add(new ImageIcon("SnowPea/0.png" ).getImage());
	    DrawGroup = Snowbullets;
	}
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	            try{
	            	repaint();
	            	Thread.sleep(100);
	            		x += 15;
	            		
	            		if(state == HIT_STATE) {
	            			DrawGroup = Bulletsbomb;
	            			repaint();
	            			break;
	            		}
	               
	            }catch(InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	            
	        }
	
}
	  
	  //判断子弹是否可以击中僵尸
	  public int isHit(int x,int y) {
		  if(this.y == y) {
			  return state = 2;
		  }
		  return state = 1;
	  }
	  
	  public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
}
