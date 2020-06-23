package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SnowBullets extends plants  {

	int x;
	int y;
	int width = 20;
	int height = 20;
	
	public SnowBullets(int X, int Y) {
		super();
		CD = 1;
		attack = 2;
		setBounds(X, Y, 100, 100);
		x = X;
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
	            	
	            	Thread.sleep(100);
	            		x += 15;
	            		repaint();
	            		if(isHit(x,y)) {
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
	  public Boolean isHit(int x,int y) {
		  if(this.x == x && this.y == y) {
			  return true;
		  }
		  return false;
	  }
}
