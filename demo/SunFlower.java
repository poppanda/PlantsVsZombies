package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class SunFlower extends plants  {

	int width = 100;
	int height = 100;
	public SunFlower(int X, int Y) {
		super();
		HP = 4;
		CD = 6;
		attack = 0;
		this.x = X;
		this.y = Y;
		setBounds(X, Y, 100, 100);
	    setVisible(true);
	    for(int i = 0; i < 18; i++) {
	    	getSunflower().add(new ImageIcon("./img/Plants/SunFlower/SunFlower_" + i + ".png").getImage());
	    }
	    DrawGroup = Sunflower;
	}

	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
		                Thread.sleep(100);
		                num = (num + 1) % 18;
		                repaint();
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
