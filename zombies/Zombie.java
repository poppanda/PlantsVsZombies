package zombies;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Image;
import java.lang.Thread;

import javax.swing.ImageIcon;
public class Zombie extends ZombieBasis{
	public Zombie(int delaytime) 
	{
		super();
		this.delaytime = delaytime;
		state = WALK_STATE;
		HP = 10;
		int i;
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
		for(i = 0;i<12;i++)
		{
			getHead().add(new ImageIcon("./img/Zombies/NormalZombie/ZombieHead/ZombieHead_"+i+".png").getImage());
		}
	}
	@Override
	public void run()
	{
		try
		{
			Thread.sleep(delaytime);
		} 
		catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}
		super.run();
	}
}