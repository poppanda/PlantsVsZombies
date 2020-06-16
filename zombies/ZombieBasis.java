package zombies;

import javax.swing.*;
import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;


public abstract class ZombieBasis extends JLabel implements Runnable{
      int HP,damage,losehat=10;
      private int x = 250;
      private int y = (int)(Math.random()*2)*110;
      LinkedList<Image> BoomDie = new LinkedList<>();
      LinkedList<Image> Walk = new LinkedList<>();
      LinkedList<Image> NormDie = new LinkedList<>();
      LinkedList<Image> Eat =  new LinkedList<>();
      LinkedList<Image> HatWalk= new LinkedList<>();
      LinkedList<Image> HatEat= new LinkedList<>();
      LinkedList<Image> Head= new LinkedList<>();
      LinkedList<Image> DrawGroup = Walk;
      final int NormDieWay = 1,BoomDieWay = 2;
      public int getX() {return x;}
      public int getY() {return y;}
      public void setX(int x) {this.x = x;}
      public void setY(int y) {this.y = y;}
      public void setBoomDie(LinkedList<Image> BoomDie) {this.BoomDie = BoomDie;}
      public void setNormDie(LinkedList<Image> NormDie) {this.NormDie = NormDie;}
      public void setWalk(LinkedList<Image> Walk) {this.Walk  = Walk;}
      public void setEat(LinkedList<Image> Eat) {this.Eat = Eat;}
      public void setHatWalk(LinkedList<Image> HatWalk){this.HatWalk = HatWalk;}
      public void setHatEat(LinkedList<Image> HatEat){this.HatEat = HatEat;}
      public LinkedList<Image> getBoomDie() {return BoomDie;}
      public LinkedList<Image> getNormDie() {return  NormDie;}
      public LinkedList<Image> getWalk() {return  Walk;}
      public LinkedList<Image> getEat() {return  Eat;}
      public LinkedList<Image> getDrawGroup() {return  DrawGroup;}
      public LinkedList<Image> getHatWalk(){return HatWalk;}
      public LinkedList<Image> getHatEat(){return HatEat;}
      public LinkedList<Image> getHead(){return Head;}
      public int num = 0,state,delaytime;
     
      public void walk()
      {
    	  if(HP>10)state = 5;
    	  else state = 1;
      }
      public void eat()
      {
    	  if(HP>10)state = 6;
    	  else state = 2;
      }
      public void boomdie()
      {
    	  state = 4;
      }
      public void normdie()
      {
    	  state = 3;
      }
      
      @Override
      public void run()
      { 
    	  while(true)
    	  {
    		  if(state == 1)Walk();
    		  if(state == 2)Eat();
    		  if(state == 3)
    		  {
    			  NormDie();
    			  break;
    		  }
    		  if(state == 4)
    		  {
    			  BoomDie();
    			  break;
    		  }
    		  if(state == 5)HatWalk();
    		  if(state == 6)HatEat();
    	  }
      }

      @Override
      public void paint(Graphics g)
      {
    	  super.paint(g);
    	  if(state==3)
    	  {
    		  g.drawImage(getHead().get(num),getX()+50,getY()+30,null);
           	  g.drawImage(getDrawGroup().get(num),getX(),getY(),null);
    	  }
    	  else g.drawImage(getDrawGroup().get(num),getX(),getY(),null);
      }
      
      public void HatWalk()
      {
    	 DrawGroup = HatWalk;
     	 num = 0;
     	 while(true)
     	 {
     		 if(HP<=10)state=1;//when the HP is less than 10,the zombie will lose its hat
     		 if(state!=5)break;
     		 num++;
     		 if(num==DrawGroup.size())num=0;
     		 setX(getX()-1);
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
      
      public void Walk()
      {
    	 DrawGroup = Walk;
     	 num = 0;
     	 repaint();
     	 while(true)
     	 {
     		 if(state!=1)break;
     		 num++;
     		 if(num==DrawGroup.size())num=0;
     		 setX(getX()-1);
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
      
      public void BoomDie()
      {
    	int countDown;
    	DrawGroup = BoomDie;
		countDown = BoomDie.size()-1;
		num = 0;
		while(countDown!=0)
		  {
			try
			{
				num++;
				repaint();
				countDown--;
				Thread.sleep(100);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		  }
		
      }
      
      public void NormDie()
      {
    		int countDown;
    		DrawGroup = NormDie;
    		countDown = NormDie.size()-1;
    		num = 0;
    		repaint();
    		while(countDown!=0)
    		{
    			try
    			{
    				num++;
    				repaint();
    				countDown--;
    				Thread.sleep(100);
    			}
    			catch (InterruptedException e) 
        		{
    				e.printStackTrace();
    			}
    		}
      } 
      
      public void HatEat()
      {
    	 DrawGroup = HatEat;
      	 num = 0;
      	 while(true)
      	 {
      		 if(HP<=10)state=2;//when the HP is less than 10,the zombie will lose its hat
      		 if(state!=6)break;
      		 num++;
      		 if(num==DrawGroup.size())num=0;
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
      
      public void Eat()
      {
     	 DrawGroup = Eat;
      	 num = 0;
      	 repaint();
      	 while(true)
      	 {
      		 if(state!=2)break;
      		 num++;
      		 if(num==DrawGroup.size())num=0;
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
         
      public void getHurt(int damage)
      {
    	  HP = HP - damage;
      }
      
}