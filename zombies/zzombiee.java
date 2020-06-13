package zombies;
import javax.swing.*;
import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;

//the class is for our group's test on 6.12


class fortest extends JLabel implements Runnable
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

public class zzombiee extends fortest
{
	
	public zzombiee()
	{
		int i;
		setBounds(400, 400, 400, 400);
		setVisible(true);
		for(i = 0;i<20;i++)
 		{
 			getBoomDie().add(new ImageIcon("./img/Zombies/NormalZombie/BoomDie/BoomDie_"+i+".png").getImage());
 			
 		}
 		for(i = 0;i<10;i++)
 		{
 			getNormDie().add(new ImageIcon("./img/Zombies/NormalZombie/ZombieDie/ZombieDie_"+i+".png").getImage());
 		}
 		for(i = 0;i<22;i++)
 		{
 			getWalk().add(new ImageIcon("./img/Zombies/NormalZombie/Zombie/Zombie_"+i+".png").getImage());
 		}
 		for(i = 0;i<21;i++)
 		{
 			getEat().add(new ImageIcon("./img/Zombies/NormalZombie/ZombieAttack/ZombieAttack_"+i+".png").getImage());
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