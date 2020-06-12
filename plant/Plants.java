package plants;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Plants {
	//基础属性
	protected int HP;
	protected int CD;
	
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getCD() {
		return CD;
	}
	public void setCD(int cD) {
		CD = cD;
	}

	//图片的大小
	protected int height;
	protected int width;
	
	//图片的起始坐标
	protected int x;
	protected int y;
	
	//植物帧数
	public static int cherryBombNum = 6;
	public static int peaShooterNum = 12;
	public static int peaBulletNum = 3;
	public static int repeaterNum = 14;
	public static int snowPeaNum = 14;
	public static int snowBullet = 3;


	public static int wallNutNum = 15;
	public static int wallnut_cracked1Num = 10;
	public static int Wallnut_cracked2Num = 14;
	
	//是否被种植
	protected static final int empty = 0;
	protected static final int hold = 1;
	protected int tem = empty;

	// 判断状态
	public boolean isEmpty() {
		return tem == empty;
	}
	public boolean isHold() {
		return tem == hold;
	}
	
	// 改变状态
	public void goEmpty() {
		tem = empty;
	}
	public void goHold() {
		tem = hold;
	}
	
	
	    //设置植物位置
		public Plants(int x, int y,int height,int width) {
			this.x = x;
			this.y = y;
			this.height = height;
			this.width = width;
		}
		
		// 植物被攻击扣血
		public void loseHP(int attack) {
			this.HP = HP - attack;
		}
		
		//判断植物是否存活
		public boolean isAlive(int hp) {
			if(hp > 0)
				return true;
			return false;
		}
		
		//判断CD时间
		public boolean isOk(int time) {
			if(time >= CD)
				return true;
			return false;
		}
		
		
		
		class sunFlower extends JLabel implements Runnable{
			private int sunFlower_HP = 4;
			private int sunFlower_CD = 6;
			private int time = 0;
			private int tCD = 0;
			//绘制动图
			public void run() {
				while(isAlive(sunFlower_HP)) {
					for(int i = 0; i <= 17; i++) {
						//获取图片
						ImageIcon flower = new ImageIcon("pic/SunFlower_" + i +".png");
						//载入JLabel对象
						JLabel icon = new JLabel(flower);
						//设置位置和大小
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//生产阳光
			public void bringSun(int time) {
				//10秒产生一个阳光
				if(time >= 10) {
					//获取图片
					ImageIcon sun = new ImageIcon("0.png");
					//载入JLabel对象
					JLabel icon = new JLabel(sun);
					//设置位置和大小
					icon.setBounds(x+5, y-5, width, height);
				}
				time ++;
			}
			
			//设置卡片
			public void setCard(int sun, int cd) {
				if(sun >= 50) {
					if(cd >= sunFlower_CD) {
						//获取图片
						ImageIcon card = new ImageIcon("SunFlower0.png");
						//载入JLabel对象
						JLabel icon = new JLabel(card);
						//设置位置和大小(图片大小未测定）
						icon.setBounds(100, 50, width, height);
					}
					else {
						if(cd >= sunFlower_CD/2) {
							ImageIcon card = new ImageIcon("SunFlower1.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
						else {
							ImageIcon card = new ImageIcon("SunFlower2.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
					}
				}
				else {
					ImageIcon card = new ImageIcon("SunFlower1.png");
					JLabel icon = new JLabel(card);
					icon.setBounds(100, 50, width, height);
				}
			}
			
		}
		
		class peaShooter extends JLabel implements Runnable{
			private int peaShooter_HP = 6;
			private int peaShooter_CD = 6;
			private int time = 0;
			//绘制动图
			public void run() {
				while(isAlive(peaShooter_HP)) {
					for(int i = 0; i <= peaShooterNum; i++) {
						//获取图片
						ImageIcon shoot = new ImageIcon("pic/Peashooter_" + i +".png");
						//载入JLabel对象
						JLabel icon = new JLabel(shoot);
						//设置位置和大小
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//射出子弹
			public void shoot() {
				while(isAlive(peaShooter_HP)) {
					for(int i = 0; i <= peaBulletNum; i++) {
						//获取图片
						ImageIcon image[] = null;
					    image[i] = new ImageIcon("PeaBullet" + i +".png");
						//载入JLabel对象
						JLabel icon[] = null;
						icon[i] = new JLabel(image[i]);
						//设置位置和大小
						icon[i].setBounds(x+5, y, width, height);
						if(i > 1) {
							for(int j = 0; j <= i - 1; j++) {
								icon[j].setBounds(x+5, y, width, height);
							}
						}
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
				
		}
			
			//设置卡片
			public void setCard(int sun, int cd) {
				if(sun >= 100) {
					if(cd >= peaShooter_CD) {
						//获取图片
						ImageIcon card = new ImageIcon("Peashooter0.png");
						//载入JLabel对象
						JLabel icon = new JLabel(card);
						//设置位置和大小(图片大小未测定）
						icon.setBounds(100+width, 50, width, height);
					}
					else {
						if(cd >= peaShooter_CD/2) {
							ImageIcon card = new ImageIcon("SunFlower1.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
						else {
							ImageIcon card = new ImageIcon("SunFlower2.png");
							JLabel icon = new JLabel(card);
							icon.setBounds(100, 50, width, height);
						}
					}
				}
				else {
					ImageIcon card = new ImageIcon("SunFlower1.png");
					JLabel icon = new JLabel(card);
					icon.setBounds(100, 50, width, height);
				}
			}
			
	}
		class snowPea extends JLabel implements Runnable{
			private int snowPea_HP = 8;
			private int snowPea_CD = 7;
			private int time = 0;
			//绘制动图
			public void run() {
				while(isAlive(snowPea_HP)) {
					for(int i = 0; i <= snowPeaNum; i++) {
						//获取图片
						ImageIcon flower = new ImageIcon("pic/SnowPea_" + i +".png");
						//载入JLabel对象
						JLabel icon = new JLabel(flower);
						//设置位置和大小
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//射出子弹
			public void shoot() {
				while(isAlive(snowPea_HP)) {
					for(int i = 0; i <= snowPeaNum; i++) {
						//获取图片
						ImageIcon image[] = null;
					    image[i] = new ImageIcon("SnowBullet" + i +".png");
						//载入JLabel对象
						JLabel icon[] = null;
						icon[i] = new JLabel(image[i]);
						//设置位置和大小
						icon[i].setBounds(x+5, y, width, height);
						if(i > 1) {
							for(int j = 0; j <= i - 1; j++) {
								icon[j].setBounds(x+5, y, width, height);
							}
						}
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
				
		}
			
		}
		
		class repeater extends JLabel implements Runnable{
			private int repeater_HP = 8;
			private int repeater_CD = 8;
			private int time = 0;
			//绘制动图
			public void run() {
				while(isAlive(repeater_HP)) {
					for(int i = 0; i <= peaShooterNum; i++) {
						//获取图片
						ImageIcon flower = new ImageIcon("pic/Peashooter_" + i +".png");
						//载入JLabel对象
						JLabel icon = new JLabel(flower);
						//设置位置和大小
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
				
			}
			
			//射出子弹
			public void shoot() {
				while(isAlive(repeater_HP)) {
					for(int i = 0; i <= peaBulletNum; i++) {
						//获取图片
						ImageIcon image[] = null;
					    image[i] = new ImageIcon("PeaBullet" + i +".png");
						//载入JLabel对象
						JLabel icon[] = null;
						icon[i] = new JLabel(image[i]);
						//设置位置和大小
						icon[i].setBounds(x+5, y, width, height);
						i++;
						icon[i].setBounds(x+10, y, width, height);
						if(i > 1) {
							for(int j = 0; j <= i - 1; j++) {
								icon[j].setBounds(x+5, y, width, height);
							}
						}
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
				
		}
			
		}
		
		class cherryBomb extends JLabel implements Runnable{
			private int cherryBomb_HP = 4;
			private int cherryBomb_CD = 12;
			private int cherryBomb_damage = 20;
			private int time = 0;
			//绘制动图
			public void run() {
				while(isAlive(cherryBomb_HP)) {
					for(int i = 0; i <= cherryBombNum; i++) {
						//获取图片
						ImageIcon flower = new ImageIcon("pic/CherryBomb_" + i +".png");
						//载入JLabel对象
						JLabel icon = new JLabel(flower);
						//设置位置和大小
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			//爆炸
			public void bomb() {
				
			}
			
		}
		
		class wallNut extends JLabel implements Runnable{
			private int wallNut_HP = 10;
			private int wallNut_CD = 15;
			private int time = 0;
			//绘制动图
			public void run() {
				while(isAlive(wallNut_HP)) {
					for(int i = 0; i <= wallNutNum; i++) {
						//获取图片
						ImageIcon flower = new ImageIcon("pic/WallNut_" + i +".png");
						//载入JLabel对象
						JLabel icon = new JLabel(flower);
						//设置位置和大小
						icon.setBounds(x, y, width, height);
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
			
			
			
		}
}
