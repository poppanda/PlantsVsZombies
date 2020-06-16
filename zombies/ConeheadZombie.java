package zombies;

import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class ConeheadZombie extends ZombieBasis {
	int losecap = 6;
	public ConeheadZombie(int delaytime)
	{
		super();
		HP = 15;
		this.delaytime = delaytime;
		state = 5;
		damage = 3;
		int i;
		for(i = 0;i<21;i++)
		{
			getHatWalk().add(new ImageIcon("src/ConeheadZombie/ConeheadZombie/ConeheadZombie_"+i+".png").getImage());
		}
		for(i = 0;i<11;i++)
		{
			getHatEat().add(new ImageIcon("src/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_"+i+".png").getImage());
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
