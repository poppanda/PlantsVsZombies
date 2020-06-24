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

//the file's form is:  wave(‘1’is a big wave,‘0’ is normal wave)+count(the count of all types zombies)
public class Zombiefactory {
	public void getZombie(String filename，,AdventurePane pane)
	{
		String s;
		int i,num;char c[];
		final char BigWave = '1';
		final char NormWave = '0';
		final int ZombieNum = 1,FlagNum = 3,ConeheadNum = 2,BucketheadNum = 4;
		try
		{
			BufferedReader in=new BufferedReader(new FileReader(filename));
			try 
			{
				while((s = in.readLine())!=null)
				{
					c = s.toCharArray();
					delaytime = (int) (Math.random() * 2000)+2000;
					style = (int) (Math.random() * 2)+1;	
					if(c[0]==BigWave)
					{
						delaytime = (int) (Math.random() * 2000);
						style = (int) (Math.random() * 4)+1;
					}
					num = (int)c[1];
					for(i=0;i<num;i++)
					{
						if(style==FlagNum)
						{
							pane.addZombie(new FlagZombie(delaytime));
						}
						if (style==ConeheadNum)
						{
							pane.addZombie(new ConeheadZombie(delaytime));
						}
						if(style==BucketheadNum)
						{
							pane.addZombie(new BucketheadZombie(delaytime));
						}
						if(style==ZombieNum)
						{
							pane.addZombie(new Zombie(delaytime));
						}
					}
					
				}
				in.close();
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