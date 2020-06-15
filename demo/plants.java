package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JLabel;

public class plants extends JLabel{
		//Basic properties
		protected int HP;
		protected int CD;
		protected int attack;
		
		public int getHP() {
			return HP;
		}
		public void setHP(int hP) {
			HP = hP;
		}
		public int getCD() {
			return CD;
		}
		public void setCD(int cD) {
			CD = cD;
		}
		//the plant is planted
		protected static final int empty = 0;
		protected static final int hold = 1;
		protected int tem = empty;

		// check is planted
		public boolean isEmpty() {
			return tem == empty;
		}
		public boolean isHold() {
			return tem == hold;
		}
		
		// change state
		public void goEmpty() {
			tem = empty;
		}
		public void goHold() {
			tem = hold;
		}
		// plants are attacked and lose blood
		public void loseHP(int attack) {
			this.HP = HP - attack;
		}
				
		//check the plant is alive
		public boolean isAlive(int hp) {
			if(hp > 0)
				return true;
			    return false;
		}
				
		//Judge CD is ok
		public boolean isOk(int time) {
			if(time >= CD)
				return true;
				return false;
		}
		
		LinkedList<Image> DrawGroup ;
		LinkedList<Image> Peashooter = new LinkedList<>();
		LinkedList<Image> Snowpea = new LinkedList<>();
		LinkedList<Image> Repeater = new LinkedList<>();
		LinkedList<Image> Sunflower = new LinkedList<>();
		LinkedList<Image> Wallnut = new LinkedList<>();
		LinkedList<Image> Cherrybomb = new LinkedList<>();
		public int num = 0;
		
		public LinkedList<Image> getDrawGroup() {
			return DrawGroup;
		}
		public void setDrawGroup(LinkedList<Image> drawGroup) {
			DrawGroup = drawGroup;
		}
		public LinkedList<Image> getPeashooter() {
			return Peashooter;
		}
		public void setPeashooter(LinkedList<Image> peashooter) {
			Peashooter = peashooter;
		}
		public LinkedList<Image> getSnowpea() {
			return Snowpea;
		}
		public void setSnowpea(LinkedList<Image> snowpea) {
			Snowpea = snowpea;
		}
		public LinkedList<Image> getRepeater() {
			return Repeater;
		}
		public void setRepeater(LinkedList<Image> repeater) {
			Repeater = repeater;
		}
		public LinkedList<Image> getSunflower() {
			return Sunflower;
		}
		public void setSunflower(LinkedList<Image> sunflower) {
			Sunflower = sunflower;
		}
		public LinkedList<Image> getWallnut() {
			return Wallnut;
		}
		public void setWallnut(LinkedList<Image> wallnut) {
			Wallnut = wallnut;
		}
		public LinkedList<Image> getCherrybomb() {
			return Cherrybomb;
		}
		public void setCherrybomb(LinkedList<Image> cherrybomb) {
			Cherrybomb = cherrybomb;
		}
	
		 @Override
	      public void paint(Graphics g)
	      {
	    	  super.paint(g);
	    	  g.drawImage(getDrawGroup().get(num),getX(),getY(),getWidth(),getHeight(),null);
	    	  
	      }
}
