package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Bullets extends plants implements Runnable {

	int x;
	int y;
	int width = 20;
	int height = 20;
	
	public Bullets(int X, int Y) {
		super();
		CD = 1;
		attack = 2;
		setBounds(X, Y, 100, 100);
		x = X;
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
