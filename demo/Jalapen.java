package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Jalapen extends plants implements Runnable {
	int idx = 0;
	int shoot = 13;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	static LinkedList<Image> pic= new LinkedList<>();
	 LinkedList<Image> draw = new LinkedList<>();
	public Jalapen() {
		super();
		HP = 4;
		CD = 7;
		attack = 4;
		setBounds(0, 0, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 8; i++) {
	    	getJalapen().add(new ImageIcon("Jalapeno/Jalapeno/Jalapeno_" + i + ".png").getImage());
	    }
	    DrawGroup = Jalapen;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(num <= 7) {
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
	  
	  public int spurt_fire() {
		  return this.HP = 0;
	  }
	 
}

