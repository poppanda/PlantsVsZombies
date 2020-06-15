package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Bullets extends plants implements Runnable {
	int shoot = 1;
	int x = 0 ;
	int y = 0 ;
	int width = 20;
	int height = 20;
	
	public Bullets() {
		super();
		CD = 1;
		attack = 2;
		setBounds(0, 0, 100, 100);
	    setVisible(true);
	}

	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon("Peashooter/Bullets/Bullets_" + shoot + ".png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	            try{
	            		x += 15;
	            		repaint();
	            		Thread.sleep(100);
	            		if(isHit(x,y)) {
	            			shoot++;
	            			repaint();
	            			break;
	            		}
	               
	            }catch(InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	            
	        }
	
}
	  
	  //To determine if a bullet can hit a zombie
	  public Boolean isHit(int x,int y) {
		  if(this.x == x && this.y == y) {
			  return true;
		  }
		  return false;
	  }
}
