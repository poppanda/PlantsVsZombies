package zombies;

import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class BucketheadZombie extends ZombieBasis{
	
	public BucketheadZombie(int delaytime)
	{
		super();
		HP = 18;
		state = 5;
		this.delaytime = delaytime;
		damage = 3;
		int i;
		for(i = 0;i<15;i++)
		{
			getHatWalk().add(new ImageIcon("src/BucketheadZombie/BucketheadZombie/BucketheadZombie_"+i+".png").getImage());
		}
		for(i = 0;i<11;i++)
		{
			getHatEat().add(new ImageIcon("src/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_"+i+".png").getImage());
		}
		for(i = 0;i<22;i++)
		{
			getWalk().add(new ImageIcon("src/NormalZombie/Zombie/Zombie_"+i+".png").getImage());
		}
		for(i = 0;i<21;i++)
		{
			getEat().add(new ImageIcon("src/NormalZombie/ZombieAttack/ZombieAttack_"+i+".png").getImage());
		}
		for(i = 0;i<20;i++)
		{
			getBoomDie().add(new ImageIcon("src/NormalZombie/BoomDie/BoomDie_"+i+".png").getImage());
		}
		for(i = 0;i<10;i++)
		{
			getNormDie().add(new ImageIcon("src/NormalZombie/ZombieDie/ZombieDie_"+i+".png").getImage());
		}
		for(i = 0;i<12;i++)
		{
			getHead().add(new ImageIcon("src/NormalZombie/ZombieHead/ZombieHead_"+i+".png").getImage());
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
