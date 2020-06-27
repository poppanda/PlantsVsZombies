package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JLabel;

public class plants extends JLabel implements Runnable{
		protected int HP;
		protected int CD;
		protected int attack;
		public int state;
		public final int ATTACK_STATE = 1, HIT_STATE = 2, BOMB_STATE = 3, NORMAL_STATE = 4, CAN_EAT_STATE = 5, EAT_STATE = 6, EATING = 7;
		public int x;
		public int y;
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
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
		protected static final int empty = 0;
		protected static final int hold = 1;
		protected int tem = empty;

		public boolean isEmpty() {
			return tem == empty;
		}
		public boolean isHold() {
			return tem == hold;
		}
		
		public void goEmpty() {
			tem = empty;
		}
		public void goHold() {
			tem = hold;
		}
		public void loseHP(int attack) {
			this.HP = HP - attack;
		}
				
		public boolean isAlive(int hp) {
			if(hp > 0)
				return true;
			    return false;
		}
				
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
		LinkedList<Image> Bulletsbomb = new LinkedList<>();
		LinkedList<Image> Snowbullets = new LinkedList<>();
		LinkedList<Bullets> BulletsList = new LinkedList<Bullets>();
		LinkedList<Image> BombCherry = new LinkedList<>();
		LinkedList<Image> BombPotato = new LinkedList<>();
		
		public int num = 0;
		
		public LinkedList<Image> getBombCherry() {
			return BombCherry;
		}
		public void setBombCherry(LinkedList<Image> bombCherry) {
			BombCherry = bombCherry;
		}
		public LinkedList<Image> getBombPotato() {
			return BombPotato;
		}
		public void setBombPotato(LinkedList<Image> bombPotato) {
			BombPotato = bombPotato;
		}
		
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
		public LinkedList<Image> getBulletsbomb() {
			return Bulletsbomb;
		}
		public void setBulletsbomb(LinkedList<Image> bulletsbomb) {
			Bulletsbomb = bulletsbomb;
		}
		public LinkedList<Image> getSnowbullets() {
			return Snowbullets;
		}
		public void setSnowbullets(LinkedList<Image> snowbullets) {
			Snowbullets = snowbullets;
		}
		public void setSquashAttack(LinkedList<Image> squashAttack) {
			SquashAttack = squashAttack;
		}
		
		public LinkedList<Bullets> getBulletsList() {
			return BulletsList;
		}
		public void setBulletsList(LinkedList<Bullets> bulletsList) {
			BulletsList = bulletsList;
		}
		
		@Override
	      public void paint(Graphics g)
	      {
	    	  super.paint(g);
	    	  g.drawImage(getDrawGroup().get(num),0, 0,null);
	    	  
	      }
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
		public Bullets getBullet(int x, int y) {
			return new Bullets(x, y);
		}
		
		public Bomb getBomb(int x, int y) {
			return new Bomb(x, y);
		}
		
		public boolean involve(int x, int y) {
			return true;
		}
		
		public int isHit(int x, int y) {
			return state = 2;
		}
}
