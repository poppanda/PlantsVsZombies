package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class WallNut extends plants implements Runnable {
	int idx = 0;
	int x ;
	int y ;
	int width = 100;
	int height = 100;
	String path = "";
	public WallNut() {
		super();
		HP = 15;
		CD = 15;
		attack = 0;
		 setBounds(0, 0, 100, 100);
	        setVisible(true);
	}

	
	  @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        g.drawImage(new ImageIcon(path + idx + ".png").getImage(),x , y, width, height, this);
	    }
	  @Override
	    public void run()
	    {
	        while(true)
	        {
	        	if(isAlive(this.HP)) {
	            try{
	            	if(HP > 10) {
	            		path = "WallNut/WallNut_";
	            		if(idx <= 15) {
	            			repaint();
	     	                idx ++;
	     	               Thread.sleep(100);
	            		}
	            		else {
	            			idx = 0;
	            		}
	            	}
	            	else if(HP > 5 && HP < 10) {
	            		path = "Wallnut_cracked1/Wallnut_cracked1_";
	            		idx = (idx + 1) % 10;
	            		repaint();
	            		Thread.sleep(100);
	            	}
	            	else if(HP > 0 && HP < 5) {
	            		path = "Wallnut_cracked2/Wallnut_cracked2_";
	            		idx = (idx + 1) % 14;
	            		repaint();
	            		Thread.sleep(100);
	            	}
	            	else {
	            		
	            		break;
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

