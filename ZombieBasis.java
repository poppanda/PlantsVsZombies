package text;

public abstract class ZombieBasis {
       int selflife,caplife,damage=100,speed;
       public ZombieBasis(int selflife,int caplife,int speed) 
       {
    	   this.selflife = selflife;
    	   this.speed = speed;
    	   this.caplife = caplife;
       }
       int bodydamage1 = (selflife/3)*2;
       int bodydamage2 = selflife/3;
       int capdamage1 = (caplife/3)*2;
       int capdamage2 = caplife/3;
       void picChange() {}
       void run() {}
       void getHurt() {}
       boolean havePlants() {}
       boolean isAlive() {}
       void die() {}
       
}

interface SpeedChange{
	void speedChange();
}

class Zombie extends ZombieBasis{
	Zombie()
	{
		super(270,0,s);//sΪ4.7������һ����ٶ�
	}
	
}

class FlagZombie extends ZombieBasis{
	FlagZombie()
	{
		super(270,0,s);//sΪ3.7������һ����ٶ�
	}
	
}

class ConeheadZombie extends ZombieBasis{
	ConeheadZombie()
	{
		super(270,370,s);//sΪ4.7������һ����ٶ�
	}
}

class Polevaulting extends ZombieBasis implements SpeedChange{
	Polevaulting()
	{
		super(500,0,s);//sΪ2.5������һ����ٶ�
	}
	public void speedChange()
	{
		super.speed = s;//sΪ4.7������һ����ٶ�
	}
	
}

class BucketheadZombie extends ZombieBasis{
	BucketheadZombie()
	{
		super(270,1100,s);//sΪ4.7������һ����ٶ�
	}
	
}