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
		
		
	
}
