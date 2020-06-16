package zombies;

import javax.swing.ImageIcon;

public class FlagZombie extends ZombieBasis{
	public FlagZombie(int delaytime)
	{
		super();
		state = 1;
		this.delaytime = delaytime;
		HP = 10;
		damage = 3;
		int i;
		    for(i = 0;i<12;i++)
			{
				getWalk().add(new ImageIcon("src/FlagZombie/FlagZombie/FlagZombie_"+i+".png").getImage());
			}
			for(i = 0;i<11;i++)
			{
				getEat().add(new ImageIcon("src/FlagZombie/FlagZombieAttack/FlagZombieAttack_"+i+".png").getImage());
			}
			for(i = 0;i<10;i++)
			{
				getNormDie().add(new ImageIcon("src/NormalZombie/ZombieDie/ZombieDie_"+i+".png").getImage());
			}
			for(i = 0;i<20;i++)
			{
				getBoomDie().add(new ImageIcon("src/NormalZombie/BoomDie/BoomDie_"+i+".png").getImage());
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