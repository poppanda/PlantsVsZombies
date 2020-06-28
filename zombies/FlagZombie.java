package zombies;

import javax.swing.ImageIcon;

public class FlagZombie extends ZombieBasis{
	public FlagZombie(int delaytime)
	{
		super();
		state = WALK_STATE;
		this.delaytime = delaytime;
		HP = 10;
		int i;
		    for(i = 0;i<12;i++)
			{
				getWalk().add(new ImageIcon("./img/Zombies/FlagZombie/FlagZombie/FlagZombie_"+i+".png").getImage());
			}
			for(i = 0;i<11;i++)
			{
				getEat().add(new ImageIcon("./img/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_"+i+".png").getImage());
			}
			for(i = 0;i<10;i++)
			{
				getNormDie().add(new ImageIcon("./img/Zombies/NormalZombie/ZombieDie/ZombieDie_"+i+".png").getImage());
			}
			for(i = 0;i<20;i++)
			{
				getBoomDie().add(new ImageIcon("./img/Zombies/NormalZombie/BoomDie/BoomDie_"+i+".png").getImage());
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