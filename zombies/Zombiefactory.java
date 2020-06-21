package zombies;

import zombies.BucketheadZombie;
import zombies.ConeheadZombie;
import zombies.FlagZombie;
import zombies.Zombie;
import zombies.ZombieBasis;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;

//the file's form is:  wave+count
public class Zombiefactory {
	ExecutorService pool=Executors.newCachedThreadPool();
	int i,num;char c[];
	int delaytime ;
	final int BigWave = 1;
	final int NormWave = 0;
	final int ZombieNum = 1,FlagNum = 3,ConeheadNum = 2,BucketheadNum = 4;
	int style = (int) (Math.random() * 4)+1;
	String s;
	public void getZombie(String filename)
	{
		try
		{
			BufferedReader in=new BufferedReader(new FileReader(filename));
			try 
			{
				while((s = in.readLine())!=null)
				{
					c = s.toCharArray();
					if(c[0]=='0')
					{
						delaytime = (int) (Math.random() * 2000)+2000;
						style = (int) (Math.random() * 2)+1;
					}
						
					if(c[0]=='1')
					{
						delaytime = (int) (Math.random() * 2000);
						style = (int) (Math.random() * 4)+1;
					}
					num = (int)c[1];
					for(i=0;i<num;i++)
					{
						if(style==FlagNum)
						{
							pool.execute(new FlagZombie(delaytime));
						}
						if (style==ConeheadNum)
						{
							pool.execute(new ConeheadZombie(delaytime));
						}
						if(style==BucketheadNum)
						{
							pool.execute(new BucketheadZombie(delaytime));
						}
						if(style==ZombieNum)
						{
							pool.execute(new Zombie(delaytime));
						}
					}
					
				}
				in.close();
				pool.shutdown();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}