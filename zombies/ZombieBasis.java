package zombies;

import javax.swing.*;
import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;


public abstract class ZombieBasis extends JLabel implements Runnable {
	public int HP, damage, losehat = 10;
	private int x, y, countDown = 1;
	LinkedList < Image > BoomDie = new LinkedList < > ();
	LinkedList < Image > Walk = new LinkedList < > ();
	LinkedList < Image > NormDie = new LinkedList < > ();
	LinkedList < Image > Eat = new LinkedList < > ();
	LinkedList < Image > HatWalk = new LinkedList < > ();
	LinkedList < Image > HatEat = new LinkedList < > ();
	LinkedList < Image > Head = new LinkedList < > ();
	LinkedList < Image > DrawGroup = Walk;
	public final int WALK_STATE = 1, EAT_STATE = 2, NORM_DIE_STATE = 3, BOMB_DIE_STATE = 4,
			HAT_WALK_STATE = 5, HAT_EAT_STATE = 6, DEAD_STATE = 7;
	public ZombieBasis()
	{
		super();
		x = 810;
		y = (int)(Math.random()*5) * 97 + 10;
		setVisible(true);
		setBounds(x, y, 600, 600);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setBoomDie(LinkedList < Image > BoomDie) {
		this.BoomDie = BoomDie;
	}
	public void setNormDie(LinkedList < Image > NormDie) {
		this.NormDie = NormDie;
	}
	public void setWalk(LinkedList < Image > Walk) {
		this.Walk = Walk;
	}
	public void setEat(LinkedList < Image > Eat) {
		this.Eat = Eat;
	}
	public void setHatWalk(LinkedList < Image > HatWalk) {
		this.HatWalk = HatWalk;
	}
	public void setHatEat(LinkedList < Image > HatEat) {
		this.HatEat = HatEat;
	}
	public LinkedList < Image > getBoomDie() {
		return BoomDie;
	}
	public LinkedList < Image > getNormDie() {
		return NormDie;
	}
	public LinkedList < Image > getWalk() {
		return Walk;
	}
	public LinkedList < Image > getEat() {
		return Eat;
	}
	public LinkedList < Image > getDrawGroup() {
		return DrawGroup;
	}
	public LinkedList < Image > getHatWalk() {
		return HatWalk;
	}
	public LinkedList < Image > getHatEat() {
		return HatEat;
	}
	public LinkedList < Image > getHead() {
		return Head;
	}
	public int num = 0, state, delaytime;

	public void walk() {
		if (HP > 10) setState(HAT_WALK_STATE);
		else setState(WALK_STATE);
	}
	public void eat() {
		if (HP > 10) setState(HAT_EAT_STATE);
		else setState(EAT_STATE);
	}
	public void boomdie() {
		setState(BOMB_DIE_STATE);
	}
	public void normdie() {
		setState(NORM_DIE_STATE);
	}

	@Override
	public void run() {
		while (true) {
			if (state == WALK_STATE)
			{
				setX(getX() - 1);
			}
			else if (state == HAT_WALK_STATE)
			{
				DrawGroup = HatWalk;
				setX(getX() - 1);
				if (HP <= 10) setState(WALK_STATE);
			}
			else if (state == NORM_DIE_STATE) {
				countDown--;
			}
			else if (state == BOMB_DIE_STATE) {
				countDown--;
			}
			else if (state == HAT_EAT_STATE)
			{
				if(HP <= 10) setState(EAT_STATE);
			}
			repaint();
			setLocation(getX(), getY());
			if(countDown == 0) break;
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			num = (num + 1) % DrawGroup.size();
		}
		state = DEAD_STATE;
	}
	public void setState(int STATE)
	{
		if(state == STATE) return;
		num = 0;
		if(STATE == BOMB_DIE_STATE)
		{
			DrawGroup = BoomDie;
			countDown = BoomDie.size() - 2;
			state = STATE;
		}
		else if(STATE == NORM_DIE_STATE)
		{
			DrawGroup = NormDie;
			countDown = NormDie.size() - 2;
			state = STATE;
		}
		else if(STATE == WALK_STATE)
		{
			if(HP > 10){
				DrawGroup = HatWalk;
				state = HAT_WALK_STATE;
			}else{
				DrawGroup = Walk;
				state = WALK_STATE;
			}
		}else if(STATE == HAT_WALK_STATE)
		{
			DrawGroup = HatEat;
			state = STATE;
		}else if(STATE == EAT_STATE)
		{
			if(HP > 10){
				DrawGroup = HatEat;
				state = HAT_EAT_STATE;
			}else{
				DrawGroup = Eat;
				state = EAT_STATE;
			}
		}else if(STATE == HAT_EAT_STATE)
		{
			DrawGroup = HatEat;
			state = STATE;
		}else if(STATE == DEAD_STATE)
		{
			state = STATE;
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (state == NORM_DIE_STATE) {
			g.drawImage(getHead().get(num), 0, 60, this);
			g.drawImage(getDrawGroup().get(num), -50, 30, this);
		} else g.drawImage(getDrawGroup().get(num), -50, 30, this);
	}

	public void getHurt(int damage) {
		HP = HP - damage;
	}

}