package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JLabel;

public class plants extends JLabel{
	
		//»ù´¡ÊôÐÔ
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
		//ÊÇ·ñ±»ÖÖÖ²
		protected static final int empty = 0;
		protected static final int hold = 1;
		protected int tem = empty;

		// ÅÐ¶Ï×´Ì¬
		public boolean isEmpty() {
			return tem == empty;
		}
		public boolean isHold() {
			return tem == hold;
		}
		
		// ¸Ä±ä×´Ì¬
		public void goEmpty() {
			tem = empty;
		}
		public void goHold() {
			tem = hold;
		}
		// Ö²Îï±»¹¥»÷¿ÛÑª
		public void loseHP(int attack) {
			this.HP = HP - attack;
		}
				
		//ÅÐ¶ÏÖ²ÎïÊÇ·ñ´æ»î
		public boolean isAlive(int hp) {
			if(hp > 0)
				return true;
			    return false;
		}
				
		//ÅÐ¶ÏCDÊ±¼ä
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
		LinkedList<Image> Cherrybomb = new LinkedList<>();
		LinkedList<Image> Wallnut = new LinkedList<>();
		LinkedList<Image> Wallnut1 = new LinkedList<>();
		LinkedList<Image> Wallnut2 = new LinkedList<>();
		LinkedList<Image> Bullets = new LinkedList<>();
		LinkedList<Image> Chomper = new LinkedList<>();
		LinkedList<Image> ChomperAttack = new LinkedList<>();
		LinkedList<Image> ChomperDigest = new LinkedList<>();
		LinkedList<Image> HypnoShroom = new LinkedList<>();
		LinkedList<Image> HypnoShroomSleep = new LinkedList<>();
		LinkedList<Image> Jalapen = new LinkedList<>();
		LinkedList<Image> JalapenExplode = new LinkedList<>();
		LinkedList<Image> PotatoMine = new LinkedList<>();
		LinkedList<Image> PotatoMineExplode = new LinkedList<>();
		LinkedList<Image> Squash = new LinkedList<>();
		LinkedList<Image> SquashAim = new LinkedList<>();
		LinkedList<Image> SquashAttack = new LinkedList<>();
		LinkedList<Image> ThreePeashooter = new LinkedList<>();
		LinkedList<Image> SunShroom = new LinkedList<>();
		LinkedList<Image> SunShroomBig = new LinkedList<>();
		
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
		public LinkedList<Image> getWallnut1() {
			return Wallnut1;
		}
		public void setWallnut1(LinkedList<Image> wallnut1) {
			Wallnut1 = wallnut1;
		}
		public LinkedList<Image> getWallnut2() {
			return Wallnut2;
		}
		public void setWallnut2(LinkedList<Image> wallnut2) {
			Wallnut2 = wallnut2;
		}
		public LinkedList<Image> getCherrybomb() {
			return Cherrybomb;
		}
		public void setCherrybomb(LinkedList<Image> cherrybomb) {
			Cherrybomb = cherrybomb;
		}
	
		 public LinkedList<Image> getBullets() {
			return Bullets;
		}
		public void setBullets(LinkedList<Image> bullets) {
			Bullets = bullets;
		}
		
		public LinkedList<Image> getChomper() {
			return Chomper;
		}
		public void setChomper(LinkedList<Image> chomper) {
			Chomper = chomper;
		}
		public LinkedList<Image> getHypnoShroom() {
			return HypnoShroom;
		}
		public void setHypnoShroom(LinkedList<Image> hypnoShroom) {
			HypnoShroom = hypnoShroom;
		}
		public LinkedList<Image> getJalapen() {
			return Jalapen;
		}
		public void setJalapen(LinkedList<Image> jalapen) {
			Jalapen = jalapen;
		}
		public LinkedList<Image> getPotatoMine() {
			return PotatoMine;
		}
		public void setPotatoMine(LinkedList<Image> potatoMine) {
			PotatoMine = potatoMine;
		}
		public LinkedList<Image> getSquash() {
			return Squash;
		}
		public void setSquash(LinkedList<Image> squash) {
			Squash = squash;
		}
		public LinkedList<Image> getThreePeashooter() {
			return ThreePeashooter;
		}
		public void setThreePeashooter(LinkedList<Image> threePeashooter) {
			ThreePeashooter = threePeashooter;
		}
		public LinkedList<Image> getChomperAttack() {
			return ChomperAttack;
		}
		public void setChomperAttack(LinkedList<Image> chomperAttack) {
			ChomperAttack = chomperAttack;
		}
		public LinkedList<Image> getChomperDigest() {
			return ChomperDigest;
		}
		public void setChomperDigest(LinkedList<Image> chomperDigest) {
			ChomperDigest = chomperDigest;
		}
		public LinkedList<Image> getPotatoMineExplode() {
			return PotatoMineExplode;
		}
		public void setPotatoMineExplode(LinkedList<Image> potatoMineExplode) {
			PotatoMineExplode = potatoMineExplode;
		}
		public LinkedList<Image> getSquashAim() {
			return SquashAim;
		}
		public void setSquashAim(LinkedList<Image> squashAim) {
			SquashAim = squashAim;
		}
		public LinkedList<Image> getSquashAttack() {
			return SquashAttack;
		}
		public void setAquashAttack(LinkedList<Image> aquashAttack) {
			SquashAttack = aquashAttack;
		}
		public LinkedList<Image> getHypnoShroomSleep() {
			return HypnoShroomSleep;
		}
		public void setHypnoShroomSleep(LinkedList<Image> hypnoShroomSleep) {
			HypnoShroomSleep = hypnoShroomSleep;
		}
		public LinkedList<Image> getJalapenExplode() {
			return JalapenExplode;
		}
		public void setJalapenExplode(LinkedList<Image> jalapenExplode) {
			JalapenExplode = jalapenExplode;
		}
		public LinkedList<Image> getSunShroom() {
			return SunShroom;
		}
		public void setSunShroom(LinkedList<Image> sunShroom) {
			SunShroom = sunShroom;
		}
		public LinkedList<Image> getSunShroomBig() {
			return SunShroomBig;
		}
		public void setSunShroomBig(LinkedList<Image> sunShroomBig) {
			SunShroomBig = sunShroomBig;
		}
		@Override
	      public void paint(Graphics g)
	      {
	    	  super.paint(g);
	    	  g.drawImage(getDrawGroup().get(num),getX(),getY(),getWidth(),getHeight(),null);
	    	  
	      }
}
