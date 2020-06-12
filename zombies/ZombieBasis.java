package zombies;

import javax.swing.*;
import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;

// problem: how to reduce HP by distinguishing the the style of plants

public abstract class ZombieBasis extends JLabel implements Runnable{
      int HP,damage;
      private int width,height;
      private int x = 1420;
      private int y = (int)(Math.random()*5)*110;
      LinkedList<Image> BoomDie = new LinkedList<>();
      LinkedList<Image> Walk = new LinkedList<>();
      LinkedList<Image> NormDie = new LinkedList<>();
      LinkedList<Image> Eat =  new LinkedList<>();
      LinkedList<Image> DrawGroup = Walk;
      final int NormDieWay = 1,BoomDieWay = 2;
      int wayOfDeath;
      public int getX() {return x;}
      public int getY() {return y;}
      public int getWidth() {return width;}
      public int getHeight() {return height;}
      public void setX(int x) {this.x = x;}
      public void setY(int y) {this.y = y;}
      public void setWidth(int width) {this.width = width;}
      public void setHeight(int height) {this.height = height;}
      public void setBoomDie(LinkedList<Image> BoomDie) {this.BoomDie = BoomDie;}
      public void setNormDie(LinkedList<Image> NormDie) {this.NormDie = NormDie;}
      public void setWalk(LinkedList<Image> Walk) {this.Walk  = Walk;}
      public void setEat(LinkedList<Image> Eat) {this.Eat = Eat;}
      public LinkedList<Image> getBoomDie() {return BoomDie;}
      public LinkedList<Image> getNormDie() {return  NormDie;}
      public LinkedList<Image> getWalk() {return  Walk;}
      public LinkedList<Image> getEat() {return  Eat;}
      public LinkedList<Image> getDrawGroup() {return  DrawGroup;}
      
      public int num = 0;
      @Override
      public void run(){ }
      @Override
      public void paint(Graphics g)
      {
    	  super.paint(g);
    	  g.drawImage(getDrawGroup().get(num),getX(),getY(),getWidth(),getHeight(),null);
    	  
      }
      
      public boolean haveplants(plant p)//problem:how to make sure which plant p is
      {
    	  int x1 = this.getX()-p.getWidth();
    	  int x2 = this.getX()+this.getWidth();
    	  int y1 = this.getY()+p.getHeight();
    	  int y2 = this.getY() - this.getHeight();
    	  if(this.getX()<x1)return false;
    	  if(this.getX()>x2)return false;
    	  if(this.getY()<y2)return false;
    	  if(this.getY()>y1)return false;
    	  return true;
      }
      
      public void Boomdeath(plant p)//if the plant isn't eatable,change the way to die
      {
    	  if(!p.eatable) wayOfDeath = BoomDieWay;
      }
      
      public boolean isAlive()//if the zombie is alive
      {
    	  if(HP>0)return true;
    	  return false;
      }
      
      public void die()//the cartoon about zombie's death
      {
    	  if(!isAlive())
    	  {
    		  int countDown;//the number of the frames
    		  if(haveplants(p)&&wayOfDeath==BoomDieWay)
    		  {
    			  DrawGroup = BoomDie;
    			  countDown = BoomDie.size()-1;
    			   num = 0;
    			  
    		  }
    		  else
    		  {
    			  DrawGroup = NormDie;
    			  countDown = NormDie.size()-1;
    			  num = 0;
    		  }
    		  repaint();
    		  while(countDown!=0)
    		  {
    			  try
    			  {
    				  num++;
    				  repaint();
    				  countDown--;
    				  Thread.sleep(30);
    			  }
    			  catch (InterruptedException e) 
        		  {
    				e.printStackTrace();
    			  }
    		  }
    	  }
      }
     
      public boolean iseatable(plant p)//if the plant is eatable
      {
    	  if(p.eatable)return true;
    	  return false;
      }
      
      public boolean iseating()//if the zombie is eating
      {
    	  if(haveplants(p)&&iseatable(p))return true;
    	  return false;
    	  
      }
      
      //the part about eating
      public void eat()//the cartoon about zombie's eating
      {
    	 DrawGroup = Eat;
    	 num = 0;
    	 repaint();
    	 while(haveplants(p))
    	 {
    		 num++;
    		 if(num==DrawGroup.size())num=0;
    		 repaint();
    		 try 
   		     {
				Thread.sleep(30);
			  } 
   		     catch (InterruptedException e) 
   		     {
				e.printStackTrace();
			  }
    		 
    	 } 
      }
         
      public void gethurt(plant p)//waiting for completing
      {
    	  HP = HP - p.attack;
      }
      
      
}