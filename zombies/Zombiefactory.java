package zombies;

import zombies.BucketheadZombie;
import zombies.ConeheadZombie;
import zombies.FlagZombie;
import zombies.Zombie;
import zombies.ZombieBasis;

public class Zombiefactory {
    
	public static ZombieBasis getZombie(int type)
	{
		if(type==1)return new Zombie();
		else if(type==2)return new FlagZombie();
		else if(type==3)return new BucketheadZombie();
		else return new ConeheadZombie(); 
		
	}
	
	public static ZombieBasis getRandomZombie() 
	{
        int type = (int) (Math.random() * 4) +1;
        return getZombie(type);
    }
	
}