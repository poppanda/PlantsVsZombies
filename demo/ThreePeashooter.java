package demo;

package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class ThreePeashooter extends plants  {
	
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
	        	if(isAlive(this.HP)) {
	            try{
	            	state = AttACK_STATE;
	            	if(BulletsList.size() == 0) {
	            		BulletsList.add(new Bullets(x+10,y));
	            		BulletsList.add(new Bullets(x+40,y));
	            		BulletsList.add(new Bullets(x+70,y));
	            	}
	            	Thread t1 = new Thread(BulletsList.getFirst());
	            	t1.start();
	            	Thread t2 = new Thread(BulletsList.get(1));
	            	t2.start();
	            	Thread t3 = new Thread(BulletsList.getLast());
	            	t3.start();
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
	 
}

