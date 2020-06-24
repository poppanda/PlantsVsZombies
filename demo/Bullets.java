package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Bullets extends plants {

	public int x;
	public int y;
	int width = 200;
	int height = 200;
	
	public Bullets(int X, int Y) {
		super();
		CD = 1;
		attack = 2;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
		
	    setVisible(true);
	    getBullets().add(new ImageIcon("Peashooter/Bullets/Bullets_1.png" ).getImage());
	   
	   
	    getBulletsbomb().add(new ImageIcon("Peashooter/Bullets/Bullets_2.png" ).getImage());
	    
	}
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	            try{
	            	DrawGroup = Bullets;
	            	Thread.sleep(100);
	            		x += 15;
	            		repaint();
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
			  return state = HIT_STATE;
		  }
		  return state = AttACK_STATE;
	  }
	  
	  public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
}