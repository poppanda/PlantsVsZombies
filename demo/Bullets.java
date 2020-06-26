package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Bullets extends plants {

	int width = 20;
	int height = 20;
	
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
	            		repaint();
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
			  return state = HIT_STATE;
		  }
		  return state = AttACK_STATE;
	  }
	  
		
		 public Bullets getBullet() {
			  Bullets ret =BulletsList.getFirst();
			  BulletsList.removeFirst();
			  return ret;
		  }
		  
		  public boolean remainBullets() {
			  return BulletsList.size() != 0;
		  }
}