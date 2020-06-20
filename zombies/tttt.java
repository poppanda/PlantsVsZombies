package zombies;
//for my test if the cartoon can run 
import javax.swing.*;
import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;

public class tttt {

	public static void main(String[] args) {
		
		JFrame frame=new JFrame();
		frame.setBounds(300,200,800,600);
		frame.setResizable(false);
		Zombie z = new Zombie(3000);
		Thread t = new Thread(z);
		t.start();
		frame.add(z);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		zombieeee z = new zombieeee();
//		Thread t = new Thread(z);
//		t.start();
//	frame.add(z);
		 frame.setVisible(true);
	}

}




class zzz extends JLabel implements Runnable
{
	  int a ; int HP,damage;
	 private int x = 250;
     private int y = (int)(Math.random()*2)*110;
     LinkedList<Image> BoomDie = new LinkedList<>();
     LinkedList<Image> Walk = new LinkedList<>();
     LinkedList<Image> NormDie = new LinkedList<>();
     LinkedList<Image> Eat =  new LinkedList<>();
     LinkedList<Image> DrawGroup = Walk;
     public LinkedList<Image> getBoomDie() {return BoomDie;}
     public LinkedList<Image> getNormDie() {return  NormDie;}
     public LinkedList<Image> getWalk() {return  Walk;}
     public LinkedList<Image> getEat() {return  Eat;}
     public LinkedList<Image> getDrawGroup() {return  DrawGroup;}
     public int getX() {return x;}
     public int getY() {return y;}
     public void setX(int x) {this.x = x;}
     public void setY(int y) {this.y = y;}
     public void  run() {}
     public void paint(Graphics g)
     {
   	  super.paint(g);
   	  g.drawImage(getDrawGroup().get(a),getX(),getY(),null);
   	  
     }

     
     
	
}

class zombieeee extends zzz
{
	
	public zombieeee()
	{
		int i;
		for(i = 0;i<20;i++)
 		{
 			getBoomDie().add(new ImageIcon("src/NormalZombie/BoomDie/BoomDie_"+i+".png").getImage());
 			
 		}
 		for(i = 0;i<10;i++)
 		{
 			getNormDie().add(new ImageIcon("src/NormalZombie/ZombieDie/ZombieDie_"+i+".png").getImage());
 		}
 		for(i = 0;i<22;i++)
 		{
 			getWalk().add(new ImageIcon("src/NormalZombie/Zombie/Zombie_"+i+".png").getImage());
 		}
 		for(i = 0;i<21;i++)
 		{
 			getEat().add(new ImageIcon("src/NormalZombie/ZombieAttack/ZombieAttack_"+i+".png").getImage());
 		}
	}
	
	
	public void run()
	{
		
		while(true)
	  	  {
			
			//System.out.println("A");
	  	    DrawGroup = Walk;
	  		for(a = 0;a<Walk.size();a++)
	  		{
	  			 repaint();
	  			 setX(getX()-2);
	  		     try 
	 		     {
					Thread.sleep(100);
				  } 
	 		     catch (InterruptedException e) 
	 		     {
					e.printStackTrace();
				  }
	  		}
	  		DrawGroup = Eat;
	  		for(a = 0;a<Eat.size();a++)
	  		{
	  			repaint();
	  		     try 
	 		     {
					Thread.sleep(100);
				  } 
	 		     catch (InterruptedException e) 
	 		     {
					e.printStackTrace();
				  }
	  		}
	  		DrawGroup = BoomDie;
	  		for(a = 0;a<BoomDie.size();a++)
	  		{
	  			repaint();
	  		     try 
	 		     {
					Thread.sleep(100);
				  } 
	 		     catch (InterruptedException e) 
	 		     {
					e.printStackTrace();
				  }
	  		}
	  		DrawGroup = NormDie;
	  		for(a = 0;a<NormDie.size();a++)
	  		{
	  			repaint();
	  		     try 
	 		     {
					Thread.sleep(100);
				  } 
	 		     catch (InterruptedException e) 
	 		     {
					e.printStackTrace();
				  }
	  		}
	  	  } 
	}
	
	
	
}


 