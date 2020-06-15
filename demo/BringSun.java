package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class BringSun extends plants implements Runnable {
	
	int x ;
	int y ;
	int width = 50;
	int height = 50;
	int time = 0;
	
	public BringSun() {
		super();
		CD = 6;
		attack = 0;
		setBounds(0, 0, 100, 100);
	    setVisible(true);
	}

	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon("SunFlower/0.png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	            try{
	            	//draw once in 10 seconds
	            	Thread.sleep(10000);
	            		repaint();
	            		Thread.sleep(100);
	            }catch(InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	            
	        }
	
}
	  
}
