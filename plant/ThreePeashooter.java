package plant;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class ThreePeashooter extends plants  {
	public ThreePeashooter(int X, int Y) {
		super();
		HP = 60;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 16; i++) {
	    	getThreePeashooter().add(new ImageIcon("./img/Plants/Threepeater/Threepeater_" + i + ".png").getImage());
	    }
	    DrawGroup = ThreePeashooter;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive()) {
	            try{
	            	if(num == 6) state = ATTACK_STATE;
	            	else state = NORMAL_STATE;
	            	if(BulletsList.size() == 0) {
	            		BulletsList.add(new Bullets(x+10,y));
	            		BulletsList.add(new Bullets(x+40,y));
	            		BulletsList.add(new Bullets(x+70,y));
	            	}
	                Thread.sleep(100);
	                num = (num + 1) % 16;
	                repaint();
	             
	            }catch(InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	            
	        }
	        	else {
	        		break;
	        	}
	        }
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

