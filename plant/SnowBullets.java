package plant;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SnowBullets extends plants {

	int width = 20;
	int height = 20;
	
	public SnowBullets(int X, int Y) {
		super();
		setBounds(X, Y, 100, 100);
		this.x = X;
		this.y = Y;
	    setVisible(true);
	    
	    getSnowbullets().add(new ImageIcon("./img/Bullets/PeaNormal/PeaNormal_0.png" ).getImage());
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
	            	this.setBounds(x+20, y, this.width, this.height);
	            		
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
	  
	//to determine if a bulletcan hit a zombie
	  public int isHit(int x,int y) {
		  if(this.y == y) {
			  return state = 2;
		  }
		  return state = 1;
	  }
	
}
