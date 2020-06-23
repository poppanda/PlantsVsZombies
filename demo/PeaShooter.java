package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PeaShooter extends plants {
	int idx = 0;
	int shoot = 13;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	static LinkedList<Image> pic= new LinkedList<>();
	 LinkedList<Image> draw = new LinkedList<>();
	public PeaShooter(int X, int Y) {
		super();
		HP = 6;
		CD = 6;
		attack = 2;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 13; i++) {
	    	getPeashooter().add(new ImageIcon("Peashooter/Peashooter/Peashooter_" + i + ".png").getImage());
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
	            	if(num <= 12) {
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
