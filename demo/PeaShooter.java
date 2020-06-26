package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PeaShooter extends plants {
	
	int width = 100;
	int height = 100;
	static LinkedList<Image> pic= new LinkedList<>();
	 LinkedList<Image> draw = new LinkedList<>();
	public PeaShooter(int X, int Y) {
		super();
		HP = 6;
		CD = 6;
		attack = 2;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    
	    for(int i = 0; i < 13; i++) {
	    	getPeashooter().add(new ImageIcon("./img/Plants/Peashooter/Peashooter_" + i + ".png").getImage());
	    }
	  
	    DrawGroup = Peashooter;
	}

	  @Override
	    public void run()
	    {
		  
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(num == 3) state = ATTACK_STATE;
	            	else state = NORMAL_STATE;
	            	if(BulletsList.size() == 0) {
	            		BulletsList.add(new Bullets(x+10,y));
	            	}
	            	Thread.sleep(100);
	                repaint();
	                num = (num + 1) % 12;
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
	  
	  public Bullets getBullet() {
		  Bullets ret =BulletsList.getFirst();
		  BulletsList.removeFirst();
		  return ret;
	  }
	  
	  public boolean remainBullets() {
		  return BulletsList.size() != 0;
	  }
	 
}
