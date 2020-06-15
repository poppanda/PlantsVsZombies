package demo;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class CherryBomb extends plants implements Runnable {
	int idx = 0;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	public CherryBomb() {
		super();
		HP = 10;
		CD = 15;
		attack = 10;
		 setBounds(0, 0, 100, 100);
	        setVisible(true);
	}

	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon("CherryBomb/boom/CherryBomb_" + idx + ".png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	
	                Thread.sleep(100);
	                idx = (idx + 1) % 6;
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
	public int boom() {
		return HP = 0;
	}
}
