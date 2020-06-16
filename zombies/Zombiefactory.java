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